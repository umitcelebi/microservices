package org.ucelebi.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ucelebi.customer.model.Customer;

/**
 * @author UMITCELEBI
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
