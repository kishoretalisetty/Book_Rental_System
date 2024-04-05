package org.example.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
//@AllArgsConstructor
public class UserRequestDto {

// Email, Password, First Name, Last Name, Role


    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

}
