package com.vehicle;

/**Represents a Truck,extending th Vehicle class with additional load capacity.**/
public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleId, String model, double pricePerDay, double loadCapacity) {
        super(vehicleId, model, pricePerDay, true);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Load Capacity: " + loadCapacity + " kg";
    }
}
