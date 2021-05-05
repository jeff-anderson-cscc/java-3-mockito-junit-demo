package edu.cscc.degrees.services;

public interface CreditCardService {
    /**
     * Charge amount to the specified credit card
     * @param cardNumber the card number to charge
     * @param amount the amount of the charge
     * @return the transaction confirmation number
     * @throws ChargeDeclinedException if the card is invalid or the customer is over their limit
     */
    String chargeCard (String cardNumber, double amount) throws ChargeDeclinedException;
}
