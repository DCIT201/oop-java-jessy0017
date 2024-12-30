/**
 * The Main class serves as the entry point to the program.
 * It demonstrates the rental of vehicles and handles renting and returning vehicles.
 */

import agency.Customer;
import agency.RentalAgency;
import agency.RentalTransaction;
import com.vehicle.Car;
import com.vehicle.Exceptions.VehicleNotAvailableException;
import com.vehicle.Motorcycle;
import com.vehicle.Truck;
import com.vehicle.Vehicle;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Scanner scanner = new Scanner(System.in);

        // Adding sample vehicles
        agency.addVehicle(new Car("V1", "Toyota Corolla", 50, true));
        agency.addVehicle(new Motorcycle("V2", "Yamaha R15", 30, true));
        agency.addVehicle(new Truck("V3", "Ford F-150", 100, 500));
        agency.addVehicle(new Car("V4", "Honda Civic", 40, true));
        agency.addVehicle(new Truck("V5", "Ram 1500", 90, 600));

        System.out.println("Welcome to the Vehicle Rental System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. View Available Vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    // Validate contact number
                    String contact;
                    while (true) {
                        System.out.print("Enter your contact number (10 digits): ");
                        contact = scanner.nextLine();
                        if (contact.matches("\\d{10}")) {
                            break;
                        } else {
                            System.out.println("Invalid contact number. Please enter exactly 10 digits.");
                        }
                    }
                    Customer customer = new Customer(name, contact);

                    // Display available vehicles
                    System.out.println("\nAvailable Vehicles:");
                    List<Vehicle> availableVehicles = agency.getAvailableVehicles();
                    if (availableVehicles.isEmpty()) {
                        System.out.println("No vehicles are available for rent at the moment.");
                        break;
                    }

                    for (int i = 0; i < availableVehicles.size(); i++) {
                        Vehicle vehicle = availableVehicles.get(i);
                        System.out.println((i + 1) + ". " + vehicle.getModel() + " - $" + vehicle.getPricePerDay() + " per day");
                    }

                    System.out.print("\nEnter the number corresponding to the vehicle you want to rent: ");
                    int vehicleChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (vehicleChoice < 1 || vehicleChoice > availableVehicles.size()) {
                        System.out.println("Invalid choice. Returning to main menu.");
                        break;
                    }

                    Vehicle chosenVehicle = availableVehicles.get(vehicleChoice - 1);

                    System.out.print("Enter number of days to rent: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    try {
                        agency.rentVehicle(chosenVehicle, customer, days);
                        RentalTransaction transaction = new RentalTransaction(customer, chosenVehicle, days);

                        System.out.println("\nRental Successful!");
                        System.out.println("Vehicle: " + chosenVehicle.getModel());
                        System.out.println("Rental Cost: $" + transaction.getTotalCost());
                        System.out.println("Loyalty Points Earned: " + transaction.getTotalCost() / 10);

                    } catch (VehicleNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter the vehicle ID to return: ");
                    String vehicleId = scanner.nextLine();

                    boolean returned = false;
                    for (Vehicle vehicle : agency.getVehicles()) {
                        if (vehicle.getVehicleId().equals(vehicleId) && !vehicle.isAvailable()) {
                            agency.returnVehicle(vehicle);
                            System.out.println("Vehicle returned successfully!");
                            returned = true;
                            break;
                        }
                    }
                    if (!returned) {
                        System.out.println("Invalid vehicle ID or vehicle is not rented.");
                    }
                    break;

                case 3:
                    agency.showAvailableVehicles();
                    break;

                case 4:
                    System.out.println("Thank you for using the Vehicle Rental System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


