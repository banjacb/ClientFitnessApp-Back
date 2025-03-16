package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.dto.Category;
import net.etfbl.clientfitnesapp.models.entities.CategoryEntity;
import net.etfbl.clientfitnesapp.repositories.CategoryEntityRepository;
import net.etfbl.clientfitnesapp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImpl extends CrudJpaService<CategoryEntity,Integer> implements CategoryService {

    private final CategoryEntityRepository repository;
    private final ModelMapper mapper;


    public CategoryServiceImpl(CategoryEntityRepository repository, ModelMapper mapper) {
        super(repository,mapper,CategoryEntity.class);
        this.repository = repository;
        this.mapper = mapper;
    }




}
