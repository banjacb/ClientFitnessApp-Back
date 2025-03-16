package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.StatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticEntityRepository extends JpaRepository<StatisticEntity,Integer> {
}
