package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgramUser;
import net.etfbl.clientfitnesapp.services.FitnessProgramService;
import net.etfbl.clientfitnesapp.services.FitnessProgramUsersService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("fitnessprogramusers")
public class FitnessProgramUserController {

    private final FitnessProgramUsersService fitnessProgramUsersService;

    public FitnessProgramUserController(FitnessProgramUsersService fitnessProgramUsersService) {
        this.fitnessProgramUsersService = fitnessProgramUsersService;
    }

    @GetMapping
    public List<FitnessProgramUser> findAll()
    {
        List<FitnessProgramUser> fitnessProgramUsers=fitnessProgramUsersService.findAll(FitnessProgramUser.class);
        return fitnessProgramUsers;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fitnessProgramUsersService.delete(id);
    }
}
