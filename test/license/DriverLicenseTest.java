package license;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.csc8002.coursework.part1.license.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DriverLicenseTest {
    private Date dateOfIssue1;
    private Date dateOfIssue2;
    private Date dateOfBirth1;
    private Date dateOfBirth2;
    private DriverLicense testLicense1;
    private DriverLicense testLicense2;

    @Before
    public void setUp() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2012);
        dateOfIssue1 = cal.getTime();
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2010);
        dateOfIssue2 = cal.getTime();
        cal.set(Calendar.YEAR, 1986, Calendar.MONTH, Calendar.SEPTEMBER, Calendar.DAY_OF_MONTH, 23);
        dateOfBirth1 = cal.getTime();
        cal.set(Calendar.YEAR, 1987, Calendar.MONTH, Calendar.DECEMBER, Calendar.DAY_OF_MONTH, 16);
        dateOfBirth2 = cal.getTime();

        testLicense1 = DriverLicense.generateDriverLicense(Name.getName("Andrew", "Brown"), dateOfBirth1, dateOfIssue1, true);
        testLicense2 = DriverLicense.generateDriverLicense(Name.getName("Amy", "Pearson"), dateOfBirth2, dateOfIssue2, true);
    }

    @Test
    public void testCreate() {
        assertTrue(testLicense1 != null);
        assertTrue(testLicense2 != null);
    }

    @Test
    public void testGetName() {
        assertEquals("Andrew Brown", testLicense1.getDriverName().toString());
        assertEquals("Amy Pearson", testLicense2.getDriverName().toString());
    }

    @Test
    public void testGetLicenseNumber() {
        assertThat(testLicense1.getLicenseNumber().toString(), containsString("AB-2012-"));
        assertThat(testLicense2.getLicenseNumber().toString(), containsString("AP-2010-"));
    }

    @Test
    public void testFullLicense() {
        assertTrue(testLicense1.isFullLicense());
    }
}
