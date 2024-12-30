package agency;

/** Represents a Customer renting vehicles.Manages loyalty points and rental history.**/
public class Customer {
    private final String name;
    private final String contact;
    private int loyaltyPoints;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public boolean isEligibleForDiscount() {
        return loyaltyPoints >= 100;
    }
}