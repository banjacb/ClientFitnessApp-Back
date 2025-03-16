package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.base.CrudController;
import net.etfbl.clientfitnesapp.exeptions.NotFoundException;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.models.dto.User;
import net.etfbl.clientfitnesapp.models.entities.UserEntity;
import net.etfbl.clientfitnesapp.models.requests.LoginRequest;
import net.etfbl.clientfitnesapp.models.requests.ProgramRequest;
import net.etfbl.clientfitnesapp.models.requests.RegisterRequest;
import net.etfbl.clientfitnesapp.models.requests.UserRequest;
import net.etfbl.clientfitnesapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/users")
public class UserController extends CrudController<Integer, UserRequest, User > {


    private final UserService userService;

    public UserController(UserService userService) {
        super(userService,User.class);

        this.userService = userService;
    }

    @GetMapping("{id}")
    public  User findById(@PathVariable Integer id)  throws NotFoundException
    {
        return  userService.findById(id, User.class);
    }
/*
     @GetMapping
     public List<User> findAll()
     {
         List<User> users = userService.findAll(User.class);
         return users;
    }
*/
    @PostMapping("/login")
    public UserEntity logIn(@RequestBody LoginRequest request){
        return  userService.logIn(request.getUsername(),request.getPassword());
    }


    @PostMapping("/register")
    public UserEntity signUp(@RequestBody UserRequest request)
    {
         return userService.registerUser(request);

    }



    @RequestMapping("/confirm-account")
    public Boolean confirmUserAccount(@RequestParam("token")String confirmationToken) {
        return userService.confirmEmail(confirmationToken);
    }


    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody UserRequest userRequest) throws NotFoundException {
        return userService.update(id, userRequest, User.class);
    }





}
