package org.example.view.interfacePortugues;

import org.example.control.UserSearch;

import java.util.Scanner;

public class Login {
    private static final String ORANGEANSI = "\u001B[34m";
    private static final String PURPLEANSI = "\u001B[35m";
    private static final String GREENANSI = "\u001B[32m";
    private static final String GOBACKTOORIGINAL = "\u001B[0m";
    private static Scanner sc = new Scanner(System.in);

    public static void validaLogin(){
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
                //Menu do ademar
            }else if(UserSearch.procureOGrupo(email).equalsIgnoreCase("Estoquista")){
                //Menu do estoquista
            }
        }else System.out.println("SEM PERMISSÃO PRA ISSO");
    }
}