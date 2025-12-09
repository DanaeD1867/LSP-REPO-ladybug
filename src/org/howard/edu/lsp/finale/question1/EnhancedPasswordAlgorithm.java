package src.org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * A-Z, a-z, 0-9 using SecureRandom.
 */
public class EnhancedPasswordAlgorithm extends AbstractPasswordAlgorithm {

    public EnhancedPasswordAlgorithm() {
        this.random = new SecureRandom();
        this.allowedChars =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "0123456789";
    }
}
