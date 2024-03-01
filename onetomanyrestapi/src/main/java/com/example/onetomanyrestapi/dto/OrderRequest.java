package com.example.onetomanyrestapi.dto;

import com.example.onetomanyrestapi.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderRequest {

    private Customer customer;


}
