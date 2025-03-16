package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.util.Arrays;
import java.util.Objects;

@Data
@Entity
@Table(name = "fitness_program")
public class FitnessProgramEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @Basic
    @Column(name = "difficulty")
    private String difficulty;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "image")
    private byte[] image;
    @Basic
    @Column(name = "category_id")
    private Integer category_id;
    @Basic
    @Column(name = "link_you_tube")
    private String link_you_tube;
    @Basic
    @Column(name = "user_id")
    private Integer user_id;
    @Basic
    @Column(name = "image_id")
    private Integer image_id;
    @Basic
    @Column(name = "status")
    private Boolean status;

}
