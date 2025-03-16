package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "statistic")
public class StatisticEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "description")
    private String description;

}
