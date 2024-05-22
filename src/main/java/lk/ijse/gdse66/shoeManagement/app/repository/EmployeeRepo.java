package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
    @Query(value = "SELECT employee_code FROM employee ORDER BY employee_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();


}
