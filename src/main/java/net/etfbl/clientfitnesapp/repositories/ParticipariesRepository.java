package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.ParticipatiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipariesRepository extends JpaRepository<ParticipatiesEntity,Integer> {
}
