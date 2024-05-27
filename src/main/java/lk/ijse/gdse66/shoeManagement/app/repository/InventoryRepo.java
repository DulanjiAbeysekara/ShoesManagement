package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.CustomerEntity;
import lk.ijse.gdse66.shoeManagement.app.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepo extends JpaRepository<InventoryEntity,String> {

    @Query(value = "SELECT item_code FROM inventory ORDER BY item_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    List<InventoryEntity> findByItemCodeStartingWith(String id);


}
