package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;
import lk.ijse.gdse66.shoeManagement.app.util.Gender;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    private String employeeCode;

    private String employeeName;

    @Column(columnDefinition = "LONGTEXT")
    private String EmployeeProfilePic;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String status;
    private String designation;

    @Enumerated(EnumType.STRING)
    private AccessRole accessRole;

    private Date dob;
    private Date dateOfJoin;
    private String attachedBranch;
    private String address;
    private String contactNo;
}
