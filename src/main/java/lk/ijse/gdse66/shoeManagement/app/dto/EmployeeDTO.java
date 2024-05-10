package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmployeeDTO implements Serializable {
    private String EmployeeCode;
    private String EmployeeName;
    private String EmployeeProfilePic;
    private Gender gender;
    private String Status;
    private String Designation;
    private AccessRole accessRole;
    private Date Dob;
    private Date DateOfJoin;
    private String AttachedBranch;
    private String Address;
    private String ContactNo;
}
