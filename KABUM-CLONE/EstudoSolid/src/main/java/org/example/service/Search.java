package org.example.service;

import org.example.dao.DatabaseSelect;

public class Search {

    public static boolean searchForEmail(String cpf){
        return DatabaseSelect.returnIfEmailExist(cpf);
    }
}
