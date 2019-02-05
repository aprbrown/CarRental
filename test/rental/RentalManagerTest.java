package rental;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ncl.csc8002.coursework.part1.car.*;
import uk.ac.ncl.csc8002.coursework.part1.license.*;
import uk.ac.ncl.csc8002.coursework.part1.rental.RentalManager;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RentalManagerTest {
    private RentalManager rm;
    private DriverLicense under21;
    private DriverLicense aged21LessThan1Year;
    private DriverLicense aged21MoreThan1Year;
    private DriverLicense aged25LessThan5Years;
    private DriverLicense aged25MoreThan5Years;
    private DriverLicense eligible1;
    private DriverLicense eligible2;
    private DriverLicense eligible3;
    private DriverLicense eligible4;
    private DriverLicense eligible5;
    private DriverLicense eligible6;
    private DriverLicense eligible7;
    private DriverLicense eligible8;
    private DriverLicense eligible9;
    private DriverLicense eligible10;
    private DriverLicense eligible11;
    private DriverLicense eligible12;
    private DriverLicense eligible13;
    private DriverLicense eligible14;
    private DriverLicense eligible15;
    private DriverLicense eligible16;
    private DriverLicense eligible17;
    private DriverLicense eligible18;
    private DriverLicense eligible19;
    private DriverLicense eligible20;
    private DriverLicense eligible21;
    private DriverLicense eligible22;
    private DriverLicense eligible23;
    private DriverLicense eligible24;
    private DriverLicense eligible25;
    private Calendar cal = Calendar.getInstance();

    @Before
    public void setUp() throws Exception {
        rm = RentalManager.TEST_newManager();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 21);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        Date under21DOB = cal.getTime();
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 21);
        Date over21DOB = cal.getTime();
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 25);
        Date over25DOB = cal.getTime();
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        Date issueUnder1Year = cal.getTime();
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 1);
        Date issueOver1Year = cal.getTime();
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 5);
        Date issueOver5Year = cal.getTime();
        under21 = DriverLicense.generateDriverLicense(Name.getName("Catherine", "Brennan"), under21DOB, issueUnder1Year, true);
        aged21LessThan1Year = DriverLicense.generateDriverLicense(Name.getName("Ajay", "Mcdonald"), over21DOB, issueUnder1Year, true);
        aged21MoreThan1Year = DriverLicense.generateDriverLicense(Name.getName("Kenneth", "Sawyer"), over21DOB, issueOver1Year, true);
        aged25LessThan5Years = DriverLicense.generateDriverLicense(Name.getName("Luna", "Giles"), over25DOB, issueOver1Year, true);
        aged25MoreThan5Years = DriverLicense.generateDriverLicense(Name.getName("Colin", "Nichols"), over25DOB, issueOver5Year, true);
        eligible1 = DriverLicense.generateDriverLicense(Name.getName("Freddie","Wade"), over25DOB, issueOver5Year, true);
        eligible2 = DriverLicense.generateDriverLicense(Name.getName("Clyde","Sutton"), over25DOB, issueOver5Year, true);
        eligible3 = DriverLicense.generateDriverLicense(Name.getName("Bea","Kane"), over25DOB, issueOver5Year, true);
        eligible4 = DriverLicense.generateDriverLicense(Name.getName("Katy","Webb"), over25DOB, issueOver5Year, true);
        eligible5 = DriverLicense.generateDriverLicense(Name.getName("Kendall","Hodge"), over25DOB, issueOver5Year, true);
        eligible6 = DriverLicense.generateDriverLicense(Name.getName("Jon","Connelly"), over25DOB, issueOver5Year, true);
        eligible7 = DriverLicense.generateDriverLicense(Name.getName("Roxy","Trejo"), over25DOB, issueOver5Year, true);
        eligible8 = DriverLicense.generateDriverLicense(Name.getName("Jillian","McCullough"), over25DOB, issueOver5Year, true);
        eligible9 = DriverLicense.generateDriverLicense(Name.getName("Bridie","Leal"), over25DOB, issueOver5Year, true);
        eligible10 = DriverLicense.generateDriverLicense(Name.getName("Nathan","Jennings"), over25DOB, issueOver5Year, true);
        eligible11 = DriverLicense.generateDriverLicense(Name.getName("Devon","Oliver"), over25DOB, issueOver5Year, true);
        eligible12 = DriverLicense.generateDriverLicense(Name.getName("Giselle","Connor"), over25DOB, issueOver5Year, true);
        eligible13 = DriverLicense.generateDriverLicense(Name.getName("Olivia","Milne"), over25DOB, issueOver5Year, true);
        eligible14 = DriverLicense.generateDriverLicense(Name.getName("Kourtney","Shah"), over25DOB, issueOver5Year, true);
        eligible15 = DriverLicense.generateDriverLicense(Name.getName("Sienna","Henson"), over25DOB, issueOver5Year, true);
        eligible16 = DriverLicense.generateDriverLicense(Name.getName("Colin","Koch"), over25DOB, issueOver5Year, true);
        eligible17 = DriverLicense.generateDriverLicense(Name.getName("Kadie","Bull"), over25DOB, issueOver5Year, true);
        eligible18 = DriverLicense.generateDriverLicense(Name.getName("Celia","Douglas"), over25DOB, issueOver5Year, true);
        eligible19 = DriverLicense.generateDriverLicense(Name.getName("Rita","Strong"), over25DOB, issueOver5Year, true);
        eligible20 = DriverLicense.generateDriverLicense(Name.getName("Clare","Villareal"), over25DOB, issueOver5Year, true);
        eligible21 = DriverLicense.generateDriverLicense(Name.getName("Skylar","Leal"), over25DOB, issueOver5Year, true);
        eligible22 = DriverLicense.generateDriverLicense(Name.getName("Bree","Sweet"), over25DOB, issueOver5Year, true);
        eligible23 = DriverLicense.generateDriverLicense(Name.getName("Malcolm","Nolan"), over25DOB, issueOver5Year, true);
        eligible24 = DriverLicense.generateDriverLicense(Name.getName("Liam","Riddle"), over25DOB, issueOver5Year, true);
        eligible25 = DriverLicense.generateDriverLicense(Name.getName("Sebastian","Salgado"), over25DOB, issueOver5Year, true);

    }

    @Test
    public void testIssueCars() {
        //Try and issue car to under 21 year old
        assertFalse(rm.issueCar(under21, CarType.SMALL_CAR));

        //Try and issue car to someone who has held license for less than a year
        assertFalse(rm.issueCar(aged21LessThan1Year, CarType.SMALL_CAR));

        //Try and issue Large car to and over 25 year old who has had license for less than 5 years
        assertFalse(rm.issueCar(aged25LessThan5Years, CarType.LARGE_CAR));

        //Try and issue Small Car to someone over 21 who has held license for over a year
        assertTrue(rm.issueCar(aged21MoreThan1Year, CarType.SMALL_CAR));

        //Try and issue Large Car to someone over 25 who has held license for over 5 years
        assertTrue(rm.issueCar(aged25MoreThan5Years, CarType.LARGE_CAR));

        //Try and issue a car to someone who has already successfully rented a car.
        assertFalse(rm.issueCar(aged21MoreThan1Year, CarType.SMALL_CAR));
    }

    @Test
    public void testTerminateRental() throws Exception {
        //verify rented list is empty
        assertEquals(0, rm.getRentedCars().size());

        //issue 5 cars
        rm.issueCar(eligible1, CarType.SMALL_CAR);
        rm.issueCar(eligible2, CarType.LARGE_CAR);
        rm.issueCar(eligible3, CarType.SMALL_CAR);
        rm.issueCar(eligible4, CarType.SMALL_CAR);
        rm.issueCar(eligible5, CarType.LARGE_CAR);

        //verify size of rented cars list is 5
        assertEquals(5, rm.getRentedCars().size());

        //return one car
        rm.terminateRental(eligible1);

        //verify size of rented cars list is 4
        assertEquals(4, rm.getRentedCars().size());

        //Assign a car object and drive it 100 km
        Car carToDrive = rm.getCar(eligible2);
        carToDrive.driveCar(100);

        //Return driven car and verify 9 litres of fuel used
        assertEquals(9 ,rm.terminateRental(eligible2));

        //Return 3 remaining cars
        rm.terminateRental(eligible3);
        rm.terminateRental(eligible4);
        rm.terminateRental(eligible5);

        //Verify rented cars list is now empty
        assertEquals(0, rm.getRentedCars().size());

        //Verify that terminating a rental for someone without a rental returns 0
        assertEquals(0, rm.terminateRental(eligible6));
    }

    @Test
    public void testAvailableCars() throws Exception{
        //Check numbers are as expected before rentals have been made
        assertEquals(30, rm.availableCars(CarType.SMALL_CAR));
        assertEquals(20, rm.availableCars(CarType.LARGE_CAR));

        //Issue 2 Large cars
        rm.issueCar(eligible6, CarType.LARGE_CAR);
        rm.issueCar(eligible7, CarType.LARGE_CAR);
        assertEquals(18, rm.availableCars(CarType.LARGE_CAR));

        //Issue 2 Small cars
        rm.issueCar(eligible8, CarType.SMALL_CAR);
        rm.issueCar(eligible9, CarType.SMALL_CAR);
        assertEquals(28,rm.availableCars(CarType.SMALL_CAR));

        //Issue 5 Large Cars and 2 Small Cars
        rm.issueCar(eligible10, CarType.LARGE_CAR);
        rm.issueCar(eligible11, CarType.LARGE_CAR);
        rm.issueCar(eligible12, CarType.LARGE_CAR);
        rm.issueCar(eligible13, CarType.SMALL_CAR);
        rm.issueCar(eligible14, CarType.LARGE_CAR);
        rm.issueCar(eligible15, CarType.LARGE_CAR);
        rm.issueCar(eligible16, CarType.SMALL_CAR);
        assertEquals(13, rm.availableCars(CarType.LARGE_CAR));
        assertEquals(26, rm.availableCars(CarType.SMALL_CAR));

        //Return 3 large cars
        rm.terminateRental(eligible10);
        rm.terminateRental(eligible12);
        rm.terminateRental(eligible15);
        assertEquals(16, rm.availableCars(CarType.LARGE_CAR));
    }

    @Test
    public void testGetCar() {
        //Issue a Large car
        rm.issueCar(eligible25, CarType.LARGE_CAR);
        Car testLargeCar = rm.getCar(eligible25);

        //Verify the car is actually a Large Car
        assertTrue(testLargeCar instanceof LargeCar);

        //Issue a Small car
        rm.issueCar(eligible24, CarType.SMALL_CAR);
        Car testSmallCar = rm.getCar(eligible24);

        //Verify the car is actually a Small Car
        assertTrue(testSmallCar instanceof SmallCar);

        //Verify that if the driver has not rented a car, that a null value is returned
        assertEquals(null, rm.getCar(eligible18));
    }

    @Test
    public void testGetRentedCars() {
        //Issue 4 cars
        rm.issueCar(eligible17, CarType.LARGE_CAR);
        rm.issueCar(eligible20, CarType.LARGE_CAR);
        rm.issueCar(eligible21, CarType.SMALL_CAR);
        rm.issueCar(eligible23, CarType.SMALL_CAR);

        //Verify that Rented Cars list contains 4 entries
        assertTrue(rm.getRentedCars().size() == 4);

        //Although defensively copied, verify that the list contains the rented car
        Car car1 = rm.getCar(eligible17);
        assertTrue(rm.getRentedCars().contains(car1));

        //Although defensively copied, verify that the list contains the rented car
        Car car2 = rm.getCar(eligible20);
        assertTrue(rm.getRentedCars().contains(car2));
    }

    @Test
    public void testNoCarAvailable() {
        //Issue 20 Large Cars
        rm.issueCar(eligible1, CarType.LARGE_CAR);
        rm.issueCar(eligible2, CarType.LARGE_CAR);
        rm.issueCar(eligible3, CarType.LARGE_CAR);
        rm.issueCar(eligible4, CarType.LARGE_CAR);
        rm.issueCar(eligible5, CarType.LARGE_CAR);
        rm.issueCar(eligible6, CarType.LARGE_CAR);
        rm.issueCar(eligible7, CarType.LARGE_CAR);
        rm.issueCar(eligible8, CarType.LARGE_CAR);
        rm.issueCar(eligible9, CarType.LARGE_CAR);
        rm.issueCar(eligible10, CarType.LARGE_CAR);
        rm.issueCar(eligible11, CarType.LARGE_CAR);
        rm.issueCar(eligible12, CarType.LARGE_CAR);
        rm.issueCar(eligible13, CarType.LARGE_CAR);
        rm.issueCar(eligible14, CarType.LARGE_CAR);
        rm.issueCar(eligible15, CarType.LARGE_CAR);
        rm.issueCar(eligible16, CarType.LARGE_CAR);
        rm.issueCar(eligible17, CarType.LARGE_CAR);
        rm.issueCar(eligible18, CarType.LARGE_CAR);
        rm.issueCar(eligible19, CarType.LARGE_CAR);
        rm.issueCar(eligible20, CarType.LARGE_CAR);

        //Check that 0 large cars are available after they have all been issued
        assertEquals(0, rm.availableCars(CarType.LARGE_CAR));

        //Attempt to rent out one more Large Car knowing none are available, expect false
        assertFalse(rm.issueCar(eligible22, CarType.LARGE_CAR));
    }
}
