package fila;

public class Pessoa {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getProximo() {
        return proximo;
    }

    public void setProximo(Pessoa proximo) {
        this.proximo = proximo;
    }

    public Pessoa getAnterior() {
        return anterior;
    }

    public void setAnterior(Pessoa anterior) {
        this.anterior = anterior;
    }
    private Pessoa proximo, anterior;
    
}
