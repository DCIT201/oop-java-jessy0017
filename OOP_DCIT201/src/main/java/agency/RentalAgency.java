package agency;

import com.vehicle.Vehicle;
import com.vehicle.Exceptions.VehicleNotAvailableException;
import java.util.ArrayList;
import java.util.List;

/**Manages a fleet of vehicles and rental transactions.**/
public class RentalAgency {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**Method to get all available vehicles**/
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**Method to rent a vehicle by directly passing the Vehicle object**/
    public void rentVehicle(Vehicle vehicle, Customer customer, int days) throws VehicleNotAvailableException {
        if (!vehicle.isAvailable()) {
            throw new VehicleNotAvailableException("The selected vehicle is not available for rent.");
        }

        vehicle.setAvailable(false);
        System.out.println("Vehicle rented successfully to: " + customer.getName());
    }

    /** Method to return a rented vehicle**/
    public void returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true);
        System.out.println("Vehicle " + vehicle.getModel() + " (ID: " + vehicle.getVehicleId() + ") is now available.");
    }

    /** Method to display available vehicles in a user-friendly format**/
    public void showAvailableVehicles() {
        List<Vehicle> availableVehicles = getAvailableVehicles();
        if (availableVehicles.isEmpty()) {
            System.out.println("No vehicles are currently available for rent.");
            return;
        }


        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : availableVehicles) {
            System.out.println("ID: " + vehicle.getVehicleId() + ", Model: " + vehicle.getModel() + ", Price/Day: $" + vehicle.getPricePerDay());
        }
    }
}

