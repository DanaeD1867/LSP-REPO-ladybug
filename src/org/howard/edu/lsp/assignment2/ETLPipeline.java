package src.org.howard.edu.lsp.assignment2; 

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;


/*
 * Helper class used to perform necessary transformations on product records. 
 * 
 * @param id
 * @param name
 * @param price
 * @param category
 */
class Record{
    int id = 0;
    String name = "";
    double price = 0;
    String category = "";
    String priceRange = ""; 

    public Record(int id, String name, double price, String category){
        this.id = id; 
        this.name = name.toUpperCase();
        this.price = price;
        this.category = category;

        this.calculatePriceRange();
        if(this.category.trim().contentEquals("Electronics")){
            this.applyDiscount();
        }
    }

    public void calculatePriceRange(){
        if(this.price <= 10.00){
            this.priceRange = "Low";
        }else if(this.price <= 100.00){
            this.priceRange = "Medium";
        }else if (price <= 500.00){
            this.priceRange = "High";
        }else{
            this.priceRange = "Premium";
        }
    }

    public void applyDiscount(){
        DecimalFormat df = new DecimalFormat("#.##"); 
        this.price = this.price - (this.price * .10);
        this.price = Double.parseDouble(df.format(this.price));

        if(this.price > 500.00){
            this.category = "Premium Electronics";
        }
    }

    /*
     * Used to create the final record that will be loaded into transformed_products.csv
     * @returns The record in a string list format
     */
    public List<String> formalizeRecord(){
        String id = String.valueOf(this.id); 
        String price = String.valueOf(this.price);

        List<String> record = new ArrayList<String>();
        record.add(id);
        record.add(this.name); 
        record.add(price); 
        record.add(this.category); 
        record.add(this.priceRange);

        return record;
    }
}

/*
 * Performs ETL task on a CSV file
 */
public class ETLPipeline {
    
    public static void main(String args[]) throws IOException{
        //Fix problem with paths
        final String PRODUCTS = "src/data/products.csv";
        final String TRANSFORMED_PRODUCTS = "src/data/transformed_products.csv";
        final String DELIMITER = ","; 
        List<List<String>> transformedRecords = new ArrayList<>(); 
        List<List<String>> records = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(PRODUCTS));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSFORMED_PRODUCTS))
        ){
            // Parses through input file
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(DELIMITER);
                records.add(
                    new ArrayList<String>(Arrays.asList(values)));
            }

            /**
             * Either pulls the file header through the records list or inputs it manually 
             * (implies the existence of an empty file).
             */
            List<String> headers = new ArrayList<>();
            if(!records.isEmpty()){
                headers.addAll(records.removeFirst());
            }else{
                headers = Arrays.asList("ProductID", "Name", "Price", "Category");
            }
            headers = new ArrayList<>(headers);
            headers.add("PriceRange");
            transformedRecords.add(headers);

            /**
            * Used to transformed the records as needed. The existence of a missing input will result in a
            * default value be inserted into transformed file.
            */
            for(List<String> record: records){
                int id = Integer.parseInt((String)record.get(0));
                String name = (String) record.get(1); 
                double price = Double.parseDouble((String) record.get(2));
                String category = (String) record.get(3);

                Record updatedRecord = new Record(id, name, price, category);  
                transformedRecords.add(updatedRecord.formalizeRecord());
            }

            /*
             * Writes the transformed records to the final file.
             */
            
            for(List<String> record: transformedRecords){
                writer.write(String.join(",", record) + "\n");
            }
            
            /**
             * Prints a run summary and flushes writer.
             */
            String summaryMessage = """
                    Program Summary:
                    Rows read: %d, 
                    Rows transformed: %d,
                    Rows skipped: %d,
                    Output path: %s
                    """;
            writer.write(String.format(summaryMessage, 
                                        records.size(), 
                                        records.size(), 
                                        (transformedRecords.size() - records.size()), 
                                        TRANSFORMED_PRODUCTS).strip());
            writer.flush();
        }catch(Exception e){
            System.err.println("Error running program: "+ e.getMessage());
        }
    }   

}
    
