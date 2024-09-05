package org.example.view.interfacePortugues;

import org.example.control.UserManager;
import org.example.control.UserSearch;
import org.example.model.service.Criptografia;
import org.example.model.user.User;

import java.util.Scanner;

public class Login {
    private static final String ORANGEANSI = "\u001B[34m";
    private static final String PURPLEANSI = "\u001B[35m";
    private static final String GREENANSI = "\u001B[32m";
    private static final String GOBACKTOORIGINAL = "\u001B[0m";
    private static Scanner sc = new Scanner(System.in);

    protected static void LoginMenu(){
        boolean continuar = true;
        String email;
        System.out.println("--------------------------------------------------------");
       do{
           System.out.print(PURPLEANSI+"Informe seu email: ");
           email = sc.nextLine();
           System.out.print("Informe sua senha: ");
           String senha = sc.nextLine();
          if( UserSearch.procuraPeloLogin(senha,email)) continuar = false;
       }while (continuar);


        if(UserSearch.vejaSeEhUmCliente(email)){
            if(UserSearch.procureOGrupo(email).equalsIgnoreCase("Administrador")){
                opcodesAdministrator();
            }else if(UserSearch.procureOGrupo(email).equalsIgnoreCase("Estoquista")){
                //Menu do estoquista
            }
        }else System.out.println("SEM PERMISSÃO PRA ISSO");
    }



    private static void opcodesAdministrator(){
        System.out.println(GREENANSI+"--------------------------------------");
        System.out.println("oque deseja realizar?");
        System.out.println("1 - Alterar a senha de algum usuario?");
        int op = sc.nextInt();

        if (op == 1) {
            menuAlterarSenha();
        }
    }

    //metodos de opcoes do aministrador

    private static void exibirUsuario(String email){
        User user = UserSearch.retornaUsuario(email);
        System.out.println(user);
    }
    private static void menuAlterarSenha(){

        boolean continuar = true;
        do{System.out.println("----------------------------------------------");
            System.out.print(ORANGEANSI+"informe o email do usuario desejado: ");
            String email = sc.nextLine();
            if(UserSearch.procuraEmail(email)){
                System.out.println("-----------------------------------------");
                exibirUsuario(email);
                System.out.println("-----------------------------------------");
                System.out.println("as informações desse usuario será o desajado para troca?");
                System.out.println("--------------------------------------------");
                System.out.println(GREENANSI+"(S/N)");
                String op = sc.nextLine();
                if(op.equalsIgnoreCase("S") || op.equalsIgnoreCase("Sim")){
                  boolean cont = true;
                  String[] senhas = new String[2];
                    do{
                        System.out.print("Informe a senha nova desejada!: ");
                        senhas[0] = sc.nextLine();
                        System.out.println("Informe a novamente!: ");
                        senhas[1] = sc.nextLine();

                        if(senhas[1].equals(senhas[0])){
                            UserManager.atualizarSenha(email, Criptografia.criptografe(senhas[1]));
                            System.out.println("SENHA DE USUARIO ATUALIZADA");
                            cont = false;
                        }

                    }while (cont);
                    continuar = false;
                }
            }
            else System.out.println(PURPLEANSI+"Usuario não encontrado :(");

        }while (continuar);

    }

}