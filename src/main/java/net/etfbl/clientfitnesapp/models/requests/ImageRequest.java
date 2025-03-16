package net.etfbl.clientfitnesapp.models.requests;

import lombok.Data;

@Data
public class ImageRequest {
    private byte[] file;
    private String name;
    private String type;
}
