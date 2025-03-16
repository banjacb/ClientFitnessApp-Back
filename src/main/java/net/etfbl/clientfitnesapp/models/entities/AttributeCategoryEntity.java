package net.etfbl.clientfitnesapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.util.Objects;

@Data
@Entity
@Table(name = "attribute_category")
public class AttributeCategoryEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @Basic
    @Column(name = "category_id")
    private Integer category_id;

}
