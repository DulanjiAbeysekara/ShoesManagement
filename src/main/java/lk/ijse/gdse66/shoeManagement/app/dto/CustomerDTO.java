package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lk.ijse.gdse66.shoeManagement.app.util.Level;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomerDTO implements Serializable {
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
