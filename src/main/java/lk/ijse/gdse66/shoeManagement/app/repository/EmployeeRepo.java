package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
}
