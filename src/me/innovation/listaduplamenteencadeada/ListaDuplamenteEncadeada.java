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
        NoDuplo<T> noAuxiliar = getNo(index);

        if (noAuxiliar != null) {
            return noAuxiliar.getConteudo();
        } else {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }

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

    public void add(int index, T conteudo) {

        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(conteudo);
        novoNo.setRefNoPosterior(noAuxiliar);

        if ((novoNo.getRefNoPosterior() != null) && (noAuxiliar != null)) {
            novoNo.setRefNoAnterior(noAuxiliar.getRefNoAnterior());
            novoNo.getRefNoPosterior().setRefNoAnterior(novoNo);
        } else {
            novoNo.setRefNoAnterior(refUltimoNo);
            refUltimoNo = novoNo;
        }

        if (index == 0) {
            refPrimeiroNo = novoNo;
        } else {
            novoNo.getRefNoAnterior().setRefNoPosterior(novoNo);
        }
        tamanhoLista++;

    }

    public void remove(int index) {
        if (index == 0) {
            refPrimeiroNo = refPrimeiroNo.getRefNoPosterior();
            if (refPrimeiroNo != null) {
                refPrimeiroNo.setRefNoAnterior(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = getNo(index);
            if (noAuxiliar != null) {
                NoDuplo<T> noAnterior = noAuxiliar.getRefNoAnterior();
                NoDuplo<T> noPosterior = noAuxiliar.getRefNoPosterior();
                if (noAnterior != null) {
                    noAnterior.setRefNoPosterior(noPosterior);
                }
                if (noPosterior != null && noAuxiliar != refUltimoNo) {
                    noPosterior.setRefNoAnterior(noAnterior);
                } else {
                    refUltimoNo = noAnterior;
                }
                this.tamanhoLista--;
            }
        }
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

    @Override
    public String toString() {
        StringBuilder strRetorno = new StringBuilder();
        NoDuplo<T> noAuxiliar = refPrimeiroNo;
        for (int i = 0; i < size(); i++) {
            strRetorno.append("[No{conteudo=").append(noAuxiliar.getConteudo()).append("}]<--->");
            noAuxiliar = noAuxiliar.getRefNoPosterior();
        }
        strRetorno.append("null");
        return strRetorno.toString();
    }
}
