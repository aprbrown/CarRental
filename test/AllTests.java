import car.CarTests;
import license.AllLicenseTests;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import rental.RentalManagerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CarTests.class, RentalManagerTest.class, AllLicenseTests.class})

public class AllTests {

}
