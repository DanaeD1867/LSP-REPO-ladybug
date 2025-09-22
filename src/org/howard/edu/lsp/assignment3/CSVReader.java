package src.org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reads CSV files and returns content as a list of rows.
 * 
 * @param filePath the file path of the inputted csv file
 * @returns the contents of the csv file as a list of rows
 * @throws IOException if the file is not found
 */
public class CSVReader {
    public List<List<String>> read(String filePath) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(new ArrayList<>(Arrays.asList(line.split(","))));
            }
        }
        return records;
    }
}
