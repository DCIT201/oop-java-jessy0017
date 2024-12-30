package agency;

import agency.Customer;
import agency.RentalTransaction;
import com.vehicle.Car;
import com.vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTransactionTest {
    private Customer customer;
    private Vehicle car;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", "1234567890");
        car = new Car("V1", "Toyota Corolla", 50, true);
    }

    @Test
    void testRentalTransactionInitialization() {
        RentalTransaction transaction = new RentalTransaction(customer, car, 5);

        assertEquals(customer, transaction.getCustomer());
        assertEquals(car, transaction.getVehicle());
        assertEquals(5, transaction.getDaysRented());
        assertEquals(car.calculateRentalCost(5), transaction.getTotalCost());
    }

    @Test
    void testLoyaltyPointsAdded() {
        int initialLoyaltyPoints = customer.getLoyaltyPoints();

        RentalTransaction transaction = new RentalTransaction(customer, car, 5);
        int expectedLoyaltyPoints = initialLoyaltyPoints + (int) transaction.getTotalCost() / 10;

        assertEquals(expectedLoyaltyPoints, customer.getLoyaltyPoints());
    }

    @Test
    void testGetCustomer() {
        RentalTransaction transaction = new RentalTransaction(customer, car, 3);

        assertEquals(customer, transaction.getCustomer());
    }

    @Test
    void testGetVehicle() {
        RentalTransaction transaction = new RentalTransaction(customer, car, 3);

        assertEquals(car, transaction.getVehicle());
    }

    @Test
    void testGetDaysRented() {
        RentalTransaction transaction = new RentalTransaction(customer, car, 7);

        assertEquals(7, transaction.getDaysRented());
    }

    @Test
    void testGetTotalCost() {
        RentalTransaction transaction = new RentalTransaction(customer, car, 4);
        double expectedCost = car.calculateRentalCost(4);

        assertEquals(expectedCost, transaction.getTotalCost());
    }
}

