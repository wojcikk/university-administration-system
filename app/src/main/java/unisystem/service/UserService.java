package unisystem.service;

import unisystem.domain.Entitlements;
import unisystem.domain.User;

public interface UserService {
    User authenticate();
    void addUser(String email, Entitlements entitlements);

    void deleteUser(String email);
}
