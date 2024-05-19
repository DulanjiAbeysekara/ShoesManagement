package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.*;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String userId;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccessRole accessRole;
}
