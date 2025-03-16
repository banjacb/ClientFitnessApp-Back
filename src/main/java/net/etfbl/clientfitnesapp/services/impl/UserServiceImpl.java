package net.etfbl.clientfitnesapp.services.impl;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.exeptions.AlredyExistException;

import net.etfbl.clientfitnesapp.models.dto.User;
import net.etfbl.clientfitnesapp.models.entities.UserEntity;
import net.etfbl.clientfitnesapp.models.requests.BodyRequest;
import net.etfbl.clientfitnesapp.models.requests.RegisterRequest;
import net.etfbl.clientfitnesapp.models.requests.UserRequest;
import net.etfbl.clientfitnesapp.repositories.UserEntityRepository;
import net.etfbl.clientfitnesapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@Transactional
public class UserServiceImpl extends CrudJpaService<UserEntity,Integer> implements UserService {

    private final JavaMailSender javaMailSender;
    private final UserEntityRepository repository;

    private final ModelMapper mapper;

    public UserServiceImpl(JavaMailSender javaMailSender, ModelMapper maper, UserEntityRepository repository) {
        super(repository, maper, UserEntity.class);

        this.javaMailSender = javaMailSender;
        this.repository = repository;
        this.mapper=maper;
    }

    @Override
    public UserEntity logIn(String username, String pass) {
        List<UserEntity> users = repository.findAll();

        for(UserEntity user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(pass) && user.getRole()==2 && user.getStatus()){
                return user;
            }
            else if(user.getUsername().equals(username) && user.getPassword().equals(pass) && user.getRole()==2 && !user.getStatus()){

                String email= user.getEmail();
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                sendVerificationEmail(email,token);
                user.setStatus(true);
                return  user;

            }
        }
        return null;
    }

    public UserEntity registerUser(UserRequest request) {
        if (repository.existsByUsername(request.getUsername()))
            throw new AlredyExistException();

        System.out.println("ovo su podaci-----"+ request.getFirst_name()+" "+ request.getLast_name());
        UserEntity userEntity= new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setFirst_name(request.getFirst_name());
        userEntity.setLast_name(request.getLast_name());
        userEntity.setCity(request.getCity());
        userEntity.setEmail(request.getEmail());
        userEntity.setRole(request.getRole());
        userEntity.setImage(request.getImage());
        userEntity.setImage_id(request.getImage_id());
        String token = UUID.randomUUID().toString();
        userEntity.setToken(token);

        String encryptedPassword =(request.getPassword());
        userEntity.setPassword(encryptedPassword);
        userEntity.setStatus(false);
        sendVerificationEmail(request.getEmail(), token);
        insert(userEntity, UserEntity.class);
        return userEntity;
    }

    @Value("${spring.mail.username}")
    private String fromMail;

    @Value("${account.verification.url}")
    private String accountVerificationUrl;


    public void sendVerificationEmail(String to,String token) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            mimeMessage.setFrom(new InternetAddress(fromMail));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject("Verifikacija naloga");

            mimeMessage.setText("Da bi verifikovali vaš nalog kliknite na sljedeći link : "
                    + "http://localhost:4200/app-register?token=" + token);
            javaMailSender.send(mimeMessage);
            System.out.println("Mejl je uspešno poslan");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Greška pri slanju mejla: " + e.getMessage());
        }
    }



    @Override
    public Boolean confirmEmail(String token) {
        if(token != null) {
            UserEntity userToken = repository.findByToken(token);
            if (userToken != null) {
                    userToken.setStatus(true);
                    UserEntity updatedUser = repository.save(userToken);
                    if (updatedUser != null) {
                        return true;
                    } else {
                        return false;
                    }

            } else {
                return false;
            }
        } else {
            return false
                    ;
        }
    }






}
