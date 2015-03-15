/*
 * Faça um programa que receba uma String e gere como resposta uma
 * solução para a pergunta do usuário. Ex: quantos dias existem em
 * 1 ano e 3 meses? ou 23:14:30:59...
 */

class Main {
    public static void main(String[] args) {
        String query = new String();
        Decoder dec = new Decoder();

        query = "quants meses há em 1 ano e 3 meses?";
        dec.answer(query);
    }
}
