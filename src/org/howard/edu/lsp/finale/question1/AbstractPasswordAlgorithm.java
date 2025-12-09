package src.org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Base class implementing shared password-generation logic.
 */
public abstract class AbstractPasswordAlgorithm implements PasswordAlgorithm {

    protected Random random;       // could be Random or SecureRandom
    protected String allowedChars; // character set provided by subclasses

    /**
     * Generates a passwords of the specified length with the allowed characters
     * 
     * @param length the desired length of the password
     * @returns the generated password
     * @throws IllegalArgumentException if the inputted length is a negative number
     */
    @Override
    public String generate(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length must be non-negative");
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(idx));
        }
        return sb.toString();
    }
}
