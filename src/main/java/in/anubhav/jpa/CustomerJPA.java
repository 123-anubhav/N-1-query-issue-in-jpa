package in.anubhav.jpa;

import in.anubhav.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface CustomerJPA extends JpaRepository<Customer, Serializable> {

    // N + 1 QUERY ISSUE SOLUTION IN JPA
    @EntityGraph(attributePaths = "addresses")
    public List<Customer> findAll();

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.addresses ")
    public List<Customer> fetchCustomerWithAddress();
}
