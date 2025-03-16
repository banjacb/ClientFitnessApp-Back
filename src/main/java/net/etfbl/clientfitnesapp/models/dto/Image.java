package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

@Data
public class Image {
    private Integer id;
    private byte[] file;
    private String name;
    private String type;
}
