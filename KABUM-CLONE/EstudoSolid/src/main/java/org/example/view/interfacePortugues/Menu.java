package org.example.view.interfacePortugues;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    public Menu(){
        System.out.println("---------------------------------------------");
        System.out.println("Olá seja bem vindo!");
        System.out.println("Você é um:");
        System.out.println("1 - Um usuario com cadastro? ");
        System.out.println("2 - Um usuario sem cadastro?");
        int op = sc.nextInt();


        if(op == 1){
            Login.LoginMenu();
        }
        else if(op == 2){
            Cadastro.MenuDeCadastro();
        }
    }
}
