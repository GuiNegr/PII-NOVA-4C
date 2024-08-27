package org.example.service;
import org.example.model.dao.BankAdd;
import org.example.model.pessoa.Pessoa;

public class ClassManager {
    private static BankAdd add;

    public static void adicionaNoBanco(Pessoa pessoa){
         add = new BankAdd();
         add.adicionaPessoa(pessoa);

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
