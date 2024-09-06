package org.example.view.interfacePortugues;

import org.example.control.UserManager;
import org.example.control.UserSearch;
import org.example.model.dao.DatabaseSelect;
import org.example.model.service.Criptografia;
import org.example.model.service.ManipulaCPF;
import org.example.model.user.Tipo;
import org.example.model.user.User;

import java.sql.SQLException;
import java.util.List;
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
                telaBackoffice();
            }else if(UserSearch.procureOGrupo(email).equalsIgnoreCase("Estoquista")){
                //Menu do estoquista
            }
        }else System.out.println("SEM PERMISSÃO PRA ISSO");
    }

    public static void telaBackoffice() {
        int op = 0;

        do {
            System.out.println(GREENANSI+"--------------------------------------");
            System.out.println("Tela principal Backoffice");
            System.out.println("1 - Listar Produto");
            System.out.println("2 - Listar Usuário");
            op = sc.nextInt();
        } while (op <= 0 || op >= 3);

        switch (op) {
            case 1: break;
            case 2:
                listarUsuario();
                break;
        }
    }


    private static void trocarSenhaById(Long id) {
        boolean cont = true;
        String[] senhas = new String[2];
        User user = DatabaseSelect.returnUserPorID(id);
        do{
            System.out.println("--------------------------------");
            System.out.println("---Opção de edição do usuário---");
            System.out.println("Id: " + user.getId());
            System.out.println("Nome: " + user.getNome());
            System.out.println("Cpf: " + user.getCpf());
            System.out.println("E-mail: " + user.getEmail());
            System.out.println("Status: " + user.getStatus());
            System.out.println("Grupo: " + user.getGrupo());
            System.out.println("--------------------------------");
            System.out.print("Nova senha: ");
            sc.next();
            senhas[0] = sc.nextLine();
            System.out.println("Repetir senha: ");
            sc.next();
            senhas[1] = sc.nextLine();
            System.out.println("Deseja salvar? (Y/N)");
            char opc = sc.next().toUpperCase().charAt(0);
            if (opc == 'Y') {
                if(senhas[1].equals(senhas[0])){
                    UserManager.atualizarSenhaById(id, Criptografia.criptografe(senhas[1]));
                    System.out.println("SENHA DE USUARIO ATUALIZADA");
                    cont = false;
                }
            }
        }while (cont);
        listarUsuario();
    }
    public static void listarUsuariosLista() {
        List<User> usuarios = DatabaseSelect.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("ID | Nome | Email | Status | Grupo | CPF");
            for (User user : usuarios) {
                System.out.println(user.getId() + "  | " + user.getNome() + " | " + user.getEmail() +
                        " | " + user.getStatus() + " | " + user.getGrupo() + " | " + user.getCpf() + " | ");
            }
            System.out.println("-----------------------------------------");
        }
    }




    public static void listarUsuario()  {
        listarUsuariosLista();
        System.out.println("Entre com o id para editar/ativar/inativar, 0 para voltar e i para incluir => ");
        String op = sc.next();

        try {
            if (op.equals("0")) {
                telaBackoffice();
            } else if (op.equalsIgnoreCase("i")) {
                Cadastro.cadastro();
            } else {
                User user = UserSearch.procuraPeloID(Long.parseLong(op));
                System.out.println("--------------------------------");
                System.out.println("---Opção de edição do usuário---");
                System.out.println("Id: " + user.getId());
                System.out.println("Nome: " + user.getNome());
                System.out.println("Cpf: " + user.getCpf());
                System.out.println("E-mail: " + user.getEmail());
                System.out.println("Status: " + user.getStatus());
                System.out.println("Grupo: " + user.getGrupo());
                System.out.println("--------------------------------");
                System.out.println("Opções");
                System.out.println("1) Alterar Usuário");
                System.out.println("2) Alterar Senha");
                System.out.println("3) Ativar/Desativar");
                System.out.println("4) Voltar Listar Usuários");
                byte opc = sc.nextByte();
                switch (opc) {
                    case 1:
                        alterarUsuario(user, userPrincipal);
                        break;
                    case 2:
                        trocarSenhaById(user.getId());
                        break;
                    case 3:
                        Cadastro.cadastro();
                        break;
                    case 4:
                        listarUsuario();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alterarUsuario(User user, User userPrincipal) throws SQLException {
        Scanner sc = new Scanner(System.in);
        if (user.getId().equals(userPrincipal.getId())) {
            System.out.println("--------Alterar Usuário---------");
            System.out.println("Id: " + user.getId());
            System.out.println("Nome: " + user.getNome());
            System.out.println("Cpf: " + user.getCpf());
            System.out.println("E-mail: " + user.getEmail());
            System.out.println("Status: " + user.getStatus());
            System.out.println("Grupo: " + user.getGrupo());
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("Nome = ");
            String nome = sc.nextLine();
            System.out.println("CPF = ");
            String cpf = sc.nextLine();
            System.out.println("Deseja salvar? (Y/N)");
            char salvar = sc.next().toUpperCase().charAt(0);
            if (salvar == 'Y') {
                user.setNome(nome);
                if (ManipulaCPF.verificaCPF(ManipulaCPF.retiraPontoDoCPF(cpf))) {
                    user.setCpf(cpf);
                }
                UserManager.alterarUsuario(user);
                listarUsuario();
            } else {
                listarUsuario();
            }
        } else {
            System.out.println("--------Alterar Usuário---------");
            System.out.println("Id: " + user.getId());
            System.out.println("Nome: " + user.getNome());
            System.out.println("Cpf: " + user.getCpf());
            System.out.println("E-mail: " + user.getEmail());
            System.out.println("Status: " + user.getStatus());
            System.out.println("Grupo: " + user.getGrupo());
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("Nome = ");
            String nome = sc.nextLine();
            System.out.println("CPF = ");
            String cpf = sc.nextLine();
            System.out.println("Grupo = ");
            Tipo.Grupo grupo = Tipo.Grupo.valueOf(sc.nextLine().toUpperCase());
            System.out.println("Deseja salvar? (Y/N)");
            char salvar = sc.next().toUpperCase().charAt(0);
            if (salvar == 'Y') {
                user.setNome(nome);
                if (ManipulaCPF.verificaCPF(ManipulaCPF.retiraPontoDoCPF(cpf))) {
                    user.setCpf(cpf);
                }
                user.setGrupo(grupo);
                UserManager.alterarUsuario(user);
                listarUsuario();
            } else {
                listarUsuario();
            }
        }
    }
}

