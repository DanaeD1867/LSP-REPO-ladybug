package src.org.howard.edu.lsp.finale.question1;

import java.util.Random;

/*
* Class to represent a basic password (digits only) */
public class BasicPasswordAlgorithm implements PasswordAlgorithm{
    private final Random random; 
    private static final String DIGITS = "0123456789";

    /**
     * Construct BasicPasswordAlgorithm using the Random module
     */
    public BasicPasswordAlgorithm (){
        this.random = new Random();
    }

    @Override
    public String generate(int length){
        if(length < 0){
            throw new IllegalArgumentException("Length must be non-negative value");
        }

        StringBuilder sb = new StringBuilder(length); 
        for(int i = 0; i < length; i++){
            int idx = random.nextInt(DIGITS.length()); 
            sb.append(DIGITS.charAt(idx));
        }

        return sb.toString();

    }
    
}
