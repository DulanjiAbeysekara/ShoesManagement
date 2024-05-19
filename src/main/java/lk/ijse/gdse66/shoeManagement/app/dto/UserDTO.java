package lk.ijse.gdse66.shoeManagement.app.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String userId;
    private String email;
    private String password;
    private AccessRole accessRole;

}
