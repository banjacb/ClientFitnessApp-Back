package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.entities.AttributeCategoryEntity;
import net.etfbl.clientfitnesapp.repositories.AttributeCategoryEntityRepository;
import net.etfbl.clientfitnesapp.services.AttributeCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AttributeCategoryServiceImpl extends CrudJpaService<AttributeCategoryEntity, Integer> implements AttributeCategoryService {

    AttributeCategoryEntityRepository repository;
    ModelMapper modelMapper;

    public AttributeCategoryServiceImpl(ModelMapper modelMapper, AttributeCategoryEntityRepository repository) {
        super(repository, modelMapper, AttributeCategoryEntity.class);
        this.modelMapper=modelMapper;
        this.repository=repository;
    }
}
