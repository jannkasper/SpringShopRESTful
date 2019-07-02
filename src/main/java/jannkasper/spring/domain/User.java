package jannkasper.spring.domain;

import jannkasper.spring.customValidator.Password;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull(message = "Name cannot be null")
    private String login;

    @Size(min = 3, max = 20, message = "About Me must be between 3 and 20 characters")
    @Password
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval=true)
    private Set<Order> orders = new HashSet<>();

}
