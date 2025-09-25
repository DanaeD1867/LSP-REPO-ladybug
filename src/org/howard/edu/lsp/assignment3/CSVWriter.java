
package src.org.howard.edu.lsp.assignment3; 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes a list of records to a CSV file.
 * 
 * @param filepath the file path of the intended outputed file
 * @param records the transformed records to be written to the file
 * @throws IOException if there is a problem with the inputted file path and/or writing to the file
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
