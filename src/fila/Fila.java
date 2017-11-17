package fila;

import java.util.Scanner;

public class Fila {

    static Scanner aux = new Scanner(System.in);
    static Pessoa inicio = null;
    static Pessoa fim = null;
    static int qtd = 0;

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

    public static void criandoFila() {
        inicio = criandoP();
        fim = inicio;
        inicio.setProximo(fim);
        fim.setProximo(null);
        qtd = qtd + 1;
    }

    public static Pessoa criandoP() {
        Pessoa p = new Pessoa();
        p.setNome(pedeString("Informe o nome do usuário(> 1 e < 50 caracteres).", 1, 50));
        return p;
    }

    public static void incluir() {
        if (inicio == null) {
            System.out.println("Fila vazia, criando uma nova fila...");
            criandoFila();
        }

    }

    public static void remover() {

    }

    public static void listar() {

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

    public static String pedeString(String msg, int max, int min) {
        String retorno = "";
        boolean erro;
        do {
            erro = false;
            try {
                System.out.println(msg);
                retorno = aux.next();
                if (retorno.length() < min || retorno.length() > max) {
                    System.out.println("Informe um nome de " + min + " a " + max + " caracteres");
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (retorno.length() < min || retorno.length() > max || erro);
        return retorno;
    }
}
