
package com.example.deliveryboy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.deliveryboy.entity.DeliveryBoy;
import com.example.deliveryboy.repository.DeliveryBoyRepository;

@Service
public class DeliveryBoyService {

    @Autowired
    private DeliveryBoyRepository repository;

    public List<DeliveryBoy> getAllDeliveryBoys() {
        return repository.findAll();
    }

    public DeliveryBoy getDeliveryBoyById(Long empId) {
        return repository.findById(empId).orElse(null);
    }

    public DeliveryBoy saveDeliveryBoy(DeliveryBoy deliveryBoy) {
        return repository.save(deliveryBoy);
    }

    public void deleteDeliveryBoy(Long empId) {
        repository.deleteById(empId);}
}