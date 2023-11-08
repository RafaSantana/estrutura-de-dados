package me.innovation.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeNoDuplo;
    private NoDuplo<T> ultimoNoDuplo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeNoDuplo = null;
        this.ultimoNoDuplo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = primeNoDuplo;

        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public int size() {
        return this.tamanhoLista;
    }
}
