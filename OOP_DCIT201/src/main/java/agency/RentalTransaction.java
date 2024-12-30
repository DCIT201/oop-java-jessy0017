package agency;

import com.vehicle.Vehicle;

/**Represents a rental transaction between a customer and a vehicle.**/
public class RentalTransaction {
    private final Customer customer;
    private final Vehicle vehicle;
    private final int daysRented;
    private final double totalCost;

    public RentalTransaction(Customer customer, Vehicle vehicle, int daysRented) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.daysRented = daysRented;
        this.totalCost = vehicle.calculateRentalCost(daysRented);
        customer.addLoyaltyPoints((int) totalCost / 10);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getTotalCost() {
        return totalCost;
    }
}

