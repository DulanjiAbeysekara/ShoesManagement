package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.gdse66.shoeManagement.app.util.Category;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierDTO implements Serializable{
    private String code;
    private String name;
    private Category category;
    private String address;
    private String contactNo1;
    private String contactNo2;
    private String email;

}
