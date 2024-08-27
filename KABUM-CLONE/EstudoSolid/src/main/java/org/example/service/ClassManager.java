package org.example.service;
import org.example.dao.DatabaseAdd;
import org.example.model.user.User;

public class ClassManager {
    private static DatabaseAdd add;

    public static void adicionaNoBanco(User user){
         add = new DatabaseAdd();
         add.adicionaPessoa(user);

    }
    public boolean verificaCpf(String cpf){
        cpf = cpf.replace("[^\\d]","");

        if(cpf.length() != 11)
            return false;
        int soma = 0;
        try {

            return false;
        }catch (Exception e){
            return false;
        }
    }
}
