package com.vehicle;


import agency.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentableTest {
    private TestRentableVehicle rentableVehicle;

    @BeforeEach
    void setUp() {
        rentableVehicle = new TestRentableVehicle();
    }

    @Test
    void testRentVehicleSuccess() throws Exception {
        // Arrange
        Customer customer = new Customer("John Doe", "1234567890");

        // Act
        rentableVehicle.rent(customer, 5);

        // Assert
        assertTrue(rentableVehicle.isRented());
        assertEquals(customer, rentableVehicle.getCurrentCustomer());
        assertEquals(5, rentableVehicle.getRentalDays());
    }

    @Test
    void testRentVehicleFailure() {
        // Arrange
        Customer customer1 = new Customer("John Doe", "1234567890");
        Customer customer2 = new Customer("Jane Smith", "0987654321");

        // Act
        assertDoesNotThrow(() -> rentableVehicle.rent(customer1, 3));

        // Assert
        Exception exception = assertThrows(Exception.class, () -> rentableVehicle.rent(customer2, 2));
        assertEquals("Vehicle is already rented.", exception.getMessage());
    }

    @Test
    void testReturnVehicle() throws Exception {
        // Arrange
        Customer customer = new Customer("John Doe", "1234567890");
        rentableVehicle.rent(customer, 5);

        // Act
        rentableVehicle.returnVehicle();

        // Assert
        assertFalse(rentableVehicle.isRented());
        assertNull(rentableVehicle.getCurrentCustomer());
        assertEquals(0, rentableVehicle.getRentalDays());
    }
}

