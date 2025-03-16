package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.dto.User;
import net.etfbl.clientfitnesapp.models.entities.ActivityEntity;
import net.etfbl.clientfitnesapp.models.requests.BodyRequest;
import net.etfbl.clientfitnesapp.repositories.ActivityEntityRepository;
import net.etfbl.clientfitnesapp.services.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl extends CrudJpaService<ActivityEntity, Integer> implements ActivityService {

    private final ActivityEntityRepository repository;
    private final ModelMapper mapper;


    public ActivityServiceImpl(ModelMapper mapper, ActivityEntityRepository repository) {
        super(repository, mapper, ActivityEntity.class);

        this.repository = repository;
        this.mapper = mapper;
    }
}


