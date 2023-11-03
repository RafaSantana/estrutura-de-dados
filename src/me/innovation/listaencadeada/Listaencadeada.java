package me.innovation.listaencadeada;

public class Listaencadeada<T> {

    No<T> referenciaEntrada;

    public Listaencadeada() {
        this.referenciaEntrada = null;
    }

    public int size() {
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;

        while (referenciaAux != null) {
            tamanhoLista++;
            if (referenciaAux.getProximoNo() != null) {
                referenciaAux = referenciaAux.getProximoNo();
            } else {
                break;
            }
        }

        return tamanhoLista;
    }

    public boolean isEmpty() {
        return referenciaEntrada == null;
    }

}
