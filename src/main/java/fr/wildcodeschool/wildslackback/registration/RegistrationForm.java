package fr.wildcodeschool.wildslackback.registration;

import lombok.Data;

@Data
public class RegistrationForm {
    private String email;
    private String password;
    private String nickname;
    private String workspaceName;
}
