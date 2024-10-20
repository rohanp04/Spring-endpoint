package com.example.deliveryboy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"users\"")  // Quoted table name if it's lowercase or reserved
public class User {

    @Id
    @Column(name = "\"user_id\"", length = 3)  // Quoted column name if necessary
    private String userId;

    @Column(name = "\"name\"", nullable = false, length = 100)
    private String name;

    @Column(name = "\"email\"", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "\"phone_num\"", nullable = false, length = 15)
    private String phoneNum;

    // Constructors
    public User() {}

    public User(String userId, String name, String email, String phoneNum) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
