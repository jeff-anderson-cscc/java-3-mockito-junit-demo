# Using mocks and stubs to build services

## Description

This repository demonstrates how to use [JUnit 5](https://junit.org/) and [Mockito](https://site.mockito.org/) to create a fully functioning service where external dependencies exist only as interfaces.

The **master** branch contains the starting point, and the **solution** branch contains the implemented service with full test coverage.

## Business Requirements

### 1. Credit Card Offers

The `PointOfSaleService` should offer qualifying customers a *Cougars Visa Card* based on their credit rating: 

![Graphic showing credit score ranges](https://www.experian.com/blogs/ask-experian/wp-content/img/experian-good-score-ranges-fico.png)

| Description | Range | Interest rate
| ----------- | ----- | -------------
| Very Poor | 300-579 | 25%
| Fair | 580-669 | 20%
| Good | 670-739 | 15%
| Very Good | 740-799 | 10%
| Exceptional | 800-850 | 5%

If no credit history exists for the customer, do not offer the customer a Cougars Visa Card.

#### Design notes:

* Use the `CreditBureauService` to determine if the offer should be extended and, if so, the rate for which the customer qualifies. 

### 2. Point of Sale Checkout

1. Given a non-empty shopping cart, and a credit card, the `PointOfSaleService` should use the `CreditCardService` to record a charge for the total amount of items in the order.
1. If the operator provides a customer loyalty program `membershipNumber` at the time of checkout, the `PointOfSaleService` should round the total amount the nearest dollar and add that many loyalty points to the customers account using the `LoyaltyProgramService`. 

#### Design notes:

* The `CreditCardService` will either throw `ChargeDeclinedException` if the credit card cannot be charged, or a transaction confirmation number when the charge is successfully applied.
* Loyalty points will not be added if the charge is declined, or the customer cannot be found in the `CustomerRepository` using the provided `membershipNumber`. 


