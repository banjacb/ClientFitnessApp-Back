package net.etfbl.clientfitnesapp.models.requests;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityRequest {

    private Integer id;
    private  String name;
    private Double weight;
    private String repetition;
    private String series;
    private Date date;
    private Integer kilo;
    private Integer user_id;
}
