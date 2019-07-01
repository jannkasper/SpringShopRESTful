package jannkasper.spring.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "table_product")
public class Product extends BaseEntity {

    private String name;
    private String type;
    private Integer amount;

    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.PERSIST)
    @JoinTable(name = "product_order",
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
        inverseJoinColumns = { @JoinColumn(name = "order_id", referencedColumnName = "id")})
    private Set<Order> orders;
}
