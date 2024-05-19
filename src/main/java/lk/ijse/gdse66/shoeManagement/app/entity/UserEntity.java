package lk.ijse.gdse66.shoeManagement.app.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;

public class UserEntity {
    @Id
    private String userId;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccessRole accessRole;
}
