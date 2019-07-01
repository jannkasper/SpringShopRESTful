package jannkasper.spring.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "table_user")
public class User extends BaseEntity {

    private String login;
    private String password;

    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "user_order",
            joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "order_id", referencedColumnName = "id")})
    private Set<Order> orders;

}
