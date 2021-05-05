package edu.cscc.degrees.services;

import edu.cscc.degrees.data.CustomerRepository;
import edu.cscc.degrees.model.Cart;
import edu.cscc.degrees.model.Customer;
import edu.cscc.degrees.model.Offer;

import java.util.ArrayList;
import java.util.List;

public class PointOfSaleServiceImpl implements PointOfSaleService {

  public static final String CREDIT_CARD_OFFER_DESC = "Cougars Visa Card";

  CreditBureauService creditBureauService;
  CreditCardService creditCardService;
  LoyaltyProgramService loyaltyProgramService;
  CustomerRepository customerRepository;

  public PointOfSaleServiceImpl(CreditBureauService creditBureauService, CreditCardService creditCardService,
                                LoyaltyProgramService loyaltyProgramService, CustomerRepository customerRepository) {
    this.creditBureauService = creditBureauService;
    this.creditCardService = creditCardService;
    this.loyaltyProgramService = loyaltyProgramService;
    this.customerRepository = customerRepository;
  }

  public List<Offer> getOffers(Customer customer) {
    List<Offer> offers = new ArrayList<>();
    int score = 0;

    try {
      score = creditBureauService.getCreditScore(customer.getTaxID());
    } catch (NoCreditScoreAvailableException e) {
      // Nothing to do, just don't offer them credit
    }
    if (score >= 800) {
      offers.add(new Offer(CREDIT_CARD_OFFER_DESC, "5%"));
    } else if (score >= 740) {
      offers.add(new Offer(CREDIT_CARD_OFFER_DESC, "10%"));
    } else if (score >= 670) {
      offers.add(new Offer(CREDIT_CARD_OFFER_DESC, "15%"));
    } else if (score >= 580) {
      offers.add(new Offer(CREDIT_CARD_OFFER_DESC, "20%"));
    } else if (score >= 300) {
      offers.add(new Offer(CREDIT_CARD_OFFER_DESC, "25%"));
    }

    return offers;
  }

  public double checkout(String cardNumber, String membershipNumber, Cart cart) throws ChargeDeclinedException {
    double totalAmount = cart.getTotal();
    creditCardService.chargeCard(cardNumber, totalAmount);
    if (membershipNumber != null) {
      customerRepository.findByMembershipNumber(membershipNumber)
        .ifPresent(value -> loyaltyProgramService.addLoyaltyPoints(value, Math.round(totalAmount)));
    }
    return totalAmount;
  }


}
