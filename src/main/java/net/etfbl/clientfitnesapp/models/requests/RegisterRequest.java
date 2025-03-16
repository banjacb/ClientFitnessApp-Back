package net.etfbl.clientfitnesapp.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String city;
    private String email;
    private Integer role;
    private String token;
    private Integer image_id;
    private byte[] image;
}
