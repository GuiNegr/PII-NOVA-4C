package org.example.view.interfacePortugues;

import org.example.control.UserSearch;
import org.example.model.dao.DatabaseSelect;
import org.example.model.user.User;

import java.util.Scanner;

public class Login {

    private static User userPrincipal = null;
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
                userPrincipal = DatabaseSelect.returnUserComplete(email);
                Admin.telaBackofficeAdmin();
            }else if(UserSearch.procureOGrupo(email).equalsIgnoreCase("Estoquista")){
                Estoquista.telaEstoquista();
            }
        }else System.out.println("SEM PERMISSÃO PRA ISSO");
    }


}




