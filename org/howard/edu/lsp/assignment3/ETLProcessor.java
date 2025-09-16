package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Applies transformations to raw product data.
 * 
 * @param rawRecord the unaltered records read straight from the inputted file
 * @returns the transformed records as described by the project requirements 
 */
public class ETLProcessor {
    public List<List<String>> transform(List<List<String>> rawRecords) {
        List<List<String>> transformed = new ArrayList<>();

        // Handle headers
        List<String> headers;
        if (!rawRecords.isEmpty()) {
            headers = new ArrayList<>(rawRecords.remove(0));
        } else {
            headers = List.of("ProductID", "Name", "Price", "Category");
        }
        headers = new ArrayList<>(headers);
        headers.add("PriceRange");
        transformed.add(headers);

        for (List<String> record : rawRecords) {
            try {
                int id = Integer.parseInt(record.get(0));
                String name = record.get(1);
                double price = Double.parseDouble(record.get(2));
                String category = record.get(3);

                ProductRecord pr = new ProductRecord(id, name, price, category);
                transformed.add(pr.toList());
            } catch (Exception e) {
                System.err.println("Skipping malformed record: " + record);
            }
        }

        return transformed;
    }
}
