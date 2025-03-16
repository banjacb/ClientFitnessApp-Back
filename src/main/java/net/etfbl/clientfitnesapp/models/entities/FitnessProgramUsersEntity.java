package net.etfbl.clientfitnesapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "fitness_program_users")
public class FitnessProgramUsersEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date_start")
    private Timestamp dateStart;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fitness_program_id", referencedColumnName = "id", nullable = false)
    private FitnessProgramEntity fitnessProgramByFitnessProgramId;

}
