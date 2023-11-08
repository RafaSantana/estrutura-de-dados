package me.innovation.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> refPrimeiroNo;
    private NoDuplo<T> refUltimoNo;

    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.refPrimeiroNo = null;
        this.refUltimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T conteudo) {
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setRefNoAnterior(refUltimoNo);
        novoNo.setRefNoPosterior(null);
        if (refPrimeiroNo == null) {
            refPrimeiroNo = novoNo;
        }
        if (refUltimoNo != null) {
            refUltimoNo.setRefNoPosterior(novoNo);
        }
        refUltimoNo = novoNo;
        this.tamanhoLista++;
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = refPrimeiroNo;

        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getRefNoPosterior();
        }
        return noAuxiliar;
    }

    public int size() {
        return this.tamanhoLista;
    }
}
