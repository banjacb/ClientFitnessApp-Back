package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.ActivityEntity;
import net.etfbl.clientfitnesapp.models.entities.AdvisorMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityEntityRepository  extends JpaRepository<ActivityEntity, Integer> {
}
