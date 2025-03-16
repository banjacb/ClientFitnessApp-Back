package net.etfbl.clientfitnesapp.models.requests;

import lombok.Data;

import java.util.Date;

@Data
public class MessageRequest {

    private Integer id;
    private String text_message;
    private  Boolean seen;
    private Date date;
    private Integer sender_id;
    private Integer receiver_id;
    private String name;
    private String surname;

}
