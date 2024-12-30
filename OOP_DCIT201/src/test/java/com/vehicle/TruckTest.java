package com.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    private Truck truck;

    @BeforeEach
    void setUp() {
        // Initialize a new Truck object before each test
        truck = new Truck("T123", "Ford F-150", 150.0, 1000.0);
    }

    // Test Case 1: Constructor Test
    @Test
    void testTruckConstructor() {
        // Verify the truck is correctly initialized with the given parameters
        assertEquals("T123", truck.getVehicleId());
        assertEquals("Ford F-150", truck.getModel());
        assertEquals(150.0, truck.getPricePerDay(), 0.01);
        assertTrue(truck.isAvailable());  // Assuming the constructor sets availability to true
        assertEquals(1000.0, truck.getLoadCapacity(), 0.01);
    }

    // Test Case 2: Getter and Setter for Load Capacity
    @Test
    void testLoadCapacityGetterSetter() {
        // Set a new load capacity
        truck.setLoadCapacity(1200.0);

        // Verify the load capacity is updated correctly
        assertEquals(1200.0, truck.getLoadCapacity(), 0.01);
    }

    // Test Case 3: toString Method Test
    @Test
    void testToString() {
        // Verify the toString method includes the expected load capacity in the output
        String expectedString = "Vehicle ID: T123, Model: Ford F-150, Price per day: 150.0, Available: true, Load Capacity: 1000.0 kg";
        assertEquals(expectedString, truck.toString());
    }
}

