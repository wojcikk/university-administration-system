package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
