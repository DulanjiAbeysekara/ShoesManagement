//package lk.ijse.gdse66.shoeManagement.app.repository;
//
//import lk.ijse.gdse66.shoeManagement.app.entity.SalesDetailsEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface SalesDetailsRepository extends JpaRepository<SalesDetailsEntity,String> {
//
//    Boolean existsBySalesOrderNo(String id);
//
//    List<SalesDetailsEntity> findAllBySalesOrderNo(String id);
//
//    void deleteAllBySalesOrderNo(String id);
//
//    Boolean existsAllBySalesOrderNo(String id);
//}