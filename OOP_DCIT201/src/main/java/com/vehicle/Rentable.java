package com.vehicle;

import agency.Customer;

/**Rentable Interface**/
public interface Rentable {

    /**Rents the vehicle to a customer for a specified number of days.
     * @param customer the customer renting the vehicle
     * @param days     the number of days to rent the vehicle
     * @throws Exception if the vehicle is not available or other errors occur
     **/

    void rent(Customer customer, int days) throws Exception;

    void returnVehicle();
}



