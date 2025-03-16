package net.etfbl.clientfitnesapp.services.impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.models.dto.Image;
import net.etfbl.clientfitnesapp.models.entities.ImageEntity;
import net.etfbl.clientfitnesapp.repositories.ImageEntityRepository;
import net.etfbl.clientfitnesapp.services.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class ImageServiceImpl extends CrudJpaService<ImageEntity,Integer> implements ImageService {



    @Value("${spring.servlet.multipart.location}")
    private String FOLDER_PATH;

    private final ImageEntityRepository repository;
    private final ModelMapper modelMapper;
    @PersistenceContext
    private EntityManager entityManager;

    private File path;
    public ImageServiceImpl(ImageEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, ImageEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() throws IOException {
        ClassPathResource imgPath = new ClassPathResource("");


        this.path =new File(imgPath.getFile().getAbsolutePath() + File.separator + FOLDER_PATH);/*new File(resourceLoader.getResource("classpath:store/").getFile().toString() + File.separator + FOLDER_PATH);*/
        System.out.println(this.path.getAbsolutePath());
        if (!path.exists())
            path.mkdir();
      // this.path = htmlPath.getFile();new File(resourceLoader.getResource("classpath:store/").getFile().toString() + File.separator + FOLDER_PATH);
       System.out.println(this.path.getAbsolutePath());
      if (!path.exists())
            path.mkdir();
    }

    @Override
    public Image uploadImage(MultipartFile file) throws IOException
    {
        var name = StringUtils.cleanPath(file.getOriginalFilename());
        var image = ImageEntity.builder().name(name).type(file.getContentType()).file(file.getBytes()).build();
        repository.saveAndFlush(image);
        entityManager.refresh(image);
        Files.write(Path.of(getPath(image)), file.getBytes());
        // logService.info("New image uploaded! Name: " + name);
        Image res = modelMapper.map(image,Image.class);
        return res;

    }

    public Image downloadImage(Integer id)
    {
        ImageEntity image = repository.getById(id);
        var path = getPath(image);
        Path pathToFile = Paths.get(path);


        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(pathToFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image imageDto = modelMapper.map(image, Image.class);
        imageDto.setFile(data);
        //  logService.info("New image downloaded! Address: " + request.getRemoteAddr());
        return imageDto;

    }


    private String getPath(ImageEntity image) {
        var tmp = image.getType().split("/");
        System.out.println(tmp[1]);
        var name = image.getId() + "." + tmp[1];
        var file = this.path + File.separator + name;
        return file;
    }

}
