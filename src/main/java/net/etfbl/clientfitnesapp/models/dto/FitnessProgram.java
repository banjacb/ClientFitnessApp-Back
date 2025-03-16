package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

@Data
public class FitnessProgram {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private Integer duration;
    private String difficulty;
    private String location;
    private byte[] image;
    private Integer category_id;
    private String category_name;
    private String link_you_tube;
    private Integer user_id;
    private Integer image_id;
    private Boolean status;

}
