package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.InventoryEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepo extends JpaRepository<SalesEntity,String> {
    SalesEntity findTopByOrderByOrderIdDesc();

//    @Query(value = "SELECT * FROM sales WHERE order_date >= DATE_SUB(CURRENT_TIMESTAMP, INTERVAL 3 DAY)", nativeQuery = true)
//    List<SalesEntity> getAllRefundOrders();

    @Query(value = "SELECT * FROM sales WHERE order_id =:orderId", nativeQuery = true)
    SalesEntity findByOrderId(String orderId);

    SalesEntity findOrderByOrderId(String orderId);
}
