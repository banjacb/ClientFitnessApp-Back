package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.models.dto.UserWeight;
import net.etfbl.clientfitnesapp.services.UserWeightService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/userweights")
public class UserWeightContoller {

    private final UserWeightService userWeightService;

    public UserWeightContoller(UserWeightService userWeightService) {
        this.userWeightService = userWeightService;
    }

    @GetMapping
    List<UserWeight> findAll()
    {
        List<UserWeight> userWeights=userWeightService.findAll(UserWeight.class);
        return  userWeights;
    }
}
