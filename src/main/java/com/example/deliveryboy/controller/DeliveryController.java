package com.example.deliveryboy.controller;

import com.example.deliveryboy.entity.Delivery;
import com.example.deliveryboy.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable String deliveryId) {
        Delivery delivery = deliveryService.getDeliveryById(deliveryId);
        if (delivery == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(delivery);
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveDelivery(delivery);
    }

    @PutMapping("/{deliveryId}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable String deliveryId, @RequestBody Delivery updatedDelivery) {
        Delivery existingDelivery = deliveryService.getDeliveryById(deliveryId);
        if (existingDelivery == null) {
            return ResponseEntity.notFound().build();
        }
        updatedDelivery.setDeliveryId(deliveryId);
        Delivery savedDelivery = deliveryService.saveDelivery(updatedDelivery);
        return ResponseEntity.ok(savedDelivery);
    }

    @DeleteMapping("/{deliveryId}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable String deliveryId) {
        Delivery existingDelivery = deliveryService.getDeliveryById(deliveryId);
        if (existingDelivery == null) {
            return ResponseEntity.notFound().build();
        }
        deliveryService.deleteDelivery(deliveryId);
        return ResponseEntity.noContent().build();
    }
}
