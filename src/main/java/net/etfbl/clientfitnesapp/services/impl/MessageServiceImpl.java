package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.entities.MessageEntity;
import net.etfbl.clientfitnesapp.repositories.MessageEntityRepository;
import net.etfbl.clientfitnesapp.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MessageServiceImpl extends CrudJpaService<MessageEntity,Integer> implements MessageService {

    private final ModelMapper maper;
    private final MessageEntityRepository repository;

    public MessageServiceImpl(ModelMapper mapper, MessageEntityRepository repository)
    {
        super(repository,mapper, MessageEntity.class);
        this.maper=mapper;
        this.repository=repository;
    }
}
