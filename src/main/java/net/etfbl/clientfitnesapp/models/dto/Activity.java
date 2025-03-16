package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Activity {

    private Integer id;
    private  String name;
    private Double weight;
    private String repetition;
    private String series;
    private Date date;
    private int kilo;
    private Integer user_id;


}
