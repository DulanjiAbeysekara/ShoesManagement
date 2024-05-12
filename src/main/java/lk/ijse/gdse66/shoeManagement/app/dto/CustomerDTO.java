package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lk.ijse.gdse66.shoeManagement.app.util.Level;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO implements Serializable {
   private String  customerCode;
   private String customerName;
   private Gender gender;
   private Date joinDateLoyaltyCustomer;
   private Level level;
   private int totalPoints;
   private Date dateOfBirth;
   private String address;

}
