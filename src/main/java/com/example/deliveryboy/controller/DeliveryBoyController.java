package com.example.deliveryboy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.deliveryboy.entity.DeliveryBoy;
import com.example.deliveryboy.service.DeliveryBoyService;

@RestController
@RequestMapping("/delivery-boys")
public class DeliveryBoyController {

    @Autowired
    private DeliveryBoyService deliveryBoyService;

    @GetMapping
    public List<DeliveryBoy> getAllDeliveryBoys() {
        return deliveryBoyService.getAllDeliveryBoys();
    }

    @GetMapping("/{empId}")
    public ResponseEntity<DeliveryBoy> getDeliveryBoyById(@PathVariable Long empId) {
        DeliveryBoy deliveryBoy = deliveryBoyService.getDeliveryBoyById(empId);
        if (deliveryBoy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deliveryBoy);
    }

    @PostMapping
    public DeliveryBoy createDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy) {
        return deliveryBoyService.saveDeliveryBoy(deliveryBoy);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<DeliveryBoy> updateDeliveryBoy(@PathVariable Long empId, @RequestBody DeliveryBoy updatedDeliveryBoy) {
        DeliveryBoy existingDeliveryBoy = deliveryBoyService.getDeliveryBoyById(empId);
        if (existingDeliveryBoy == null) {
            return ResponseEntity.notFound().build();
        }
        updatedDeliveryBoy.setEmp_id(empId);
        DeliveryBoy savedDeliveryBoy = deliveryBoyService.saveDeliveryBoy(updatedDeliveryBoy);
        return ResponseEntity.ok(savedDeliveryBoy);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<Void> deleteDeliveryBoy(@PathVariable Long empId) {
        DeliveryBoy existingDeliveryBoy = deliveryBoyService.getDeliveryBoyById(empId);
        if (existingDeliveryBoy == null) {
            return ResponseEntity.notFound().build();
        }
        deliveryBoyService.deleteDeliveryBoy(empId);
        return ResponseEntity.noContent().build();}
}