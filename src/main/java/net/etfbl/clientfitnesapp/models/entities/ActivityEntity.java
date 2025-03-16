package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.sql.Date;


@Data
@Entity
@Table(name = "activity")
public class ActivityEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "weight")
    private Double weight;
    @Basic
    @Column(name = "repetition")
    private Integer repetition;
    @Basic
    @Column(name = "series")
    private Integer series;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "kilo")
    private Integer kilo;
    @Basic
    @Column(name = "user_id")
    private Integer user_id;

}
