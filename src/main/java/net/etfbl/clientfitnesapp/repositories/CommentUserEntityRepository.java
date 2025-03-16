package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.dto.CommentUser;
import net.etfbl.clientfitnesapp.models.entities.CommentUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentUserEntityRepository extends JpaRepository<CommentUserEntity,Integer> {

}
