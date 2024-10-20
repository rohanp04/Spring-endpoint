package com.example.deliveryboy.controller;

import com.example.deliveryboy.entity.Bill;
import com.example.deliveryboy.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long billId) {
        Bill bill = billService.getBillById(billId);
        if (bill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bill);
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billService.saveBill(bill);
    }

    @PutMapping("/{billId}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long billId, @RequestBody Bill updatedBill) {
        Bill existingBill = billService.getBillById(billId);
        if (existingBill == null) {
            return ResponseEntity.notFound().build();
        }
        updatedBill.setBillId(billId);
        Bill savedBill = billService.saveBill(updatedBill);
        return ResponseEntity.ok(savedBill);
    }

    @DeleteMapping("/{billId}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long billId) {
        Bill existingBill = billService.getBillById(billId);
        if (existingBill == null) {
            return ResponseEntity.notFound().build();
        }
        billService.deleteBill(billId);
        return ResponseEntity.noContent().build();
    }
}
