package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.util.Objects;

@Data
@Entity
@Table(name = "participaties")
public class ParticipatiesEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id")
    private Integer user_id;
    @Basic
    @Column(name = "fitness_program_id")
    private Integer fitness_program_id;
    @Basic
    @Column(name = "pay")
    private Integer pay;
    @Basic
    @Column(name="category_id")
    private  Integer category_id;


}
