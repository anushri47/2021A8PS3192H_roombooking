package com.room.bokking.portal.entity;

import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users") //we see user
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID; // you see user?

    @Column(name = "email", unique = true) // yes true
    private String email; // this is email

    private String name; //thisis name

    private String password; //this is some password

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private UserRoles role;
}
