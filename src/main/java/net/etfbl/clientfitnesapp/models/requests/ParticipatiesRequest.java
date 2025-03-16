package net.etfbl.clientfitnesapp.models.requests;

import lombok.Data;

@Data
public class ParticipatiesRequest {

    private Integer user_id;
    private Integer fitness_program_id;
    private Integer pay;
    private Integer category_id;

}
