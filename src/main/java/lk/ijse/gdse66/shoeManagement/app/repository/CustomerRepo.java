package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {

    List<CustomerEntity> findByCustomerNameStartingWith(String customerName);
}
