package com.vehicle;

import com.vehicle.Motorcycle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    @Test
    void testMotorcycleInitialization() {
        // Arrange
        String vehicleId = "M1";
        String model = "Yamaha R15";
        double pricePerDay = 30.0;
        boolean available = true;

        // Act
        Motorcycle motorcycle = new Motorcycle(vehicleId, model, pricePerDay, available);

        // Assert
        assertEquals(vehicleId, motorcycle.getVehicleId());
        assertEquals(model, motorcycle.getModel());
        assertEquals(pricePerDay, motorcycle.getPricePerDay());
        assertTrue(motorcycle.isAvailable());
    }

    @Test
    void testSetAvailability() {
        // Arrange
        Motorcycle motorcycle = new Motorcycle("M1", "Yamaha R15", 30.0, true);

        // Act
        motorcycle.setAvailable(false);

        // Assert
        assertFalse(motorcycle.isAvailable());
    }

    @Test
    void testUpdatePricePerDay() {
        // Arrange
        Motorcycle motorcycle = new Motorcycle("M1", "Yamaha R15", 30.0, true);

        // Act
        motorcycle.updatePricePerDay(35.0);

        // Assert
        assertEquals(35.0, motorcycle.getPricePerDay());
    }

    @Test
    void testToString() {
        // Arrange
        Motorcycle motorcycle = new Motorcycle("M1", "Yamaha R15", 30.0, true);

        // Act
        String motorcycleString = motorcycle.toString();

        // Assert
        assertTrue(motorcycleString.contains("Vehicle ID: M1"));
        assertTrue(motorcycleString.contains("Model: Yamaha R15"));
        assertTrue(motorcycleString.contains("Price Per Day: $30.0"));
        assertTrue(motorcycleString.contains("Available: Yes"));
    }
}

