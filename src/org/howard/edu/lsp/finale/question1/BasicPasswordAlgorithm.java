package src.org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Digits-only (0-9) using java.util.Random.
 */
public class BasicPasswordAlgorithm extends AbstractPasswordAlgorithm {

    public BasicPasswordAlgorithm() {
        this.random = new Random();
        this.allowedChars = "0123456789";
    }
}
