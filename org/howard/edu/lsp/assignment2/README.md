## Design Rationale

The decision to create the help Record Object was inspired by the principles of the OOP design methodology. Now, if there is every a new column or additional transformation needed to be done to the original file, instead of adding to the bulk of the main function, you would simply create another helper function and/or attribute. 

The decision to write all of rest of the coding logic in the main file was done to create a consistent flow of logic. Anyone reading the program will be able to understand that it is an ETL pipeline (outside of the name) because all of the main steps are in logical order. 

## Assumptions/How to Run

That user will be attempting to read from a input file title 'products.csv'. If the file does not exist and/or goes by a different name, the program will throw a FileNotFoundException. If the program is ran multiple times, the new results will overwrite the previous.

## External Source Usage
Link: https://www.geeksforgeeks.org/java/initializing-a-list-in-java/
Usage: Refresher on how to intialized a list in a Object-Oriented Programming language (so used to python).

Link: http://geeksforgeeks.org/java/list-get-method-in-java-with-examples/
Usage: Syntax Debugging.

Link: https://www.baeldung.com/java-csv-file-array
Usage: Guidance on how to read from a csv file.

Link: https://stackoverflow.com/questions/9320409/unsupportedoperationexception-at-java-util-abstractlist-add
Usage: Debugging. 

Link: https://www.geeksforgeeks.org/java/classes-objects-java/
Usage: Refresher for intializing objects in java. 

Link: https://www.geeksforgeeks.org/java/array-vs-arraylist-in-java/
Usage: Syntax refresher. 

Link: https://stackoverflow.com/questions/66072170/what-meaning-this-error-java-util-stream-referencepipeline3-cannot-be-cast-to
Usage: Debugging. 

Link: https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
Usage: Syntax refresher. 

Link: https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
Usage: Guidance on how to convert double. 

Link: https://www.w3schools.com/java/java_files_create.asp
Usage: Guidance on how to write to file in java.

## AI Summary
I used ChatGPT to try and fix the FileNotFoundException error I got everytime I try to input the relative path into the function.

### Intial Prompt
Hi Chat. I have a program with the following file structure in the picture. I'm trying to create a program in the ETLPipeline.java file that will read from the data/products.csv and I need your help creating a relative path since nothing I do seems to work. If it helps i'm using buffer reader

### AI's response
Thanks for the image! Based on your folder structure, your ETLPipeline.java file is located at:

LSP-REPO-LADYBUG/org/howard/edu/lsp/assignment2/ETLPipeline.java


And your products.csv file is here:

LSP-REPO-LADYBUG/org/howard/edu/lsp/assignment2/data/products.csv


Since ETLPipeline.java is in the same directory level as the data folder, you can access the products.csv file using a relative path like this:

BufferedReader reader = new BufferedReader(new FileReader("data/products.csv"));

Key Notes:

This path assumes you are running the program from the assignment2 directory or above.

If you're running from the project root (LSP-REPO-LADYBUG), then this should still work because the relative path is resolved from the working directory, not the location of the .java file.

If this still doesn't work, you can print the current working directory with:

System.out.println(System.getProperty("user.dir"));


That will help confirm where your program is trying to start from.

Let me know what error you're seeing if it still fails — we can fix it fast.

### Usage
The final line about checking where my program was starting from helped me realize that I was running the program from the wrong path. Through some back and forth, I was able to modified the program and my understanding of how to run it properly. 