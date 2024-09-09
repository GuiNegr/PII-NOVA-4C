package org.example.view.interfacePortugues;

import java.util.Scanner;

public class Menu {
    private static final String PURPLEANSI = "\u001B[35m";
    private static Scanner sc = new Scanner(System.in);
    public Menu(){
        int op = 0;
        do {
            System.out.println(PURPLEANSI+"---------------------------------------------");
            System.out.println("Bem-vindo!");
            System.out.println("1 - Fazer login ");
            System.out.println("2 - Se cadastrar");
            op = sc.nextInt();

        } while (op <=0 || op >=3);

        if(op == 1){
            Login.LoginMenu();
        } else if (op == 2) {
            Cadastro.MenuDeCadastro();
        }
    }
}
