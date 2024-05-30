package lk.ijse.gdse66.shoeManagement.app.auth.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SingUpRequest {
    private String email;
    private String password;
    private String role;
}
