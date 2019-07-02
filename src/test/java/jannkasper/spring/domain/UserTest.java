package jannkasper.spring.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public static final String EXPECTED_LOGIN = "Sasha";
    public static final String EXPECTED_PASSWORD = "Sasha123";
    private User user;

    @BeforeEach
    void setUp() throws Exception {
        user = new User();
        user.setLogin("Sasha");
        user.setPassword("Sasha123");
        user.getOrders().add(new Order());

    }

    @Test
    void testUserDetails() throws Exception {
        Assert.assertEquals(EXPECTED_LOGIN, user.getLogin());
        Assert.assertEquals(EXPECTED_PASSWORD, user.getPassword());
        Assert.assertEquals(1, user.getOrders().size());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("UserTest Completed");

    }

}