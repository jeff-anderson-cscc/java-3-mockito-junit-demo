package edu.cscc.degrees.services;

public interface CreditBureauService {

    /**
     * Get the current credit score of the specified person
     * @param taxID their tax identification / social security number
     * @return the FICO credit score in a range of 300-850 https://www.experian.com/blogs/ask-experian/wp-content/img/experian-good-score-ranges-fico.png
     * @throws NoCreditScoreAvailableException when no credit score is available for the tax ID
     */
    int getCreditScore(String taxID) throws NoCreditScoreAvailableException;
}
