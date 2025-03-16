package net.etfbl.clientfitnesapp.models.requests;

import lombok.Data;

import java.util.Date;

@Data
public class CommentUserRequest {

    private String text;
    private Date date;
    private Integer user_id;
    private Integer fitness_program_id;
}
