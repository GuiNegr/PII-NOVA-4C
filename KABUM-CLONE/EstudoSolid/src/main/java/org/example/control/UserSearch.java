package org.example.control;

import org.example.model.dao.DatabaseSelect;
import org.example.model.service.Criptografia;

public class UserSearch {

    public static boolean procuraEmail(String email){
        return DatabaseSelect.retornaSeOEMailExiste(email);
    }

    public static boolean procuraPeloLogin(String senha, String email){
        senha = Criptografia.criptografe(senha);
        return DatabaseSelect.retornaUmLogin(senha,email);
    }
    public static boolean vejaSeEhUmCliente(String email){
        return !DatabaseSelect.retornaSeNaoForCliente(email);
    }
    public static String procureOGrupo(String email){
        return DatabaseSelect.retornaOGrupo(email);
    }
}
