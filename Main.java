/*
 * Faça um programa que receba uma String e gere como resposta uma
 * solução para a pergunta do usuário. Ex: quantos dias existem em
 * 1 ano e 3 meses? ou 23:14:30:59...
 */

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner s = new Scanner(System.in);
        Decoder dec = new Decoder();
        String query;

        System.out.println("Type 'exit' or 'quit' to terminate the program.");

        while (!exit) {
            System.out.print("\n> ");
            query = s.nextLine();
            if (query.equalsIgnoreCase("exit") || query.equalsIgnoreCase("quit")) {
                exit = true;
            }
            else dec.answer(query, true);
        }
        s.close();
    }
}
