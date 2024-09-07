package org.example.control;

import org.example.model.dao.DatabaseSelect;
import org.example.model.service.Criptografia;
import org.example.model.user.User;

import java.sql.SQLException;

public class UserSearch {

    public static boolean procuraEmail(String email){
        return DatabaseSelect.retornaSeOEMailExiste(email);
    }
    public static boolean procuraPeloLogin(String senha, String email){
        senha = Criptografia.criptografe(senha);
        return DatabaseSelect.retornaUmLogin(senha,email);
    }

    public static User procuraPeloID(Long id) throws SQLException {
        return DatabaseSelect.returnUserPorID(id);
    }
    public static boolean vejaSeEhUmCliente(String email){
        return !DatabaseSelect.retornaSeNaoForCliente(email);
    }
    public static String procureOGrupo(String email){
        return DatabaseSelect.retornaOGrupo(email);
    }
    public static User retornaUsuario(String email){
        return DatabaseSelect.returnUserComplete(email);
    }
}
