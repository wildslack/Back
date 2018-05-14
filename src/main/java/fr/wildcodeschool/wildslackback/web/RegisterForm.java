package fr.wildcodeschool.wildslackback.web;

import lombok.Data;

@Data
public class RegisterForm {
    private String email;
    private String pseudo;
    private String password;
    private String repassword;
}
