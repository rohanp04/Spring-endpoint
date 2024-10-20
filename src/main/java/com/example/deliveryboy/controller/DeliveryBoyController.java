package com.example.deliveryboy.controller;

import com.example.deliveryboy.entity.DeliveryBoy;
import com.example.deliveryboy.service.DeliveryBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryBoyController {

    @Autowired
    private DeliveryBoyService deliveryBoyService;

    @GetMapping("/delivery-boys")
    public List<DeliveryBoy> getAllDeliveryBoys() {
        return deliveryBoyService.getAllDeliveryBoys();
    }
}
