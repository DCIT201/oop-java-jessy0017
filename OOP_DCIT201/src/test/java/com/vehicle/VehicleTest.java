package com.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        // Initialize a new Vehicle object before each test
        vehicle = new Vehicle("V123", "Toyota Corolla", 50.0, true) {};
    }

    // Test Case 1: Constructor Test
    @Test
    void testVehicleConstructor() {
        // Verify the vehicle is correctly initialized with the given parameters
        assertEquals("V123", vehicle.getVehicleId());
        assertEquals("Toyota Corolla", vehicle.getModel());
        assertEquals(50.0, vehicle.getPricePerDay(), 0.01);
        assertTrue(vehicle.isAvailable());
    }

    // Test Case 2: Getter and Setter for Price Per Day
    @Test
    void testPricePerDayGetterSetter() {
        // Set a new price per day
        vehicle.updatePricePerDay(60.0);

        // Verify the price per day is updated correctly
        assertEquals(60.0, vehicle.getPricePerDay(), 0.01);
    }

    // Test Case 3: Getter and Setter for Availability
    @Test
    void testAvailabilityGetterSetter() {
        // Set a new availability status
        vehicle.setAvailable(false);

        // Verify the availability status is updated correctly
        assertFalse(vehicle.isAvailable());
    }

    // Test Case 4: toString Method Test
    @Test
    void testToString() {
        // Verify the toString method returns the expected string representation
        String expectedString = "Vehicle ID: V123, Model: Toyota Corolla, Price Per Day: $50.0, Available: Yes";
        assertEquals(expectedString, vehicle.toString());
    }

    // Test Case 5: Rental Cost Calculation
    @Test
    void testCalculateRentalCost() {
        // Verify the rental cost calculation for 5 days
        double rentalCost = vehicle.calculateRentalCost(5);
        assertEquals(250.0, rentalCost, 0.01);
    }
}

