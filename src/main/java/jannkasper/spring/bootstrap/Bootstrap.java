package jannkasper.spring.bootstrap;

import jannkasper.spring.domain.Order;
import jannkasper.spring.domain.Product;
import jannkasper.spring.domain.Status;
import jannkasper.spring.domain.User;
import jannkasper.spring.repositories.OrderRepository;
import jannkasper.spring.repositories.ProductRepository;
import jannkasper.spring.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public Bootstrap(UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = loadUser("Michael", "michael100");
        User user2 = loadUser("Jessica", "jessica200");
        User user3 = loadUser("Andrew", "andrew300");


        Product product1 = loadProduct("Monopoly", "game");
        Product product2 = loadProduct("Chair", "furniture");
        Product product3 = loadProduct("Table", "furniture");
        Product product4 = loadProduct("Jacket", "cloth");


        Order order1 = loadOrder(user1, new Product[]{product1,product2});
        Order order2 = loadOrder(user2, new Product[]{product1,product3});
        Order order3 = loadOrder(user1, new Product[]{product4});

    }


    private Product loadProduct(String name, String type){
        Product product = new Product();
        product.setName(name);
        product.setType(type);
        productRepository.save(product);

        return product;
    }

    private User loadUser(String login, String password){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userRepository.save(user);

        return user;
    }

    private Order loadOrder(User user, Product[] products){
        Order order = new Order();
        order.setDate(new Date());
        order.setUser(user);
        order.setStatus(Status.COMPLETED);

        for(Product product : products){
            order.getProducts().add(product);
        }
        orderRepository.save(order);

        return order;
    }
}
