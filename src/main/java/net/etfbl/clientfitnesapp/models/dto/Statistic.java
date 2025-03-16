package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Statistic {
    private Integer id;
    private Date date;
    private String description;
}
