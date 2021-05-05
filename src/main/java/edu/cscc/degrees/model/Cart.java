package edu.cscc.degrees.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Customer customer;
    List<LineItem> items = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void addItem(LineItem lineItem) {
        items.add(lineItem);
    }

    public double getTotal() {
        double returnValue = 0;
        for (LineItem item: items) {
            returnValue += (item.getQuantity() * item.getPrice());
        }
        return returnValue;
    }
}
