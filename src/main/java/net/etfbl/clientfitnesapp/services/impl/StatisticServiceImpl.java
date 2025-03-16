package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.entities.StatisticEntity;
import net.etfbl.clientfitnesapp.repositories.StatisticEntityRepository;
import net.etfbl.clientfitnesapp.services.StatisticService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StatisticServiceImpl extends CrudJpaService<StatisticEntity,Integer> implements StatisticService {

    private final ModelMapper maper;
    private final StatisticEntityRepository repository;

    public StatisticServiceImpl(ModelMapper mapper, StatisticEntityRepository repository)
    {
        super(repository,mapper, StatisticEntity.class);
        this.maper=mapper;
        this.repository=repository;
    }
}
