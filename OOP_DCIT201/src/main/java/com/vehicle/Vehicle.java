package com.vehicle;

/**Abstract class representing a  vehicle.Implements common properties and methods for all types of vehicles.**/
public abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double pricePerDay;
    private boolean available;

    public Vehicle(String vehicleId, String model, double pricePerDay, boolean available) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = available;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void updatePricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId + ", Model: " + model + ", Price Per Day: $" + pricePerDay + ", Available: " + (available ? "Yes" : "No");
    }

    public double calculateRentalCost(int daysRented) {
        return pricePerDay * daysRented;
    }
}

