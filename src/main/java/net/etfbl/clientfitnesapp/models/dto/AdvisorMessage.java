package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AdvisorMessage {
    private Integer id;
    private Date date;
    private String text;
    private Boolean seen;
    private Integer category_id;
    private Integer advisor_id;
    private Integer user_id;
}
