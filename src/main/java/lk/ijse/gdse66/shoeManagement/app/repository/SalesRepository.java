package lk.ijse.gdse66.shoeManagement.app.repository;

import lk.ijse.gdse66.shoeManagement.app.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesEntity,String> {

    Boolean existsByOrderNo(String id);

    SalesEntity findByOrderNo(String id);

    void deleteByOrderNo(String id);
}