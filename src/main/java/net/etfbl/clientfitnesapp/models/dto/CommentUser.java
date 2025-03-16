package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentUser {
    private Integer id;
    private String text;
    private Date date;
    private Integer user_id;
    private Integer fitness_program_id;
    private String first_name;
    private String last_name;
    private String program_name;
}
