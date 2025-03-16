package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.FitnessProgramUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessProgramUsersEntityRepository extends JpaRepository<FitnessProgramUsersEntity,Integer> {
}
