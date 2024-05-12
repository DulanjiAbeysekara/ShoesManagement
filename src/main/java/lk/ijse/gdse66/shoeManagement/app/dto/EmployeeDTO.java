package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO implements Serializable {
    private String employeeCode;
    private String employeeName;
//    private String EmployeeProfilePic;
    private Gender gender;
    private String status;
    private String designation;
    private AccessRole accessRole;
    private Date dob;
    private Date dateOfJoin;
    private String attachedBranch;
    private String address;
    private String contactNo;
}
