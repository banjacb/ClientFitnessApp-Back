package net.etfbl.clientfitnesapp.models.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {

    private String firstName;
    private String lastName;
    private Integer image_id;
    private byte[] image;
}
