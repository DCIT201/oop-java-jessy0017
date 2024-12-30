package com.vehicle.Exceptions;

/**Custom exception to handle unavailability of vehicles.**/
public class VehicleNotAvailableException extends Exception {
    public VehicleNotAvailableException(String message) {
        super(message);
    }
}