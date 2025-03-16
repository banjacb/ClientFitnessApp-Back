package net.etfbl.clientfitnesapp.services;

import net.etfbl.clientfitnesapp.base.CrudService;
import net.etfbl.clientfitnesapp.models.dto.Category;
import net.etfbl.clientfitnesapp.models.dto.CommentUser;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FitnessProgramService extends CrudService<Integer> {

    void saveImage(byte[] data, String name);
    ResponseEntity<byte[]> getImage(String imageName);
    FitnessProgram updateStatus(Integer id, boolean status);



}
