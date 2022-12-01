package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private long id;
    private String login;
    private String password;
    private Entitlements entitlements;

    public User(String login, String password, Entitlements entitlements) {
        this.login = login;
        this.password = password;
        this.entitlements = entitlements;
    }
}
