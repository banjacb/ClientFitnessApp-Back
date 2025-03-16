package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.base.CrudController;
import net.etfbl.clientfitnesapp.exeptions.NotFoundException;
import net.etfbl.clientfitnesapp.models.dto.*;
import net.etfbl.clientfitnesapp.models.requests.ProgramRequest;
import net.etfbl.clientfitnesapp.services.AttributeCategoryService;
import net.etfbl.clientfitnesapp.services.CategoryService;
import net.etfbl.clientfitnesapp.services.FitnessProgramService;
import net.etfbl.clientfitnesapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/fitnessprograms")
public class FitnessProgramController extends CrudController<Integer, ProgramRequest, FitnessProgram > {

    private final FitnessProgramService fitnessProgramService;
    private final CategoryService categoryService;

    private final UserService userService;

    public FitnessProgramController(FitnessProgramService fitnessProgramService, CategoryService categoryService, UserService userService) {
     super(fitnessProgramService, FitnessProgram.class);
        this.fitnessProgramService = fitnessProgramService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

   /* @GetMapping
    List<FitnessProgram> findAll()
    {
        List<FitnessProgram> fitnessPrograms=fitnessProgramService.findAll(FitnessProgram.class);
        return  fitnessPrograms;
    }*/



    @GetMapping("/{id}")
    public FitnessProgram findById(@PathVariable Integer id) throws NotFoundException {
        FitnessProgram fitnessProgram = fitnessProgramService.findById(id, FitnessProgram.class);
        Integer cat_id=fitnessProgram.getCategory_id();
        Category categoryDTO =categoryService.findById(cat_id, Category.class);
        String categoryName = categoryDTO.getName();
        fitnessProgram.setCategory_name(categoryName);

        return  fitnessProgram;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fitnessProgramService.delete(id);
    }



    @PutMapping("/{id}")
    public FitnessProgram update(@PathVariable Integer id, @RequestBody ProgramRequest programRequest) throws NotFoundException {
        return fitnessProgramService.update(id, programRequest, FitnessProgram.class);
    }


    @GetMapping("/search/{name}")
    public List<FitnessProgram> searchByName(@PathVariable String name)
    {
        List<FitnessProgram> result= new ArrayList<>();
        List<FitnessProgram> allPrograms= fitnessProgramService.findAll(FitnessProgram.class);
        for(var prog : allPrograms)
        {
            if(prog.getName().toLowerCase().contains(name.toLowerCase()))
                result.add(prog);
        }
        return result;
    }

    @GetMapping("/filterCategory/{id}")
    public List<FitnessProgram> filterCategory(@PathVariable Integer id)
    {
        List<FitnessProgram> result= new ArrayList<>();
        List<FitnessProgram> allPrograms= fitnessProgramService.findAll(FitnessProgram.class);
        for(var prog : allPrograms)
        {
            if(prog.getCategory_id().equals(id))
                result.add(prog);
        }
        return result;
    }

    @GetMapping("/findLocation/{id}")
    public String findLocation(@PathVariable Integer id)
    {
        List<FitnessProgram> allPrograms= fitnessProgramService.findAll(FitnessProgram.class);
        String result = "";
        for(var p : allPrograms)
        {
            if(p.getId()==id)
                result=p.getLocation();

        }
        return result;
    }



    @GetMapping("/fpforuser/{id}")
    public  List<FitnessProgram> fpForUser(@PathVariable Integer id)
    {
        List<FitnessProgram> result= new ArrayList<>();
        List<FitnessProgram> all= fitnessProgramService.findAll(FitnessProgram.class);
        for(var p :all)
        {
            if(p.getUser_id()==id)
                result.add(p);
        }

        return result;
    }


    @PutMapping("/{id}/status")
    public FitnessProgram updateStatus(@PathVariable Integer id, @RequestParam boolean status) {
        return fitnessProgramService.updateStatus(id, status);
    }


    @GetMapping("/users/{id}")
    public User getUserForId(@PathVariable Integer id)
    {
        User result= new User();
        List<FitnessProgram> all= fitnessProgramService.findAll(FitnessProgram.class);
        List<User> users= userService.findAll(User.class);
        for(var p : all)
        {
            if(p.getUser_id()==id)
                for(var u : users)
                {
                    if (u.getId()==id)
                        result=u;
                }
        }
        return result;
    }

}
