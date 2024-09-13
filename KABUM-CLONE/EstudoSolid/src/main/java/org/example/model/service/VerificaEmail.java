package org.example.model.service;

public class VerificaEmail {

    public static boolean isEmailValid(String email){
        email = email.toLowerCase();
        return (email.contains("@outlook.com") || email.contains("@yahoo.com") || email.contains("@gmail.com")
        || email.contains("@hotmail.com") || email.contains("@hostinger.com") || email.contains("@hostgator.com")
                || email.contains("@bing.com") || email.contains("@uol.com") || email.contains("@icloud.com"));
    }
}
