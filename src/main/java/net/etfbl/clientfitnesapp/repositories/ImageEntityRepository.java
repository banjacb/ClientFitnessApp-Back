package net.etfbl.clientfitnesapp.repositories;

import net.etfbl.clientfitnesapp.models.dto.Image;
import net.etfbl.clientfitnesapp.models.entities.ImageEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageEntityRepository extends JpaRepository<ImageEntity, Integer> {


}
