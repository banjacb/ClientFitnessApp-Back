package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.models.dto.AttributeCategory;
import net.etfbl.clientfitnesapp.models.dto.Category;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.services.AttributeCategoryService;
import net.etfbl.clientfitnesapp.services.CategoryService;
import net.etfbl.clientfitnesapp.services.FitnessProgramService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/attributecategories")
public class AttributeCategoryContoller {

    private final AttributeCategoryService attributeCategoryService;
    private final FitnessProgramService fitnessProgramService;
    private final CategoryService categoryService;

    public AttributeCategoryContoller(AttributeCategoryService attributeCategoryService, FitnessProgramService fitnessProgramService, CategoryService categoryService) {
        this.attributeCategoryService = attributeCategoryService;
        this.fitnessProgramService = fitnessProgramService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<AttributeCategory> findAll()
    {
        List<AttributeCategory> attributeCategories=attributeCategoryService.findAll(AttributeCategory.class);
        return  attributeCategories;
    }

    @GetMapping("/filterAttribute/{id}")
    public List<FitnessProgram> filterAttribute(@PathVariable Integer id)
    {
        List<FitnessProgram> result= new ArrayList<>();
        List<FitnessProgram> allPrograms= fitnessProgramService.findAll(FitnessProgram.class);
        List<Category> allCategories= categoryService.findAll(Category.class);


        for(var c : allCategories)
        {
            for(var p : allPrograms)
            {
                if (c.getId().equals(id) && p.getCategory_id().equals(c.getId()))
                {
                    result.add(p);
                }
            }
        }
        return result;
    }

}
