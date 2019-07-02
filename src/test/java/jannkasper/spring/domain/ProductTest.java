package jannkasper.spring.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
    public static final String EXPECTED_NAME = "Chair";
    public static final String EXPECTED_TYPE = "Furniture";
    private Product product;

    @BeforeEach
    void setUp() throws Exception {
        product = new Product();
        product.setName("Chair");
        product.setType("Furniture");
        product.getOrders().add(new Order());

    }

    @Test
    void testUserDetails() throws Exception {
        Assert.assertEquals(EXPECTED_NAME, product.getName());
        Assert.assertEquals(EXPECTED_TYPE, product.getType());
        Assert.assertEquals(1, product.getOrders().size());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("UserTest Completed");

    }

}