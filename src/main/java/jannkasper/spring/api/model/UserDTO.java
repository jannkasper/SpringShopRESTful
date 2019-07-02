package jannkasper.spring.api.model;

import jannkasper.spring.customValidator.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty(message = "Please provide a login")
    private String login;

    @Password
    @NotEmpty(message = "Please provide a password")
    private String password;
}
