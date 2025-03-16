package net.etfbl.clientfitnesapp.services;
import net.etfbl.clientfitnesapp.base.CrudService;
import net.etfbl.clientfitnesapp.models.dto.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService extends CrudService<Integer> {

    Image uploadImage(MultipartFile file) throws IOException;

    Image downloadImage(Integer id);
}
