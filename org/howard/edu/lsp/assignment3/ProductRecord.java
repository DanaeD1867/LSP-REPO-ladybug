package org.howard.edu.lsp.assignment3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single product record and its transformation logic.
 */
public class ProductRecord {
    private int id;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    public ProductRecord(int id, String name, double price, String category) {
        this.id = id;
        this.name = name.toUpperCase();
        this.price = price;
        this.category = category;

        calculatePriceRange();
        if (this.category.trim().equalsIgnoreCase("Electronics")) {
            applyDiscount();
        }
    }

    private void calculatePriceRange() {
        if (price <= 10.00) {
            priceRange = "Low";
        } else if (price <= 100.00) {
            priceRange = "Medium";
        } else if (price <= 500.00) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }
    }

    private void applyDiscount() {
        DecimalFormat df = new DecimalFormat("#.##");
        price = price - (price * 0.10);
        price = Double.parseDouble(df.format(price));

        if (price > 500.00) {
            category = "Premium Electronics";
        }
    }

    /**
     * Returns the record in a format suitable for CSV writing.
     */
    public List<String> toList() {
        List<String> record = new ArrayList<>();
        record.add(String.valueOf(id));
        record.add(name);
        record.add(String.valueOf(price));
        record.add(category);
        record.add(priceRange);
        return record;
    }
}
