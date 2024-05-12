package lk.ijse.gdse66.shoeManagement.app.entity;


import jakarta.persistence.*;
import lk.ijse.gdse66.shoeManagement.app.util.Category;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")

public class SupplierEntity {
    @Id
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String address;
    private String contactNo1;
    private String contactNo2;
    private String email;
}

