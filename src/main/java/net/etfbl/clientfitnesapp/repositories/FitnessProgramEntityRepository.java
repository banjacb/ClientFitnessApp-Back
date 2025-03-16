package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.dto.CommentUser;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.models.entities.FitnessProgramEntity;
import net.etfbl.clientfitnesapp.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FitnessProgramEntityRepository extends JpaRepository<FitnessProgramEntity,Integer> {



}
