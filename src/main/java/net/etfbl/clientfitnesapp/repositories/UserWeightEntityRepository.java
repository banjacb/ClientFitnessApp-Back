package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.UserWeightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWeightEntityRepository extends JpaRepository<UserWeightEntity,Integer> {
}
