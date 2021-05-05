package edu.cscc.degrees.services;

import edu.cscc.degrees.model.Cart;
import edu.cscc.degrees.model.Customer;
import edu.cscc.degrees.model.Offer;

import java.util.List;

public interface PointOfSaleService {

  /**
   * Get applicable offers for the given customer
   * @param customer the customer for which to get offers
   * @return a list of offers available to the customer
   */
  List<Offer> getOffers(Customer customer);
  double checkout(String cardNumber, String membershipNumber, Cart cart) throws ChargeDeclinedException;

}
