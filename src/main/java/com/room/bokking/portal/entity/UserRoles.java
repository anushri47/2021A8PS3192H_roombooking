package com.room.bokking.portal.entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class UserRoles {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id; // its timeee
    private String roleName; // do fas fas
}
