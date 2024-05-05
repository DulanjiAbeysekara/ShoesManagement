package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.gdse66.shoeManagement.app.util.Category;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class SupplierDTO implements Serializable{
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String Address;
    private String ContactNo1;
    private String ContactNo2;
    private String Emai;
}
