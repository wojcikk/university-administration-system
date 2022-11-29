package unisystem.domain;

public class User {
    private final long id;
    private final String login;
    private final String password;
    private final Entitlements entitlements;

    public User(long id, String login, String password, Entitlements entitlements) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.entitlements = entitlements;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Entitlements getEntitlements() {
        return entitlements;
    }
}
