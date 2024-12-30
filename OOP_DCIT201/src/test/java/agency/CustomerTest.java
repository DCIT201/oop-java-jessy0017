package agency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCustomerInitialization() {
        // Arrange & Act
        Customer customer = new Customer("John Doe", "1234567890");

        // Assert
        assertEquals("John Doe", customer.getName());
        assertEquals("1234567890", customer.getContact());
        assertEquals(0, customer.getLoyaltyPoints()); // Loyalty points should start at 0
    }

    @Test
    void testAddLoyaltyPoints() {
        // Arrange
        Customer customer = new Customer("Jane Doe", "0987654321");

        // Act
        customer.addLoyaltyPoints(50);
        customer.addLoyaltyPoints(30);

        // Assert
        assertEquals(80, customer.getLoyaltyPoints());
    }

    @Test
    void testIsEligibleForDiscount_WithEnoughPoints() {
        // Arrange
        Customer customer = new Customer("Alice", "1231231234");
        customer.addLoyaltyPoints(100);

        // Act
        boolean eligible = customer.isEligibleForDiscount();

        // Assert
        assertTrue(eligible);
    }

    @Test
    void testIsEligibleForDiscount_WithInsufficientPoints() {
        // Arrange
        Customer customer = new Customer("Bob", "4564564567");
        customer.addLoyaltyPoints(99);

        // Act
        boolean eligible = customer.isEligibleForDiscount();

        // Assert
        assertFalse(eligible);
    }
}

