package br.com.nova.projeto_nova.service.impl;

import org.springframework.stereotype.Service;

@Service
public class Validadores {

    public boolean validaCpf(String cpf){
         cpf = cpf.replaceAll("[^\\d]", "");

         if(cpf.length() != 11){
             return false;
         }
         String cpfSemDitos = cpf.substring(0,9);
         String cpfDigitos = cpf.substring(9,11);

         int soma = 0;
         int ajudante = 10;
        for (int i = 0; i < 9 ; i++) {
            soma += ajudante * Integer.parseInt(String.valueOf(cpfSemDitos.charAt(i)));
            ajudante--;
        }
        int digito = 11 - (soma % 11);

        if(digito >= 10){
            digito = 0;
        }
        cpfSemDitos += String.valueOf(digito);
        digito = 0;

         soma = 0;
         ajudante = 11;
        for (int i = 0; i < 10 ; i++) {
            soma += ajudante * Integer.parseInt(String.valueOf(cpfSemDitos.charAt(i)));
            ajudante--;
        }

        digito = 11 - (soma % 11);
        if(digito >= 10){
            digito = 0;
        }
        cpfSemDitos += String.valueOf(digito);

        return cpf.equals(cpfSemDitos);
    }

    public boolean validaEmail(String email){
        email = email.toLowerCase();
        if (email.length() < 8 ){
            return false;
        }
        return (email.contains("@outlook.com") || email.contains("@yahoo.com") || email.contains("@gmail.com")
                || email.contains("@hotmail.com") || email.contains("@hostinger.com") || email.contains("@hostgator.com")
                || email.contains("@bing.com") || email.contains("@uol.com") || email.contains("@icloud.com")
                || email.contains("@adm.com"));
    }
}

