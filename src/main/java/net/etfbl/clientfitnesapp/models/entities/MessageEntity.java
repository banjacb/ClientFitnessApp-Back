package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "message")
public class MessageEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "text_message")
    private String text_message;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "sender_id")
    private Integer sender_id;
    @Basic
    @Column(name = "receiver_id")
    private Integer receiver_id;

}
