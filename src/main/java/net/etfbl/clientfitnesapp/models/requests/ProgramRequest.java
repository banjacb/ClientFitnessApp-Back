package net.etfbl.clientfitnesapp.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramRequest {

    private String name;
    private Double price;
    private String description;
    private Integer duration;
    private String difficulty;
    private String location;
    private Integer category_id;
    private String link_you_tube;
    private byte[] image;
    private Integer user_id;
    private Integer image_id;
    private Boolean status;


}
