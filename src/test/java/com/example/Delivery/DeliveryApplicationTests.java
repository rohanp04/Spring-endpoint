package com.example.Delivery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.deliveryboy.MySpringBootPostgresAppApplication;

@SpringBootTest(classes = MySpringBootPostgresAppApplication.java.class)  // Specify the main configuration class
class DeliveryApplicationTests {

    @Test
    void contextLoads() {
        // This test will pass if the application context loads successfully
    }
}

