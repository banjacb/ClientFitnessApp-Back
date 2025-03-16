package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.entities.FitnessProgramEntity;
import net.etfbl.clientfitnesapp.models.entities.UserWeightEntity;
import net.etfbl.clientfitnesapp.repositories.FitnessProgramEntityRepository;
import net.etfbl.clientfitnesapp.repositories.UserWeightEntityRepository;
import net.etfbl.clientfitnesapp.services.UserWeightService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserWeightServiceImpl extends CrudJpaService<UserWeightEntity,Integer> implements UserWeightService {

    private final ModelMapper maper;
    private final UserWeightEntityRepository repository;

    public UserWeightServiceImpl(ModelMapper mapper, UserWeightEntityRepository repository)
    {
        super(repository,mapper, UserWeightEntity.class);
        this.maper=mapper;
        this.repository=repository;
    }
}
