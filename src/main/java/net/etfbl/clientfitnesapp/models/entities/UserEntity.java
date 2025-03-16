package net.etfbl.clientfitnesapp.models.entities;

import jakarta.persistence.*;
import lombok.*;
import net.etfbl.clientfitnesapp.base.BaseEntity;

import java.util.Objects;

@Data
@Entity
@Table(name = "user")
public class UserEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "first_name")
    private String first_name;
    @Basic
    @Column(name = "last_name")
    private String last_name;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "role")
    private Integer role;
    @Basic
    @Column(name = "status")
    private Boolean status;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "image_id")
    private Integer image_id;
    @Basic
    @Column(name = "image")
    private byte[] image;
}
