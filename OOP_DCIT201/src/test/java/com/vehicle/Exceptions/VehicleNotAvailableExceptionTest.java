package com.vehicle.Exceptions;

import com.vehicle.Exceptions.VehicleNotAvailableException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleNotAvailableExceptionTest {

    @Test
    void testExceptionMessage() {
        String message = "The selected vehicle is not available for rent.";
        VehicleNotAvailableException exception = new VehicleNotAvailableException(message);

        // Verify that the exception message is correct
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testExceptionInheritance() {
        VehicleNotAvailableException exception = new VehicleNotAvailableException("Error");

        // Verify that it is a subclass of Exception
        assertTrue(exception instanceof Exception);
    }
}

