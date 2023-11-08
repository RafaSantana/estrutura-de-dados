package me.innovation.listaduplamenteencadeada;

public class NoDuplo<T> {

    private T conteudo;
    private NoDuplo<T> refNoAnterior;
    private NoDuplo<T> refNoPosterior;

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getRefNoPosterior() {
        return refNoPosterior;
    }

    public void setRefNoPosterior(NoDuplo<T> noProximo) {
        this.refNoPosterior = noProximo;
    }

    public NoDuplo<T> getRefNoAnterior() {
        return refNoAnterior;
    }

    public void setRefNoAnterior(NoDuplo<T> noPrevio) {
        this.refNoAnterior = noPrevio;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
