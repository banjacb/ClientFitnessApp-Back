package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.base.CrudController;
import net.etfbl.clientfitnesapp.models.dto.Image;
import net.etfbl.clientfitnesapp.models.requests.ImageRequest;
import net.etfbl.clientfitnesapp.services.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/images")
public class ImageContoller  extends CrudController<Integer, ImageRequest, Image> {

    private final ImageService imageService;

    public ImageContoller(ImageService imageService) {
        super(imageService, Image.class);
        this.imageService = imageService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable Integer id) throws IOException {
        var image = imageService.downloadImage(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
                .body(image.getFile());
    }

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException{
        return this.imageService.uploadImage(file);
    }
}
