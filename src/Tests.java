import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void main() {
        Main main = new Main();
        assertEquals("Opus Online", main.correctNameOfTheCompanyIsDisplayed);
        assertEquals("Pärnu maantee 139c, 11317 Tallinn", main.correctAddressIsDisplayed);
        assertTrue(main.correctPhone); // different method because browser may encapsule the phone inside "a" tag, and may not encapsule
        System.out.println(main.navigationLinkIsPresent);
        assertTrue(main.navigationLinkIsPresent);
    }
}