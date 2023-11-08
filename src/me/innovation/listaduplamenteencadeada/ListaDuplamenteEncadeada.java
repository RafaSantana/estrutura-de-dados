package me.innovation.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeNoDuplo;
    private NoDuplo<T> ultimNoDuplo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeNoDuplo = null;
        this.ultimNoDuplo = null;
        this.tamanhoLista = 0;
    }

    public int size() {
        return this.tamanhoLista;
    }
}
