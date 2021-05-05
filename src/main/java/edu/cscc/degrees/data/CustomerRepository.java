package edu.cscc.degrees.data;

import edu.cscc.degrees.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
  Optional<Customer> findByMembershipNumber(String membershipNumber);
}
