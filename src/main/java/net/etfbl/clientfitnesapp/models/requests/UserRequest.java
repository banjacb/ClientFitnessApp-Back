package net.etfbl.clientfitnesapp.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String city;
    private String email;
    private int role;
    private boolean status;
    private Integer image_id;
    private byte[] image;
}
