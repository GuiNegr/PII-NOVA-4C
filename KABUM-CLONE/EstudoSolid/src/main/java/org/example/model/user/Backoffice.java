package org.example.service;

import org.example.model.dao.DatabaseSelect;
import org.example.model.user.User;

import java.util.List;

public class BackofficeService {

    // Método para listar todos os usuários
    public void listarUsuarios() {
        List<User> usuarios = DatabaseSelect.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            System.out.println("ID\tNome\tEmail\tStatus\tGrupo\tCPF");
            for (User user : usuarios) {
                System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getEmail() +
                        "\t" + user.getStatus() + "\t" + user.getGroup() + "\t" + user.getCpf());
            }
        }
    }

    // Método para obter um usuário pelo ID
    public User getUserById(int id) {
        List<User> usuarios = DatabaseSelect.listarUsuarios();
        for (User user : usuarios) {
            if (user.getId().equals(String.valueOf(id))) {
                return user;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    // Método para mostrar as opções do usuário selecionado
    public void mostrarOpcoesUsuario(User user) {
        System.out.println("---- Opções do Usuário ----");
        System.out.println("1. Ver detalhes do usuário");
        System.out.println("2. Atualizar usuário");
        System.out.println("3. Excluir usuário");
        System.out.println("0. Voltar");

        // Implementa a lógica para cada opção
        // Este código pode ser adaptado ou expandido conforme necessário
        System.out.println("Detalhes do Usuário:");
        System.out.println("ID: " + user.getId());
        System.out.println("Nome: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Status: " + user.getStatus());
        System.out.println("Grupo: " + user.getGroup());
        System.out.println("CPF: " + user.getCpf());
    }

    // Método para incluir um novo usuário
    public void incluirUsuario(String nome, String email, String status, String grupo, String cpf) {
        User novoUsuario = new User();
        novoUsuario.setName(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setStatus(status);
        novoUsuario.setGroup(grupo);
        novoUsuario.setCpf(cpf);

        // Aqui deverias adicionar a lógica para salvar o novo usuário na base de dados.
        System.out.println("Usuário incluído com sucesso!");
    }
}
