package car;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.csc8002.coursework.part1.car.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTests {
    private Car testLC;
    private Car testSC;

    @Before
    public void setup() throws Exception {
        testLC = CarFactory.getInstance(CarType.LARGE_CAR);
        testSC = CarFactory.getInstance(CarType.SMALL_CAR);
    }

    @Test
    public void testCreate() {
        assertTrue(testLC instanceof LargeCar);
        assertTrue(testSC instanceof SmallCar);
    }

    @Test
    public void testSetRentStatus() {
        //Verify car is not rented
        assertFalse(testLC.isRented());
        assertFalse(testSC.isRented());

        //Change rent status to true
        ((CarFactory)testLC).setRentStatus(true);
        ((CarFactory)testSC).setRentStatus(true);

        //Verify car is rented
        assertTrue(testLC.isRented());
        assertTrue(testSC.isRented());

        //Set back to false
        ((CarFactory) testLC).setRentStatus(false);
        ((CarFactory) testSC).setRentStatus(false);

        //Verify car is shown as not rented
        assertFalse(testLC.isRented());
        assertFalse(testSC.isRented());
    }

    @Test
    public void testCopy() {
        //Make a copy of testLC object
        Car testLCCopy = CarFactory.getInstance(testLC);

        //Verify that both objects are different instances
        assertFalse(testLC == testLCCopy);

        //Verify that original and copy have the same attributes
        assertTrue(testLC.equals(testLCCopy));
    }

    @Test
    public void testFuelCapacity() {
        assertEquals(60, testLC.getFuelCapacity());
        assertEquals(49, testSC.getFuelCapacity());
    }

    @Test
    public void testDriveAndRefuel() {
        //Set car as rented for test purpose
        ((CarFactory) testLC).setRentStatus(true);
        ((CarFactory) testSC).setRentStatus(true);

        //Verify correct amount of fuel is used for different journey lengths
        assertEquals(9, testLC.driveCar(100));
        assertEquals(4, testLC.driveCar(39));
        assertEquals(25, testLC.driveCar(340));
        assertEquals(5, testSC.driveCar(100));
        assertEquals(2, testSC.driveCar(39));
        assertEquals(17, testSC.driveCar(340));

        //Verify remaining fuel is correct based on previous journeys
        assertEquals(22, testLC.getRemainingFuel());
        assertEquals(25, testSC.getRemainingFuel());

        //Verify fuel tank is not full
        assertFalse(testLC.fullTank());
        assertFalse(testSC.fullTank());

        //Verify car cannot be overfilled
        assertEquals(38, testLC.addFuel(50));
        assertEquals(24, testSC.addFuel(42));

        //Verify fuel tank is full
        assertTrue(testLC.fullTank());
        assertTrue(testSC.fullTank());

        //Set car as returned
        ((CarFactory) testLC).setRentStatus(false);
        ((CarFactory) testSC).setRentStatus(false);
    }
}
