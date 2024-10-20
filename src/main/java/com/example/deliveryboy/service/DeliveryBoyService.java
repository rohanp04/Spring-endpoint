package com.example.deliveryboy.service;

import com.example.deliveryboy.entity.DeliveryBoy;
import com.example.deliveryboy.repository.DeliveryBoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryBoyService {

    @Autowired
    private DeliveryBoyRepository repository;

    public List<DeliveryBoy> getAllDeliveryBoys() {
        return repository.findAll();
    }
}
