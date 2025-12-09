package src.org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Letters only (A-Z, a-z).
 */
public class LettersPasswordAlgorithm extends AbstractPasswordAlgorithm {

    public LettersPasswordAlgorithm() {
        this.random = new SecureRandom();
        this.allowedChars =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz";
    }
}
