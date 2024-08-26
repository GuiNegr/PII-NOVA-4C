package org.example.controladores;

import org.example.model.pessoa.Pessoa;
import org.example.service.ClassManager;

public class ClienteManager {
    public static void addCliente(Pessoa cliente){
        ClassManager.adicionaNoBanco(cliente);
    }
}
