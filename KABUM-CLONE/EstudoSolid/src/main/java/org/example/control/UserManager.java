package org.example.control;

import org.example.model.user.User;

public class UserManager {
    public static void addUser(User user){
        UserAdd.adicionaNoBanco(user);
    }

    public static void updateUser(User user) {
    }
}
