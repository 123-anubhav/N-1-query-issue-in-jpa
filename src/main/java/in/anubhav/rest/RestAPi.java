package in.anubhav.rest;

import in.anubhav.entity.Customer;
import in.anubhav.jpa.CustomerJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class RestAPi {

    @Autowired
    private CustomerJPA cust;

    @GetMapping
    public List<Customer> getAllCustomer() {
        /*
        PREDEFINED METHOD
        return cust.findAll();
        */

        /*
        ENTITYgRAPH SOLVE (N +1) METHOD -SOLUTION-1
        return cust.findAll();
        */
        // JOIN FETCH SOLVE -SOLUTION-2
        return cust.fetchCustomerWithAddress();
    }

    // POST Endpoint to save customer along with their addresses
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        // Essential for bidirectional relationships: Link each address to the customer
        if (customer.getAddresses() != null) {
            customer.getAddresses().forEach(address -> address.setCustomer(customer));
        }
        return cust.save(customer);
    }
}
