package lk.ijse.gdse66.shoeManagement.app.auth.request;

import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    private String email;
    private String password;
    private AccessRole accessRole;

}
