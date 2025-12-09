package src.org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Base class implementing shared password-generation logic.
 */
public abstract class AbstractPasswordAlgorithm implements PasswordAlgorithm {

    protected Random random;       // could be Random or SecureRandom
    protected String allowedChars; // character set provided by subclasses

    @Override
    public String generate(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(idx));
        }
        return sb.toString();
    }
}
