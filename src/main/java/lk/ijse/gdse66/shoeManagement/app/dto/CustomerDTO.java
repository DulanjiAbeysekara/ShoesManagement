package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lk.ijse.gdse66.shoeManagement.app.util.Level;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO{
   private String  CustomerCode;
   private String CustomerName;
   private Gender gender;
   private Date JoinDateLoyaltyCustomer;
   private Level level;
   private int TotalPoints;
   private Date DOB;
   private String Address;

}
