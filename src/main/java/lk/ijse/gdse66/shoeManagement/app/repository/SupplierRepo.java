package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepo  extends JpaRepository<SupplierEntity,String> {

    @Query(value = "SELECT code FROM supplier ORDER BY code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
