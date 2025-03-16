package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<UserEntity> findAllByStatus(boolean status);

    UserEntity findByToken(String token);

    UserEntity findByEmail(String email);

}
