package org.example.control;

import org.example.model.dao.DatabaseSelect;

public class UserSearch {

    public static boolean searchForEmail(String cpf){
        return DatabaseSelect.returnIfEmailExist(cpf);
    }
}
