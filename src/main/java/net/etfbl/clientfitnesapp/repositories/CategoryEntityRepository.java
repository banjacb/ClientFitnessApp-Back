package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {
}
