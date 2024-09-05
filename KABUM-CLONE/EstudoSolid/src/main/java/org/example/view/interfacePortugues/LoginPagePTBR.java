package org.example.view.interfacePortugues;

import org.example.control.UserManager;
import org.example.model.user.User;
import org.example.model.service.Criptografia;
import org.example.control.UserSearch;
import org.example.model.user.service.VerificaCPF;
import org.example.model.user.service.VerificaEmail;

import java.util.List;
import java.util.Scanner;

import static org.example.model.user.Status.StatusDatabase.HABILITADO;
import static org.example.model.user.Tipo.Grupo.ADMINISTRADOR;
import static org.example.model.user.Tipo.Grupo.ESTOQUISTA;

public class LoginPagePTBR {
    private final String ORANGEANSI = "\u001B[34m";
    private final String PURPLEANSI = "\u001B[35m";
    private final String GREENANSI = "\u001B[32m";
    private final String GOBACKTOORIGINAL = "\u001B[0m";
    private static Scanner sc = new Scanner(System.in);

    public void menuDeEscolhas() {
        boolean continuar = true;

        do {
            System.out.println("-------- Bem Vindo ao Kabum-Clone -------------");
            System.out.println(ORANGEANSI + "1 - Já é cadastrado?");
            System.out.println("2 - Venha ser um Kababy!" + GOBACKTOORIGINAL);
            System.out.println("--------------------------------------------");
            System.out.print(PURPLEANSI + "Informe sua resposta: " + GOBACKTOORIGINAL);
            String op = sc.nextLine();
            if (op.equals("1")) {
                continuar = false;
                login();  // Chama o método de login
            } else if (op.equals("2")) {
                continuar = false;
                intermediarioCadastro();
            } else {
                System.out.println("OPÇÃO ERRADA AMIGÃO");
            }
        } while (continuar);
    }

    private void login() {
        System.out.println("---------------------------------------------");
        System.out.print("Informe seu e-mail para login: ");
        String email = sc.nextLine();
        try {
            User user = UserSearch.searchUserByEmail(email);

            if (user != null) {
                System.out.println("Usuário encontrado. Exibindo dados:");
                exibirDadosUsuario(user);

                boolean continuar = true;
                do {
                    System.out.println("Deseja atualizar a senha? (S/N)");
                    String resposta = sc.nextLine();
                    if (resposta.equalsIgnoreCase("S")) {
                        atualizarSenha(user);
                        continuar = false;
                    } else if (resposta.equalsIgnoreCase("N")) {
                        System.out.println("Voltando para a tela anterior...");
                        continuar = false;
                    } else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                } while (continuar);
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar o login: " + e.getMessage());
        }
    }

    private void exibirDadosUsuario(User user) {
        System.out.println("ID: " + user.getId());
        System.out.println("Nome: " + user.getNome());
        System.out.println("CPF: " + user.getCpf());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Status: " + user.getStatus());
        System.out.println("Grupo: " + user.getGrupo());
    }

    // Solicita a senha duas vezes e salva no banco
    private void atualizarSenha(User user) {
        try {
            String senha = "";
            String senhaConfirmacao = "";
            boolean continuar = true;
            do {
                System.out.print("Informe sua nova senha: ");
                senha = sc.nextLine();
                System.out.print("Informe novamente sua nova senha: ");
                senhaConfirmacao = sc.nextLine();

                if (senha.equals(senhaConfirmacao)) {
                    String senhaCriptografada = Criptografia.instCod(senha);
                    user.setSenha(senhaCriptografada);
                    UserManager.updateUser(user);  // Atualiza o usuário no banco de dados
                    System.out.println("Senha atualizada com sucesso.");
                    continuar = false;
                } else {
                    System.out.println("As senhas não coincidem. Tente novamente.");
                }
            } while (continuar);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a senha: " + e.getMessage());
        }
    }

    private void intermediarioCadastro() {
        System.out.println("---------------------------------------------");
        System.out.println(GREENANSI + "Antes de começarmos, precisamos ter certeza que você já não existe no nosso banco de dados.");
        boolean continuar = true;
        String email = "";
        try {
            do {
                System.out.print("Informe por favor seu email para localizarmos: ");
                email = sc.nextLine();
                if (VerificaEmail.isEmailValid(email)) continuar = false;
            } while (continuar);

            if (!UserSearch.searchForEmail(email)) {
                cadastro(email);
            } else {
                System.out.println("Usuário já cadastrado com esse e-mail.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar e-mail: " + e.getMessage());
        }
    }

    private void cadastro(String email) {
        User user = null;
        boolean continuar = true;
        System.out.println("----------------------------------------------");
        try {
            System.out.print(PURPLEANSI + "Informe seu nome: ");
            String nome = sc.nextLine();
            String cpf = "";
            do {
                System.out.print("Informe seu CPF: ");
                cpf = sc.nextLine();
                if (VerificaCPF.verificaCPF(cpf)) continuar = false;
            } while (continuar);
            continuar = true;
            String[] senhas = new String[2];
            do {
                System.out.print("Informe sua senha: ");
                senhas[0] = sc.nextLine();
                System.out.print("Informe novamente sua senha: ");
                senhas[1] = sc.nextLine();
            } while (!senhas[0].equals(senhas[1]));

            String senha = Criptografia.instCod(senhas[0]);
            do {
                System.out.println("Informe o tipo do usuário: Administrador ou Estoquista");
                String tipo = sc.nextLine();

                if (tipo.equalsIgnoreCase("Administrador")) {
                    user = new User(nome, cpf, email, senha, ADMINISTRADOR, HABILITADO);
                    continuar = false;
                } else if (tipo.equalsIgnoreCase("Estoquista")) {
                    user = new User(nome, cpf, email, senha, ESTOQUISTA, HABILITADO);
                    continuar = false;
                } else {
                    System.out.println("Tipo de usuário inválido. Tente novamente.");
                }
            } while (continuar);
            System.out.println("SEJA BEM VINDO: " + user.getNome().toUpperCase());
            UserManager.addUser(user);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
}
