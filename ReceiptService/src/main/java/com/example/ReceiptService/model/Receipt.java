package com.example.ReceiptService.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Component
public class Receipt {
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<ReceiptItem> items;
    private String total;

    // Getters and Setters
    public String getRetailer() { return retailer; }
    public void setRetailer(String retailer) { this.retailer = retailer; }

    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getPurchaseTime() { return purchaseTime; }
    public void setPurchaseTime(String purchaseTime) { this.purchaseTime = purchaseTime; }

    public List<ReceiptItem> getItems() { return items; }
    public void setItems(List<ReceiptItem> items) { this.items = items; }

    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }
}
