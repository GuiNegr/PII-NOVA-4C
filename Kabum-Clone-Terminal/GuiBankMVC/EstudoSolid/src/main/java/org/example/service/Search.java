package org.example.service;

import org.example.model.dao.BankSelect;

public class Search {

    public static boolean searchForCPF(String cpf){
        return BankSelect.returnIFcpfExist(cpf);
    }
}
