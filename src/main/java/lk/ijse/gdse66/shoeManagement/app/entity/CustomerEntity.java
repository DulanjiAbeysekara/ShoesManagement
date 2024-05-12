package lk.ijse.gdse66.shoeManagement.app.entity;


import jakarta.persistence.*;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lk.ijse.gdse66.shoeManagement.app.util.Level;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")

public class CustomerEntity {
    @Id
    private String  customerCode;
    private String customerName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date joinDateLoyaltyCustomer;

    @Enumerated(EnumType.STRING)
    private Level level;

    private int totalPoints;
    private Date dateOfBirth;
    private String address;

}
