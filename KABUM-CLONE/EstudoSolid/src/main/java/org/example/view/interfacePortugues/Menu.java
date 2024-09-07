package org.example.view.interfacePortugues;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    public Menu(){
        int op = 0;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Bem-vindo!");
            System.out.println("1 - Fazer login ");
            System.out.println("2 - Se cadastrar");
            op = sc.nextInt();

        } while (op <=0 || op >=3);

        switch (op) {
            case 1: Login.LoginMenu();
                    break;
            case 2: Cadastro.MenuDeCadastro();
                    break;
        }

    }
}
