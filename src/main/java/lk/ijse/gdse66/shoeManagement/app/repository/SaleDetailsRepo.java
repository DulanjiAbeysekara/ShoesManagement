package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.InventoryEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SalesDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleDetailsRepo extends JpaRepository<SalesDetailEntity,String> {

    @Query(value = "SELECT * FROM sales_details WHERE order_id = :orderId", nativeQuery = true)
    List<SalesDetailEntity> findOrderDetailsByOrderId(String orderId);
}
