package net.etfbl.clientfitnesapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "comment_user")
public class CommentUserEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "user_id")
    private Integer user_id;
    @Basic
    @Column(name = "fitness_program_id")
    private Integer fitness_program_id;


}
