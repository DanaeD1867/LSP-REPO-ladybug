package src.org.howard.edu.lsp.finale.question1;

/**
 * * Singleton service that provides a single shared access point for password generation,
 * and allows swapping algorithms at runtime.
 *
 * DESIGN PATTERN DOCUMENTATION
 *
 * Patterns used:
 * 1) Singleton Pattern
 *    - Ensures only one instance of PasswordGeneratorService exists.
 *    - Provides the single shared access point required by the assignment via getInstance().
 *
 * 2) Strategy Pattern
 *    - Password algorithms are encapsulated behind the PasswordAlgorithm interface.
 *    - setAlgorithm(String) selects which concrete strategy is used at runtime.
 *    - generatePassword delegates to the selected strategy.
 *    - This allows adding new algorithms without modifying client code or the service,
 *      satisfying the requirement for future extension and swappability.
 *
 * Why appropriate:
 * - Singleton enforces requirement: one shared access point and single instance.
 * - Strategy cleanly addresses: multiple approaches, runtime selection,
 *   ability to expand algorithms, and swap behavior dynamically without client changes.
 *
 */
public class PasswordGeneratorService {

    private static volatile PasswordGeneratorService instance;
    private PasswordAlgorithm algorithm;

    private PasswordGeneratorService() {}

    /**
     * Returns the singleton instance.
     */
    public static PasswordGeneratorService getInstance() {
        if (instance == null) {
            synchronized (PasswordGeneratorService.class) {
                if (instance == null) {
                    instance = new PasswordGeneratorService();
                }
            }
        }
        return instance;
    }

    /**
     * Select the password-generation strategy.
     *
     * @param name algorithm name: "basic", "enhanced", "letters"
     */
    public void setAlgorithm(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Algorithm name cannot be null");
        }

        switch (name.trim().toLowerCase()) {
            case "basic":
                this.algorithm = new BasicPasswordAlgorithm();
                break;

            case "enhanced":
                this.algorithm = new EnhancedPasswordAlgorithm();
                break;

            case "letters":
                this.algorithm = new LettersPasswordAlgorithm();
                break;

            default:
                throw new IllegalArgumentException("Unsupported algorithm: " + name);
        }
    }

    /**
     * Generate a password using the selected strategy.
     */
    public String generatePassword(int length) {
        if (algorithm == null) {
            throw new IllegalStateException("No algorithm selected");
        }
        return algorithm.generate(length);
    }
}