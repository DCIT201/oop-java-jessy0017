package agency;



import agency.Customer;
import com.vehicle.Car;
import com.vehicle.Exceptions.VehicleNotAvailableException;
import com.vehicle.Motorcycle;
import com.vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {
    private RentalAgency rentalAgency;
    private Vehicle car1;
    private Vehicle motorcycle1;

    @BeforeEach
    void setUp() {
        rentalAgency = new RentalAgency();
        car1 = new Car("V1", "Toyota Corolla", 50, true);
        motorcycle1 = new Motorcycle("V2", "Yamaha R15", 30, true);

        rentalAgency.addVehicle(car1);
        rentalAgency.addVehicle(motorcycle1);
    }

    @Test
    void testAddVehicle() {
        Vehicle newCar = new Car("V3", "Honda Civic", 40, true);
        rentalAgency.addVehicle(newCar);

        List<Vehicle> vehicles = rentalAgency.getVehicles();
        assertEquals(3, vehicles.size());
        assertTrue(vehicles.contains(newCar));
    }

    @Test
    void testGetAvailableVehicles() {
        List<Vehicle> availableVehicles = rentalAgency.getAvailableVehicles();

        assertEquals(2, availableVehicles.size());
        assertTrue(availableVehicles.contains(car1));
        assertTrue(availableVehicles.contains(motorcycle1));
    }

    @Test
    void testRentVehicle_Success() throws VehicleNotAvailableException {
        Customer customer = new Customer("John Doe", "1234567890");

        rentalAgency.rentVehicle(car1, customer, 5);

        assertFalse(car1.isAvailable());
    }

    @Test
    void testRentVehicle_ThrowsVehicleNotAvailableException() {
        Customer customer = new Customer("Jane Doe", "0987654321");

        assertThrows(VehicleNotAvailableException.class, () -> {
            car1.setAvailable(false); // Simulate the car being unavailable
            rentalAgency.rentVehicle(car1, customer, 3);
        });
    }

    @Test
    void testReturnVehicle() {
        car1.setAvailable(false); // Simulate the car being rented

        rentalAgency.returnVehicle(car1);

        assertTrue(car1.isAvailable());
    }

    @Test
    void testShowAvailableVehicles_WithVehicles() {
        List<Vehicle> availableVehicles = rentalAgency.getAvailableVehicles();

        assertEquals(2, availableVehicles.size());
    }

    @Test
    void testShowAvailableVehicles_WithNoVehicles() {
        car1.setAvailable(false);
        motorcycle1.setAvailable(false);

        List<Vehicle> availableVehicles = rentalAgency.getAvailableVehicles();
        assertTrue(availableVehicles.isEmpty());
    }
}
