package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.models.dto.AttributeCategory;
import net.etfbl.clientfitnesapp.models.dto.Category;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.services.AttributeCategoryService;
import net.etfbl.clientfitnesapp.services.CategoryService;
import net.etfbl.clientfitnesapp.services.FitnessProgramService;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final AttributeCategoryService attributeCategoryService;
    private final FitnessProgramService fitnessProgramService;

    public CategoryController(CategoryService categoryService, AttributeCategoryService attributeCategoryService, FitnessProgramService fitnessProgramService) {
        this.categoryService = categoryService;
        this.attributeCategoryService = attributeCategoryService;
        this.fitnessProgramService = fitnessProgramService;
    }

    @GetMapping
    List<Category> findAll()
    {
        List<Category> categories=categoryService.findAll(Category.class);
        return  categories;
    }





}
