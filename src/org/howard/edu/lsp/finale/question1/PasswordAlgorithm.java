package src.org.howard.edu.lsp.finale.question1;


/**
 * Strategy interface for password generation algorithms.
 */
public interface PasswordAlgorithm {
    /**
     * Generate a password of the requested length
     * @param length the desired password length
     * @return generated password
     */
    String generate(int length);
}
