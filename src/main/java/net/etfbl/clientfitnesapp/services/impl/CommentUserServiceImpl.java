package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.dto.CommentUser;
import net.etfbl.clientfitnesapp.models.entities.CommentUserEntity;
import net.etfbl.clientfitnesapp.repositories.CommentUserEntityRepository;
import net.etfbl.clientfitnesapp.services.CommentUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentUserServiceImpl extends CrudJpaService<CommentUserEntity,Integer> implements CommentUserService {

    private final ModelMapper mapper;
    private  final CommentUserEntityRepository repository;

    public CommentUserServiceImpl(ModelMapper maper, CommentUserEntityRepository repository) {
        super(repository, maper, CommentUserEntity.class);
        this.repository = repository;
        this.mapper=maper;

    }


}
