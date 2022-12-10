package unisystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "entitlements")
    private Entitlements entitlements;

    public User(String email, String password, Entitlements entitlements) {
        this.email = email;
        this.password = password;
        this.entitlements = entitlements;
    }
}
