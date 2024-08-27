package org.example.service;

import org.example.model.dao.BankSelect;

public class Search {

    public static boolean searchForEmail(String cpf){
        return BankSelect.returnIfEmailExist(cpf);
    }
}
