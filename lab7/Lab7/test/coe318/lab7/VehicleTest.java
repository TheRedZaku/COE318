package coe318.lab7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin L
 */
public class VehicleTest {
    
    public VehicleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPlateNumber method, of class Vehicle.
     */
    @Test
    public void testGetPlateNumber() {
        System.out.println("getPlateNumber");
        Vehicle instance = new Vehicle("Test Plate", "Test Model", 2026);
        String expResult = "Test Plate";
        String result = instance.getPlateNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModel method, of class Vehicle.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        Vehicle instance = new Vehicle("Test Plate", "Test Model", 2026);
        String expResult = "Test Model";
        String result = instance.getModel();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getYear method, of class Vehicle.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Vehicle instance = new Vehicle("Test Plate", "Test Model", 2026);
        int expResult = 2026;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateRentalPrice method, of class Vehicle.
     */
    @Test
    public void testCalculateRentalPrice() {
        System.out.println("calculateRentalPrice");
        int days = 67;
        Vehicle instance = new Vehicle("Test Plate", "Test Model", 2026);
        double expResult = 6700;
        double result = instance.calculateRentalPrice(days);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of calculateInsurancePremium method, of class Vehicle.
     */
    @Test
    public void testCalculateInsurancePremium() {
        System.out.println("calculateInsurancePremium");
        int days = 67;
        Vehicle instance = new Vehicle("Test Plate", "Test Model", 2026);
        double expResult = 1340;
        double result = instance.calculateInsurancePremium(days);
        assertEquals(expResult, result, 0);
    }
    
}

//Added other tests just as practice