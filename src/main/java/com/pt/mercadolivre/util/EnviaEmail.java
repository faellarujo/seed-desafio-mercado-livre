package com.pt.mercadolivre.util;

public class EnviaEmail {

    public static void enviaEmail(String email, String assunto, String mensagem) {
        System.out.println("Email enviado para: " + email);
        System.out.println("Assunto: " + assunto);
        System.out.println("Mensagem: " + mensagem);
    }
}
