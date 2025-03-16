package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.entities.FitnessProgramUsersEntity;
import net.etfbl.clientfitnesapp.repositories.FitnessProgramUsersEntityRepository;
import net.etfbl.clientfitnesapp.services.FitnessProgramUsersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FitnessProgramUsersServiceImpl extends CrudJpaService<FitnessProgramUsersEntity,Integer> implements FitnessProgramUsersService {

    private final FitnessProgramUsersEntityRepository repository;
    private final ModelMapper maper;


    public FitnessProgramUsersServiceImpl(ModelMapper mapper, FitnessProgramUsersEntityRepository repository)
    {
        super(repository,mapper, FitnessProgramUsersEntity.class);
        this.maper=mapper;
        this.repository=repository;
    }
}
