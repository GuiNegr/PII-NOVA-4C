package org.example.control;

import org.example.model.user.User;
import org.example.service.ClassManager;

public class UserManager {
    public static void addUser(User user){
        ClassManager.adicionaNoBanco(user);
    }
}
