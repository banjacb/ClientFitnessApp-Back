package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.entities.AdvisorMessageEntity;
import net.etfbl.clientfitnesapp.repositories.AdvisorMessageEntityRepository;
import net.etfbl.clientfitnesapp.services.AdvisorMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdvisorMessageServiceImpl extends CrudJpaService<AdvisorMessageEntity,Integer> implements AdvisorMessageService {

    private final AdvisorMessageEntityRepository repository;
    private final ModelMapper mapper;

    public AdvisorMessageServiceImpl(ModelMapper maper, AdvisorMessageEntityRepository repository) {
        super(repository, maper, AdvisorMessageEntity.class);
        this.repository = repository;
        this.mapper=maper;

    }
}
