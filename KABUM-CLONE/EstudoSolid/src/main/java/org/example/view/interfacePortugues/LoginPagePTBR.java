package org.example.view.interfacePortugues;
import org.example.controladores.userManager;
import org.example.model.administrador.Administrador;
import org.example.model.estoquista.Estoquista;
import org.example.model.pessoa.Pessoa;
import org.example.model.pessoa.Tipo;
import org.example.service.Search;

import java.util.*;
import java.lang.*;

import static org.example.model.pessoa.Tipo.tipo.Estoquista;

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
        System.out.print("Informe por favor seu cpf sem pontos para localizarmos");
        String cpf = sc.nextLine();
        if (!Search.searchForCPF(cpf)){
            cadastro(cpf);
        }
    }
    private void cadastro(String cpf){
        System.out.println("----------------------------------------------");
        System.out.print(PURPLEANSI+"Informe seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Informe seu rg sem os pontos: ");
        String rg = sc.nextLine();
        System.out.println("Informe a data de nascimento sem pontos e barras ex: 020903: ");
        String data = sc.nextLine();
        System.out.println("Informe você está cadastrando administrador ou estoquista??");
        String op = sc.nextLine();
        Pessoa pessoa = null;
        if(op.equalsIgnoreCase("estoquista")){
            pessoa = new Estoquista(nome,cpf,rg,data, Estoquista,"1",0);
        }else if(op.equalsIgnoreCase("administrador")){
            pessoa = new Administrador(nome,cpf,rg,data, Tipo.tipo.Administrador,"1",0);
        }
        userManager.addCliente(pessoa);
        System.out.println("Seja muito bem vindo: "+nome.toUpperCase());
    }
}
