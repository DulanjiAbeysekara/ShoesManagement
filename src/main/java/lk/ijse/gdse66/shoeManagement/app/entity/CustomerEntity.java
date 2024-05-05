package lk.ijse.gdse66.shoeManagement.app.entity;


import jakarta.persistence.*;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lk.ijse.gdse66.shoeManagement.app.util.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "customer")

public class CustomerEntity {
    @Id
    private String  CustomerCode;
    private String CustomerName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date JoinDateLoyaltyCustomer;

    @Enumerated(EnumType.STRING)
    private Level level;

    private int TotalPoints;
    private Date DOB;
    private String Address;

}
