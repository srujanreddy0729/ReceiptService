package com.example.ReceiptService.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class ReceiptItem {
    private String shortDescription;
    private String price;

    // Getters and Setters
    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
}
