package app.core.model;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

//TODO: transform to record?
@Value
public class AuthRequest {
    @NotNull
    String username;
    @NotNull
    String password;
}
