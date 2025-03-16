package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;

import net.etfbl.clientfitnesapp.models.entities.FitnessProgramEntity;
import net.etfbl.clientfitnesapp.models.entities.ParticipatiesEntity;
import net.etfbl.clientfitnesapp.repositories.CategoryEntityRepository;
import net.etfbl.clientfitnesapp.repositories.FitnessProgramEntityRepository;
import net.etfbl.clientfitnesapp.repositories.ParticipariesRepository;
import net.etfbl.clientfitnesapp.repositories.UserEntityRepository;
import net.etfbl.clientfitnesapp.services.ParticipatiesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ParticipatiesServiceImpl extends CrudJpaService<ParticipatiesEntity, Integer> implements ParticipatiesService {

  private final  ParticipariesRepository repository;
  private final  UserEntityRepository userEntityRepository;
  private final FitnessProgramEntityRepository fitnessProgramEntityRepository;

  private final CategoryEntityRepository categoryEntityRepository;
    ModelMapper mapper;

    public ParticipatiesServiceImpl(ParticipariesRepository repository, ModelMapper modelMapper,  UserEntityRepository userEntityRepository, FitnessProgramEntityRepository fitnessProgramEntityRepository, CategoryEntityRepository categoryEntityRepository) {
        super(repository, modelMapper, ParticipatiesEntity.class);
        this.repository = repository;
        this.userEntityRepository = userEntityRepository;
        this.fitnessProgramEntityRepository = fitnessProgramEntityRepository;
        this.categoryEntityRepository = categoryEntityRepository;
    }


    @Scheduled(cron = "0 0 20 1 * *")
    public void sendEmailNotification(Integer user_id, Integer category_id) {
        var users = userEntityRepository.findAll();
        var participations = repository.findAll();
        var programs = fitnessProgramEntityRepository.findAll();
        List<FitnessProgramEntity> result = new ArrayList<>();

        for (var p : participations) {
            for (var u : users) {
                if (p.getId() == user_id && p.getCategory_id() == category_id) {
                    String email = u.getEmail();
                    for (var f : programs) {
                        if (f.getCategory_id() == category_id) {
                            result.add(f);
                        }
                    }
                    if (!result.isEmpty() && email != null) {
                        System.out.println(result.toString());
                        sendInfoMail(result.toString(), email);
                    }
                }
            }
        }
    }
    @Value("${spring.mail.username}")
    private String fromMail;

    @Value("${account.verification.url}")
    private String accountVerificationUrl;

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendInfoMail(String mailContent, String toEmail) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromMail);
            message.setTo(toEmail);
            message.setSubject("Program pretplate");
            message.setText(mailContent);
            mailSender.send(message);
        } catch (MailException e) {
                }
    }



}
