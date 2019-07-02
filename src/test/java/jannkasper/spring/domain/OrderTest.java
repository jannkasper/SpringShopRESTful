package jannkasper.spring.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderTest {

    public static final Status EXPECTED_STATUS = Status.ACCEPTED;
    public static final String EXPECTED_DATE = "2010-05-20";
    @InjectMocks
    private Order order;

    @Mock
    private User user;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        order.setStatus(Status.ACCEPTED);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try{
             date = format.parse("2010-05-20");
        } catch (java.text.ParseException e){
            e.printStackTrace();
        }
        order.setDate(date);

    }

    @Test
    void testOrderDetails() throws Exception {
        Assert.assertEquals(EXPECTED_STATUS, order.getStatus());
        Assert.assertEquals(EXPECTED_DATE, new SimpleDateFormat("yyyy-MM-dd").format(order.getDate()));
        Assert.assertNotNull(order.getUser());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("UserTest Completed");

    }
}
