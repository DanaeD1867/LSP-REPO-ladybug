package src.org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

public class LettersPasswordAlgorithm implements PasswordAlgorithm{
    private final SecureRandom secureRandom; 
    private static final String LETTERS = 
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+
    "abcdefghijklmnopqrstuvwxyz";

    /**
     * Construct Letters Password Algorithm using Secure Random
     */
    public LettersPasswordAlgorithm(){
        this.secureRandom = new SecureRandom();
    }

    @Override
    public String generate(int length){
        if(length < 0){
            throw new IllegalArgumentException("Length must be a non-negative number");
        }

        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++){
            int idx = secureRandom.nextInt(LETTERS.length());
            sb.append(LETTERS.charAt(idx));
        }
        return sb.toString();
    }
    
}
