package jannkasper.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "orders")
@Table(name = "orders")
public class Order extends BaseEntity {

    @PastOrPresent(message = "Date cannot be from future")
    private Date date;

    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_product",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id")})
    private Set<Product> products = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
