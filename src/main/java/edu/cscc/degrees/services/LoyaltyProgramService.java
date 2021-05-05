package edu.cscc.degrees.services;

import edu.cscc.degrees.model.Customer;

public interface LoyaltyProgramService {

    /**
     * Add the specificed number of loyalty points to the customers account
     * @param customer the customer for this purchase
     * @param points the number of points to add
     */
    void addLoyaltyPoints(Customer customer, long points);

}
