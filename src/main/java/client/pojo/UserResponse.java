package client.pojo;

import lombok.Data;

import java.util.Collection;
import java.util.List;
@Data
public class UserResponse {
    private Long id;
    private String email;
    private String password;
    private Collection<RoleResponse> roles;
}
