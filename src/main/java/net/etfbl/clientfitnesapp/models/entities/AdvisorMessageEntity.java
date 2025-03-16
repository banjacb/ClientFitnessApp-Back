package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "advisor_message")
public class AdvisorMessageEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "seen")
    private Byte seen;
    @Basic
    @Column(name = "category_id")
    private Integer category_id;
    @Basic
    @Column(name = "advisor_id")
    private Integer advisor_id;
    @Basic
    @Column(name = "user_id")
    private Integer user_id;

}
