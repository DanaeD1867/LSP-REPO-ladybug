package src.org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Class that represents and enchanced algorithm (including upper and lowercase letters, numbers)
 */
public class EnhancedPasswordAlgorithm implements PasswordAlgorithm {

    private final SecureRandom secureRandom; 
    private static final String ALLOWED_CHARACTERS = 
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+
    "abcdefghijklmnopqrstuvwxyz" + 
    "0123456789";

    /**
     * Constructs the Password Algorithm using Secure Random
     */
    public EnhancedPasswordAlgorithm(){
        this.secureRandom = new SecureRandom();
    }

    @Override
    public String generate(int length){
        if(length < 0){
            throw new IllegalArgumentException("Length must be non-negative");
        }

        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++){
            int idx = secureRandom.nextInt(ALLOWED_CHARACTERS.length());
            sb.append(ALLOWED_CHARACTERS.charAt(idx));
        }

        return sb.toString();
    }
    
}
