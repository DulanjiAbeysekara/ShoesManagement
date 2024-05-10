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

    private String Address;
    private String ContactNo1;
    private String ContactNo2;
    private String Email;
}

