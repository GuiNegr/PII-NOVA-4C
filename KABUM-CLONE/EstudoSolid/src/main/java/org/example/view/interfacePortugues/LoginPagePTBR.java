package org.example.view.interfacePortugues;
import org.example.control.UserManager;
import org.example.model.user.User;
import org.example.service.Criptografia;
import org.example.control.UserSearch;
import org.example.service.VerificaCPF;
import org.example.service.VerificaEmail;

import java.util.*;
import java.lang.*;

import static org.example.model.user.Status.status.HABILITADO;
import static org.example.model.user.Tipo.Grupo.ADMINISTRADOR;
import static org.example.model.user.Tipo.Grupo.ESTOQUISTA;

public class LoginPagePTBR {
    private final String ORANGEANSI = "\u001B[34m";
    private final String PURPLEANSI = "\u001B[35m";
    private final String GREENANSI = "\u001B[32m";
    private final String GOBACKTOORIGINAL = "\u001B[0m";
    private static Scanner sc = new Scanner(System.in);


    public void menuDeEscolhas(){
        boolean continuar = true;
        do{
            System.out.println("-------- Bem Vindo ao Kabum-Clone -------------");
            System.out.println(ORANGEANSI+"1 - Já é cadastrado?");
            System.out.println("2 - Venha ser um Kababy!"+GOBACKTOORIGINAL);
            System.out.println("--------------------------------------------");
            System.out.print(PURPLEANSI +"Informe sua resposta:"+GOBACKTOORIGINAL);
            String op = sc.nextLine();
                if(op.equals("1")) {
                    continuar = false;
                    //form de login
                }else if(op.equals("2")){
                    continuar = false;
                   intermediarioCadastro();
                }
                else {
                    System.out.println("OPÇÃO ERRADA AMIGÃO");
                }
        }while (continuar);
    }

    private void intermediarioCadastro(){
        System.out.println("---------------------------------------------");
        System.out.println(GREENANSI +"Antes de começarmos  \nprecisamos ter certeza que você já não existe no nosso banco de dados ok?");
        boolean continuar = true;
        String email = "";
        do{
            System.out.print("Informe por favor seu email para localizarmos");
            email = sc.nextLine();
            if(VerificaEmail.isEmailValid(email)) continuar = false;
        }while (continuar);
        if (!UserSearch.searchForEmail(email)){
            cadastro(email);
        }
    }
    private void cadastro(String email){
        User user = null;
        boolean continuar = true;
        System.out.println("----------------------------------------------");
        System.out.print(PURPLEANSI+"Informe seu nome: ");
        String nome = sc.nextLine();
        String cpf = "";
        do{
            System.out.print("Informe seu cpf: ");
            cpf = sc.nextLine();
            if(VerificaCPF.verificaCPF(cpf)) continuar = false;
        }while (continuar);
        continuar = true;
        String[] senhas = new String[2];
        do{
            System.out.print("Informe sua senha: ");
            senhas[0] = sc.nextLine();
            System.out.print("Informe novamente sua senha: ");
            senhas[1] = sc.nextLine();
        }while (!senhas[0].equals(senhas[1]));
        String senha = Criptografia.instCod(senhas[0]);
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
        System.out.println("SEJA BEM VINDO: "+ user.getNome().toUpperCase());
        UserManager.addUser(user);
    }
}
