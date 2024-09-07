package org.example.control;
import org.example.model.dao.DatabaseAdd;
import org.example.model.dao.DatabaseSelect;
import org.example.model.user.User;

public class UserManager {
    private static DatabaseAdd add;

    public static void adicionaNoBanco(User user){
         add = new DatabaseAdd();
         add.adicionaPessoa(user);

    }

    public static void alterarUsuario(Long id) {
        DatabaseAdd.updateUsuario(DatabaseSelect.returnUserPorID(id));
    }

    public static void alterarUsuario(User user) {
        DatabaseAdd.updateUsuario(user);
    }
    public static void atualizarSenha(String email, String senha){
        DatabaseAdd.trocaSenha(email,senha);
    }

    public static void atualizarSenhaById(Long id, String senha) {
        DatabaseAdd.trocarSenhaById(senha, id);
    }

    public static void atualizaStatus(String status, Long id){
        DatabaseAdd.trocaStatus(status,id);
    }
}
