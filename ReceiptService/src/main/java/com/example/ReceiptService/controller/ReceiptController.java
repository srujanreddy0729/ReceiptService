package com.example.ReceiptService.controller;

import com.example.ReceiptService.model.Receipt;
import com.example.ReceiptService.model.ReceiptItem;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    private Map<String, Receipt> receipts = new HashMap<>();

    @PostMapping("/process")
    public Map<String, String> processReceipt(@RequestBody Receipt receipt) {
        String id = UUID.randomUUID().toString();
        receipts.put(id, receipt);
        return Collections.singletonMap("id", id);
    }

    @GetMapping("/{id}/points")
    public Map<String, Integer> getPoints(@PathVariable String id) {
        Receipt receipt = receipts.get(id);
        if (receipt == null) {
            throw new RuntimeException("Receipt not found");
        }
        int points = calculatePoints(receipt);
        return Collections.singletonMap("points", points);
    }

    private int calculatePoints(Receipt receipt) {
        int points = 0;

        // Rule 1: One point for every alphanumeric character in the retailer name
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        // Rule 2: 50 points if the total is a round dollar amount with no cents
        double total = Double.parseDouble(receipt.getTotal());
        if (total == (int) total) {
            points += 50;
        }

        // Rule 3: 25 points if the total is a multiple of 0.25
        if (total % 0.25 == 0) {
            points += 25;
        }

        // Rule 4: 5 points for every two items on the receipt
        int itemCount = receipt.getItems().size();
        points += (itemCount / 2) * 5;

        // Rule 5: If the trimmed length of the item description is a multiple of 3,
        // multiply the price by 0.2 and round up to the nearest integer
        for (ReceiptItem item : receipt.getItems()) {
            String description = item.getShortDescription().trim();
            if (description.length() % 3 == 0) {
                double price = Double.parseDouble(item.getPrice());
                points += (int) Math.ceil(price * 0.2);
            }
        }

        // Rule 6: 6 points if the day in the purchase date is odd
        int day = Integer.parseInt(receipt.getPurchaseDate().split("-")[2]);
        if (day % 2 != 0) {
            points += 6;
        }

        // Rule 7: 10 points if the time of purchase is after 2:00pm and before 4:00pm
        int hour = Integer.parseInt(receipt.getPurchaseTime().split(":")[0]);
        if (hour >= 14 && hour < 16) {
            points += 10;
        }

        return points;
    }
}