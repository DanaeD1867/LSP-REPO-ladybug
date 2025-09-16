package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes a list of records to a CSV file.
 */
public class CSVWriter {
    public void write(String filePath, List<List<String>> records) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (List<String> record : records) {
                writer.write(String.join(",", record) + "\n");
            }
        }
    }
}
