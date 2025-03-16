package net.etfbl.clientfitnesapp.services;

import net.etfbl.clientfitnesapp.base.CrudService;
import net.etfbl.clientfitnesapp.models.dto.User;
import net.etfbl.clientfitnesapp.models.entities.UserEntity;
import net.etfbl.clientfitnesapp.models.requests.BodyRequest;
import net.etfbl.clientfitnesapp.models.requests.RegisterRequest;
import net.etfbl.clientfitnesapp.models.requests.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface UserService extends CrudService<Integer> {

    UserEntity logIn(String username, String password);

    UserEntity registerUser(UserRequest request);

    Boolean confirmEmail(String token);


}