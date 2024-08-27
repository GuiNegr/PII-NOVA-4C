package org.example.service;

import org.example.model.estoquista.Estoquista;
import org.example.model.dao.BankAdd;
import org.example.model.administrador.Administrador;
import org.example.model.pessoa.Pessoa;

public class ClassManager {
    private static BankAdd add;

    public static void adicionaNoBanco(Pessoa pessoa){
         add = new BankAdd();
         add.adicionaPessoa(pessoa);
         identify(pessoa);
    }

    private static void identify(Pessoa pessoa){
        String identify = pessoa.getClass().getSimpleName();
         add = new BankAdd();
        if(identify.equals("Administrador")){
            add.adicionaFuncionario((Administrador) pessoa);
        }else if (identify.equals("Estoquista")){
            add.adicionaCliente((Estoquista) pessoa);
        }
    }
}
