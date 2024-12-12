package com.javaBase64PWD;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class GenPwdBase64 {

    public static void main(String[] args) {
    	
    	try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("=== Gerador de Senhas em Base64 ===");
        
        System.out.print("Digite o tamanho da senha desejada: ");
        int tamanho = scanner.nextInt();

        scanner.close();
        if (tamanho <= 0) {
            System.out.println("O tamanho deve ser maior que zero!");
            return;
        }

        String senha = gerarSenhaAleatoria(tamanho);
        String senhaBase64 = codificarBase64(senha);

        System.out.println("Senha gerada: " + senha);
        System.out.println("Senha em Base64: " + senhaBase64);

    	} catch (Exception e) {
    		System.out.println("Error: " + e);
    	}
    }

    private static String gerarSenhaAleatoria(int tamanho) {
        final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++)
            senha.append(caracteres.charAt(random.nextInt(caracteres.length())));

        return senha.toString();
    }

    private static String codificarBase64(String senha) {
        return Base64.getEncoder().encodeToString(senha.getBytes());
    }
}