package edu.cscc.degrees.model;

public class Customer {
    private long id;
    private String membershipNumber;
    private String taxID;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(long id, String membershipNumber, String taxID, String firstName, String lastName) {
        this.id = id;
        this.membershipNumber = membershipNumber;
        this.taxID = taxID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
