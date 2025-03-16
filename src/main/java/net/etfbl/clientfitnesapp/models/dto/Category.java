package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer id;
    private String name;
    private Boolean status;
    private List<AttributeCategory> atts;
}
