package src.org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Main class to run the ETL pipeline.
 * <p>This file serves as the root file for the ETL pipeline. It intiaites the csv reader/writer and the ETLProcessor
 * class to start the transformations. If one of the specified files are not found, it returns the error messages to the console. </p>
 */
public class ETLPipelineMain {
    public static void main(String[] args) {
        final String INPUT = "data/products.csv";
        final String OUTPUT = "data/transformed_products.csv";

        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        ETLProcessor processor = new ETLProcessor();

        try {
            List<List<String>> rawRecords = reader.read(INPUT);
            List<List<String>> transformed = processor.transform(rawRecords);
            writer.write(OUTPUT, transformed);

            System.out.printf("""
                Program Summary:
                Rows read: %d
                Rows transformed: %d
                Output file: %s
                """, rawRecords.size(), transformed.size() - 1, OUTPUT);

        } catch (Exception e) {
            System.err.println("Error in ETL Pipeline: " + e.getMessage());
        }
    }
}
