package org.example.control;

import org.example.model.user.User;
import java.util.HashMap;
import java.util.Map;

public class UserSearch {
    private static Map<String, User> usersDatabase = new HashMap<>();

    // Método para buscar usuário por e-mail
    public static User searchUserByEmail(String email) {
        return usersDatabase.get(email);
    }


    public static void addUser(User user) {
        usersDatabase.put(user.getEmail(), user);
    }

    // Método para verificar se o e-mail já está cadastrado
    public static boolean searchForEmail(String email) {
        return usersDatabase.containsKey(email);
    }
}