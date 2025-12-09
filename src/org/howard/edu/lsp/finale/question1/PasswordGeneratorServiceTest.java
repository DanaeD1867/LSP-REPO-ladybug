package src.org.howard.edu.lsp.finale.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordGeneratorServiceTest {

    private PasswordGeneratorService service;

    @BeforeEach
    public void setup() {
        service = PasswordGeneratorService.getInstance();
    }

    @Test
    public void checkInstanceNotNull() {
        assertNotNull(service, "getInstance() should not return null");
    }

    @Test
    public void checkSingleInstanceBehavior() {
        PasswordGeneratorService second = PasswordGeneratorService.getInstance();
        // assertSame verifies both references point to the same instance
        assertSame(service, second, "getInstance() should always return the same instance");
    }

    @Test
    public void generateWithoutSettingAlgorithmThrowsException() {
        // Resetting algorithm reference isn't possible directly; create local reference to singleton
        PasswordGeneratorService s = PasswordGeneratorService.getInstance();

        // To test behavior reliably, set algorithm to null via reflection (since API doesn't give a clear reset)
        // BUT reflection is fragile in tests. Instead, we'll create a fresh singleton reference previously used:
        // We'll assume the singleton might already have algorithm set by previous tests; to ensure this test works
        // we will attempt to set algorithm to an invalid value and then set to null via reflection.
        // Simpler approach: Temporarily create a new instance via reflection for testing only.

        try {
            // create a fresh instance solely for this test using reflection (bypass private constructor)
            java.lang.reflect.Constructor<PasswordGeneratorService> ctor =
                    PasswordGeneratorService.class.getDeclaredConstructor();
            ctor.setAccessible(true);
            PasswordGeneratorService fresh = ctor.newInstance();

            // ensure fresh has no algorithm set
            assertThrows(IllegalStateException.class, () -> fresh.generatePassword(5),
                    "generatePassword should throw IllegalStateException when no algorithm set");
        } catch (ReflectiveOperationException e) {
            // If reflection fails for any reason, fail the test to signal environment problem
            fail("Reflection failure while setting up test: " + e.getMessage());
        }
    }

    @Test
    public void basicAlgorithmGeneratesCorrectLengthAndDigitsOnly() {
        service.setAlgorithm("basic");
        String p = service.generatePassword(10);
        assertNotNull(p, "password should not be null");
        assertEquals(10, p.length(), "basic password length should match requested length");
        assertTrue(p.matches("\\d{10}"), "basic password should contain digits only (0-9)");
    }

    @Test
    public void enhancedAlgorithmGeneratesCorrectCharactersAndLength() {
        service.setAlgorithm("enhanced");
        String p = service.generatePassword(12);
        assertNotNull(p, "password should not be null");
        assertEquals(12, p.length(), "enhanced password length should match requested length");
        // allowed characters: A-Z a-z 0-9
        assertTrue(p.matches("[A-Za-z0-9]{12}"), "enhanced password should contain only A-Z, a-z, 0-9");
    }

    @Test
    public void lettersAlgorithmGeneratesLettersOnly() {
        service.setAlgorithm("letters");
        String p = service.generatePassword(8);
        assertNotNull(p, "password should not be null");
        assertEquals(8, p.length(), "letters password length should match requested length");
        assertTrue(p.matches("[A-Za-z]{8}"), "letters password should contain letters only (A-Z, a-z)");
    }

    @Test
    public void switchingAlgorithmsChangesBehavior() {
        service.setAlgorithm("basic");
        String p1 = service.generatePassword(10);

        service.setAlgorithm("letters");
        String p2 = service.generatePassword(10);

        service.setAlgorithm("enhanced");
        String p3 = service.generatePassword(10);

        assertEquals(10, p1.length(), "basic password length mismatch");
        assertEquals(10, p2.length(), "letters password length mismatch");
        assertEquals(10, p3.length(), "enhanced password length mismatch");

        assertTrue(p1.matches("\\d{10}"), "basic should be digits only");
        assertTrue(p2.matches("[A-Za-z]{10}"), "letters should be letters only");
        assertTrue(p3.matches("[A-Za-z0-9]{10}"), "enhanced should be letters or digits only");

        // Optional: ensure they're not all identical — good sanity check but not required
        // (very small chance of collision exists, but extremely unlikely)
        boolean allSame = p1.equals(p2) && p2.equals(p3);
        assertFalse(allSame, "Passwords from different algorithms should not all be identical");
    }
}
