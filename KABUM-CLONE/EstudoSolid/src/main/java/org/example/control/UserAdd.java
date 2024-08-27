package org.example.control;
import org.example.dao.DatabaseAdd;
import org.example.model.user.User;

public class UserAdd {
    private static DatabaseAdd add;

    public static void adicionaNoBanco(User user){
         add = new DatabaseAdd();
         add.adicionaPessoa(user);

    }
}
