package org.example.view.interfacePortugues;
import org.example.control.UserManager;
import org.example.model.service.ManipulaCPF;
import org.example.model.service.VerificaEmail;
import org.example.model.user.User;
import org.example.model.service.Criptografia;
import org.example.control.UserSearch;


import java.util.*;
import java.lang.*;

import static org.example.model.user.Status.StatusDatabase.HABILITADO;
import static org.example.model.user.Tipo.Grupo.ADMINISTRADOR;
import static org.example.model.user.Tipo.Grupo.ESTOQUISTA;

public class Cadastro {
    private static final String ORANGEANSI = "\u001B[34m";
    private static final String PURPLEANSI = "\u001B[35m";
    private static final String GREENANSI = "\u001B[32m";
    private static final String GOBACKTOORIGINAL = "\u001B[0m";
    private static Scanner sc = new Scanner(System.in);


    protected static void MenuDeCadastro(){
     intermediarioCadastro();
    }

    private static void intermediarioCadastro(){
        System.out.println("---------------------------------------------");
        System.out.println(GREENANSI +"Antes de começarmos  \nprecisamos ter certeza que você já não existe no nosso banco de dados ok?");
        boolean continuar = true;
        String email = "";
        do{
            System.out.print("Informe por favor seu email para localizarmos");
            email = sc.nextLine();
            if(VerificaEmail.isEmailValid(email)) continuar = false;
        }while (continuar);
        if (!UserSearch.procuraEmail(email)){
            cadastro();
        }
    }
    protected static void cadastro(){
        User user = null;
        boolean continuar = true;
        String email;
        System.out.println("----------------------------------------------");
        System.out.print(PURPLEANSI+"Informe o nome: ");
        String nome = sc.nextLine();
        String cpf = "";
        do{
            System.out.print("Informe o cpf: ");
            cpf = sc.nextLine();
            if(ManipulaCPF.verificaCPF(cpf)) continuar = false;
        }while (continuar);
        cpf = ManipulaCPF.retiraPontoDoCPF(cpf);
        continuar = true;
        do {
            System.out.println("Informe o email: ");
            email = sc.next();
            if(VerificaEmail.isEmailValid(email)) {
                if (!UserSearch.procuraEmail(email)) {
                    continuar = false;
                } else {
                    System.out.println("Email inválido ou já cadastrado. Tente novamente!");
                }
            }
        } while (continuar);
        String[] senhas = new String[2];
        do{
            System.out.print("Informe a senha: ");
            senhas[0] = sc.nextLine();
            sc.next();
            System.out.print("Informe novamente a senha: ");
            sc.next();
            senhas[1] = sc.nextLine();
        }while (!senhas[0].equals(senhas[1]));
        String senha = Criptografia.criptografe(senhas[0]);
        do{
            System.out.println("Informe o tipo do usuario: Administrador ou Estoquista");
            String tipo = sc.nextLine();

            if(tipo.equalsIgnoreCase("Administrador")){
                user = new User(nome,cpf,email,senha, ADMINISTRADOR, HABILITADO);
                continuar=false;
            }
            else if(tipo.equalsIgnoreCase("Estoquista")){
                user = new User(nome,cpf,email,senha, ESTOQUISTA, HABILITADO);
                continuar=false;
            }
        }while (continuar);
        System.out.println("Salvar? (Y/N)");
        char opcSalvar = sc.nextLine().toUpperCase().charAt(0);
        if (opcSalvar == 'Y') {
            UserManager.adicionaNoBanco(user);
            Login.listarUsuario();
        } else {
            Login.listarUsuario();
        }
    }
}
