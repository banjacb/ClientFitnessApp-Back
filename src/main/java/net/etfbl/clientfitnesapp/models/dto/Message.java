package net.etfbl.clientfitnesapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Integer id;
    private String text_message;
    private  Boolean seen;
    private Date date;
    private Integer sender_id;
    private Integer receiver_id;
    private String name_sender;
    private String surname_sender;
    private String name_receiver;
    private String surname_receiver;
}
