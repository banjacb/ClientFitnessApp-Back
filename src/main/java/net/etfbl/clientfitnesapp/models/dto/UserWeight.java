package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserWeight {
    private Integer id;
    private  Double weight;
    private Date date;
    private Integer user_id;
}
