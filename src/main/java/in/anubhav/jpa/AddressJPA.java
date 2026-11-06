package in.anubhav.jpa;

import in.anubhav.entity.Address;
import in.anubhav.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface AddressJPA extends JpaRepository<Address, Serializable> {

}
