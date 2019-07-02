package jannkasper.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "products")
@Table(name = "products")
public class Product extends BaseEntity {

    @NotEmpty
    @Size(min = 3, max = 50, message = "About Me must be between 3 and 50 characters")
    private String name;


    private String type;

    @ManyToMany( mappedBy = "products")
    @MapKey(name="id")
    private Set<Order> orders = new HashSet<>();
}
