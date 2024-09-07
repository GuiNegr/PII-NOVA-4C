package org.example.view.interfacePortugues;

import org.example.model.user.User;

import java.util.Scanner;

public class Estoquista {
    private static User userPrincipal = null;
    private static final String ORANGEANSI = "\u001B[34m";
    private static final String PURPLEANSI = "\u001B[35m";
    private static final String GREENANSI = "\u001B[32m";
    private static final String GOBACKTOORIGINAL = "\u001B[0m";
    private static Scanner sc = new Scanner(System.in);


    public static void telaEstoquista() {


        sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println(GREENANSI+"--------------------------------------");
            System.out.println("Tela principal Backoffice");
            System.out.println("1 - Listar Produto");
            op = sc.nextInt();
        } while (op <= 0 || op >= 3);

      if (op == 1){
          System.out.println("AINDA NÃO DISPONIVEL");
      }
    }
}
