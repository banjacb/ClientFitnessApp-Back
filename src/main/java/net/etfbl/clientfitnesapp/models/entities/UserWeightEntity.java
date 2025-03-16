package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "user_weight")
public class UserWeightEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "weight")
    private Double weight;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "user_id")
    private Integer userId;

}
