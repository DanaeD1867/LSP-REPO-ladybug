package src.org.howard.edu.lsp.assignment3;

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

    /**
     *  The class constructor. It takes in the specified inputs, calcualtes the priceRange for the 
     * items, and applies discounts to the appropriate products.
     * 
     * @param id the product id
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
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

    /**
     * Calculates the product's price range.
     */
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

    /**
     * Applies discounts to specified items
     */
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
     * 
     * @returns the transformed product records in the form of a list of strings 
     * to be outputted onto the final file
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
