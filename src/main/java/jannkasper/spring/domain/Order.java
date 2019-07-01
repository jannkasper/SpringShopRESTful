package jannkasper.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "table_order")
public class Order extends BaseEntity {

    private Date date;
    private Status status;

    @ManyToMany(mappedBy = "orders")
    private Set<Product> products;

    @ManyToMany(mappedBy = "orders")
    private Set<User> users;
}
