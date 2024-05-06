package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    private String EmployeeCode;

    private String EmployeeName;
    private String EmployeeProfilePic;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String Status;
    private String Designation;

    @Enumerated(EnumType.STRING)
    private AccessRole accessRole;

    private Date Dob;
    private Date DateOfJoin;
    private String AttachedBranch;
    private String Address;
    private String ContactNo;
}
