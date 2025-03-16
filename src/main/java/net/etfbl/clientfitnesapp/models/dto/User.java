package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String city;
    private String email;
    private int role;
    private boolean status;
    private String token;
    private Integer image_id;
    private  byte[] image;
}
