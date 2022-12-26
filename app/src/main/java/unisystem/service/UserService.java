package unisystem.service;

import unisystem.domain.Entitlements;
import unisystem.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User authenticate();
    void addUser(String email, Entitlements entitlements);

    void deleteUser(String email);

    User findUserByEmail(String email);
}
