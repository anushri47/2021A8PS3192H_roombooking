package com.room.bokking.portal.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupRequestDTO { // we all rise

    private String email;
    private String name;
    private String password;
    private RoleDTO role;
}
