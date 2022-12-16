package com.example.templatesample.model;


import com.example.templatesample.model.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Profile {
    private String userName;
    private String email;
    private String password;
    private Role userRole;
    private Integer age;
    private String education;
    private String avatar;
}
