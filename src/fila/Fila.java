package fila;

import java.util.Scanner;

class Pessoa {

    String nome;
    Pessoa proximo;

    public Pessoa(String nome) {
        this.nome = nome;
    }
}

public class Fila {

    static Scanner aux = new Scanner(System.in);
    static Pessoa inicio = null;
    static Pessoa fim = null;

    public static void main(String[] args) {
        inicia();
    }

    public static void menu() {
        System.out.println("1 - incluir uma Pessoa na fila\n"
                + "2 - remover uma Pessoa da fila\n"
                + "3 - listar as pessoas que estão na fila.\n"
                + "0 - Sair");
    }

    public static void inicia() {
        int r = 0;
        do {
            menu();
            r = pedeInt("Informe a opção desejada: ", 0, 3);

            switch (r) {
                case 1:
                    incluir();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    listar();
                    break;
                case 0:
                    System.out.println("Programa cancelado.");
                    break;
            }
        } while (r > 3 || r < 0);
    }

    public static void incluir() {
        Pessoa novo = new Pessoa(pedeString());

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            // primeiro -> x -> x -> x -> x -> ultimo
            fim.proximo = novo;
            fim = novo;
        }
        System.out.println("Pessoa incluida na fila: " + novo.nome);
        inicia();
    }

    public static void remover() {
        if (inicio == null) {
            System.out.println("A fila está vazia, criando fila...");
            incluir();
        } else {
            System.out.println("Pessoa removida: " + inicio.nome);
            inicio = inicio.proximo;
            inicia();
            if (inicio == null) {
                fim = null;
            }
            
        }
    }

    public static void listar() {

        if (inicio == null) {
            System.out.println("A fila está vazia, criando lista...");
            incluir();
        } else {
            System.out.println("As pessoas na fila são: ");
            Pessoa atual = inicio;
            while (atual != null) {
                System.out.println(" - " + atual.nome);
                atual = atual.proximo;
                inicia();
            }
        }

    }

    public static int pedeInt(String msg, int min, int max) {
        int retorno = min - 1;
        boolean erro;
        do {
            erro = false;
            try {
                System.out.println(msg);
                retorno = aux.nextInt();
                if (retorno < min || retorno > max) {
                    System.out.println("Informe um valor de " + min + " a " + max);
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (retorno < min || retorno > max || erro);
        return retorno;
    }

    static String pedeString() {
        System.out.println("Informe o nome do usuário(> 1 e < 50 caracteres).");
        return new Scanner(System.in).nextLine().trim();
    }
}
