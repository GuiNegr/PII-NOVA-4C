package org.example.control;

import org.example.dao.DatabaseSelect;

public class UserSearch {

    public static boolean searchForEmail(String cpf){
        return DatabaseSelect.returnIfEmailExist(cpf);
    }
}
