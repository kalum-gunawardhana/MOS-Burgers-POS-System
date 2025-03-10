package edu.pos.dto;

import edu.pos.util.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private UserType role;
}