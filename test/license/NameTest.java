package license;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.csc8002.coursework.part1.license.Name;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NameTest {
    private Name testName1;
    private Name testName2;
    private Name testName3;
    private Name testName4;
    private Name testName1Copy;

    @Before
    public void setUp() {
        testName1 = Name.getName("Andrew", "Brown");
        testName2 = Name.getName("Amy", "Pearson");
        testName3 = Name.getName("Adam", "Peacock");
        testName4 = Name.getName("Alison", "McGregor");

    }

    @Test
    public void createTest() {
        assertTrue(testName1 != null);
        assertTrue(testName2 != null);
        assertTrue(testName3 != null);
        assertTrue(testName4 != null);
    }

    @Test
    public void firstNameTest() {
        assertEquals("Andrew", testName1.getFirstName());
        assertEquals("Amy", testName2.getFirstName());
        assertEquals("Adam", testName3.getFirstName());
        assertEquals("Alison", testName4.getFirstName());
    }

    @Test
    public void lastNameTest() {
        assertEquals("Brown", testName1.getLastName());
        assertEquals("Pearson", testName2.getLastName());
        assertEquals("Peacock", testName3.getLastName());
        assertEquals("McGregor", testName4.getLastName());
    }

    @Test
    public void toStringTest() {
        assertEquals("Andrew Brown", testName1.toString());
        assertEquals("Amy Pearson", testName2.toString());
        assertEquals("Adam Peacock", testName3.toString());
        assertEquals("Alison McGregor", testName4.toString());
    }

    @Test
    public void testCopyAndEquals() {
        //Create copy of name object
        testName1Copy = Name.getName(testName1);

        //Verify objects are separate objects
        assertFalse(testName1 == testName1Copy);

        //Verify equality of object
        assertTrue(testName1.equals(testName1Copy));
    }
}
