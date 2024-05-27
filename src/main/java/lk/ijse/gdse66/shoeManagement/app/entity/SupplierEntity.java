package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeManagement.app.entity.InventoryEntity;
import lk.ijse.gdse66.shoeManagement.app.util.Category;
//import lk.ijse.gdse66.springboot.backend.util.SuplierCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supplier")

public class SupplierEntity {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contactNo1")
    private String contactNo1;

    @Column(name = "contactNo2")
    private String contactNo2;

    @Column(name = "email")
    private String email;

//    private InventoryEntity inventory;
}