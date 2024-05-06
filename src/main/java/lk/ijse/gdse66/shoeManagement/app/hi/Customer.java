package lk.ijse.gdse66.shoeManagement.app.hi;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lk.ijse.gdse66.shoeManagement.app.util.Level;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Customer {
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
