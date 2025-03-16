package net.etfbl.clientfitnesapp.services.impl;

import jakarta.transaction.Transactional;
import net.etfbl.clientfitnesapp.base.CrudJpaService;
import net.etfbl.clientfitnesapp.exeptions.AlredyExistException;
import net.etfbl.clientfitnesapp.models.dto.Category;
import net.etfbl.clientfitnesapp.models.dto.CommentUser;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.models.entities.FitnessProgramEntity;
import net.etfbl.clientfitnesapp.repositories.FitnessProgramEntityRepository;
import net.etfbl.clientfitnesapp.services.FitnessProgramService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FitnessProgramServiceImpl extends CrudJpaService<FitnessProgramEntity,Integer> implements FitnessProgramService {

    private final ModelMapper maper;
    private final FitnessProgramEntityRepository repository;
    private final String PHOTO_PATH = System.getProperty("user.dir") + "/src/main/resources/programImages";

    private final String PHOTO_PAT = "C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";


    public FitnessProgramServiceImpl(ModelMapper mapper, FitnessProgramEntityRepository repository)
    {
        super(repository,mapper,FitnessProgramEntity.class);
        this.maper=mapper;
        this.repository=repository;
    }

    @Override
    public void saveImage(byte[] data, String imageName){
        File photos = new File(PHOTO_PATH);
        File[] files=photos.listFiles();
        for(int i =0; i<files.length; i++){
            if(files[i].getName().equals(imageName))
                throw new AlredyExistException();
        }
        String path = PHOTO_PATH + "/" + imageName;
        try{
            File newFile = new File(path);
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(data);
            fos.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public ResponseEntity<byte[]> getImage(String imageName){
        File photos = new File(PHOTO_PATH);
        File[] files=photos.listFiles();
        for(int i =0; i<files.length; i++){
            if(files[i].getName().equals(imageName)) {
                String path = PHOTO_PATH + "/" + imageName;
                File file =  new File(path);
                byte[] base64encodedData = new byte[0];

                try {
                    base64encodedData = Base64.getEncoder().encode(Files.readAllBytes(file.toPath()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                                file.getName() + "\"")
                        .body(base64encodedData);
            }
        }
        return null;
    }



    public FitnessProgram updateStatus(Integer id, boolean status) {
        FitnessProgramEntity program = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fitness program not found with id: " + id));

        program.setStatus(status);
        return maper.map(repository.save(program), FitnessProgram.class);
    }







}
