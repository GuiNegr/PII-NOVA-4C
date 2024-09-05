package org.example.control;

import org.example.model.dao.DatabaseAdd;
import org.example.model.dao.DatabaseSelect;
import org.example.model.user.Status;
import org.example.model.user.Tipo;
import org.example.model.user.User;

import java.sql.SQLException;
import java.util.Scanner;

public class UserManager {
    public static void addUser(User user){
        UserAdd.adicionaNoBanco(user);

    }
    public void listarDadosUsuarioPorId(int userId) {

        User user = DatabaseSelect.getUserById(userId);

        if (user != null) {
            System.out.println("ID: " + user.getId());
            System.out.println("Nome: " + user.getNome());
            System.out.println("CPF: " + user.getCpf());
            System.out.println("E-mail: " + user.getEmail());

            String status = user.getStatus();
            System.out.println("Status: " + status);

            String grupo = user.getTipo();
            System.out.println("Grupo: " + grupo);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    public void exibirOpcoes(int userId) {
        Scanner scanner = new Scanner(System.in);
        User user = DatabaseSelect.getUserById(userId);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Dados do Usuário:");
        System.out.println("ID: " + user.getId());
        System.out.println("Nome: " + user.getNome());
        System.out.println("CPF: " + user.getCpf());
        System.out.println("E-mail: " + user.getEmail());
        System.out.println("Status: " + user.getStatus());
        System.out.println("Grupo: " + user.getTipo());

        // Exibir opções
        System.out.println("Escolha uma opção:");
        System.out.println("1) Alterar usuário");
        System.out.println("2) Alterar senha");
        System.out.println("3) Ativar/Desativar");
        System.out.println("4) Voltar a listar usuário");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

        switch (opcao) {
            case 1:
                alterarUsuario(userId);
                break;
            case 2:
                alterarSenha(userId);
                break;
            case 3:
                ativarDesativarUsuario(userId);
                break;
            case 4:
                listarUsuarios(); // Este método deve ser implementado se você tiver uma forma de listar todos os usuários
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    // Método para alterar os dados do usuário
    private void alterarUsuario(int userId) {
        Scanner scanner = new Scanner(System.in);

        User user = DatabaseSelect.getUserById(userId);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome (ou pressione Enter para manter o atual):");
        String novoNome = scanner.nextLine();
        if (!novoNome.isEmpty()) {
            user.setNome(novoNome);
        }

        System.out.println("Digite o novo CPF (ou pressione Enter para manter o atual):");
        String novoCpf = scanner.nextLine();
        if (!novoCpf.isEmpty()) {
            user.setCpf(novoCpf);
        }

        System.out.println("Digite o novo e-mail (ou pressione Enter para manter o atual):");
        String novoEmail = scanner.nextLine();
        if (!novoEmail.isEmpty()) {
            user.setEmail(novoEmail);
        }

        System.out.println("Digite o novo grupo (ADMIN/USUARIO) (ou pressione Enter para manter o atual):");
        String novoGrupo = scanner.nextLine();
        if (!novoGrupo.isEmpty()) {
            try {
                user.setGrupo(Tipo.Grupo.valueOf(novoGrupo.toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Grupo inválido. Mantendo o grupo atual.");
            }
        }

        try {
            // Atualiza os dados no banco de dados
            DatabaseAdd.updateUser(user);
            System.out.println("Dados do usuário atualizados com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar dados do usuário: " + e.getMessage());
        }
    }

    // Método para alterar a senha do usuário
    private void alterarSenha(int userId) {
        Scanner scanner = new Scanner(System.in);

        User user = DatabaseSelect.getUserById(userId);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Digite a nova senha:");
        String novaSenha = scanner.nextLine();
        user.setSenha(novaSenha);

        try {
            // Atualiza a senha no banco de dados
            DatabaseAdd.updateUser(user);
            System.out.println("Senha alterada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao alterar a senha: " + e.getMessage());
        }
    }

    // Método para ativar ou desativar o usuário
    private void ativarDesativarUsuario(int userId) {
        Scanner scanner = new Scanner(System.in);

        User user = DatabaseSelect.getUserById(userId);

        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Digite 1 para ativar ou 0 para desativar:");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

        Status.StatusDatabase novoStatus = (opcao == 1) ? Status.StatusDatabase.ATIVO : Status.StatusDatabase.INATIVO;
        user.setStatus(novoStatus);

        try {
            // Atualiza o status no banco de dados
            DatabaseAdd.updateUser(user);
            System.out.println("Status do usuário atualizado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o status do usuário: " + e.getMessage());
        }
    }

    private void listarUsuarios() {
        System.out.println("Listar usuários - funcionalidade a ser implementada.");
    }
}
}