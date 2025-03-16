package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

@Data
public class Participaties {
    private  Integer id;
    private Integer user_id;
    private Integer fitness_program_id;
    private Integer pay;
    private Integer category_id;

}
