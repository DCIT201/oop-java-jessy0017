package com.vehicle;

import com.vehicle.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCarInitialization() {
        // Arrange
        String vehicleId = "V1";
        String model = "Toyota Corolla";
        double pricePerDay = 50.0;
        boolean available = true;

        // Act
        Car car = new Car(vehicleId, model, pricePerDay, available);

        // Assert
        assertEquals(vehicleId, car.getVehicleId());
        assertEquals(model, car.getModel());
        assertEquals(pricePerDay, car.getPricePerDay());
        assertTrue(car.isAvailable());
    }

    @Test
    void testSetAvailability() {
        // Arrange
        Car car = new Car("V1", "Toyota Corolla", 50.0, true);

        // Act
        car.setAvailable(false);

        // Assert
        assertFalse(car.isAvailable());
    }

    @Test
    void testUpdatePricePerDay() {
        // Arrange
        Car car = new Car("V1", "Toyota Corolla", 50.0, true);

        // Act
        car.updatePricePerDay(60.0);

        // Assert
        assertEquals(60.0, car.getPricePerDay());
    }

    @Test
    void testToString() {
        // Arrange
        Car car = new Car("V1", "Toyota Corolla", 50.0, true);

        // Act
        String carString = car.toString();

        // Assert
        assertTrue(carString.contains("Vehicle ID: V1"));
        assertTrue(carString.contains("Model: Toyota Corolla"));
        assertTrue(carString.contains("Price Per Day: $50.0"));
        assertTrue(carString.contains("Available: Yes"));
    }
}

