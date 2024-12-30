package com.vehicle;

import agency.Customer;

public class TestRentableVehicle implements Rentable {
    private boolean isRented = false;
    private Customer currentCustomer = null;
    private int rentalDays = 0;

    @Override
    public void rent(Customer customer, int days) throws Exception {
        if (isRented) {
            throw new Exception("Vehicle is already rented.");
        }
        this.isRented = true;
        this.currentCustomer = customer;
        this.rentalDays = days;
    }

    @Override
    public void returnVehicle() {
        this.isRented = false;
        this.currentCustomer = null;
        this.rentalDays = 0;
    }

    public boolean isRented() {
        return isRented;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public int getRentalDays() {
        return rentalDays;
    }
}
