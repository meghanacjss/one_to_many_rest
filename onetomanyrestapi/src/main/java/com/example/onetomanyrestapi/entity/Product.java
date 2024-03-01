package com.example.onetomanyrestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
@Id
    private int pid;
    private String productName;
    private int qty;
    private int price;

//    @ManyToOne
//    private Customer customer;

}
