package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FitnessProgramUser {

    private Integer id;
    private Date date;
    private Integer user_id;
    private Integer fitness_program_id;

}
