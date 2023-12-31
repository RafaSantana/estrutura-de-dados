package me.innovation.listaencadeada;

public class Listaencadeada<T> {

    No<T> referenciaEntrada;

    public Listaencadeada() {
        this.referenciaEntrada = null;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i < this.size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index) {
        No<T> no = getNo(index);
        if (no == null) {
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index
                    + " desta lista. Esta lista vai até o índice " + (this.size() - 1) + ".");
        }
        return no.getConteudo();
    }

    private No<T> getNo(int index) {

        validaIndice(index);

        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noRetorno;
    }

    public T remove(int index) {
        No<T> noPivor = this.getNo(index);

        if (index == 0) {
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1);
        if ((noPivor != null) && (noAnterior != null)) {
            noAnterior.setProximoNo(noPivor.getProximoNo());
            return noPivor.getConteudo();
        } else {
            throw new NullPointerException("O nó a ser removido é nulo.");
        }
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

    private void validaIndice(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index
                    + " desta lista. Esta lista vai até o índice " + (this.size() - 1) + ".");
        }
    }

    public boolean isEmpty() {
        return referenciaEntrada == null;
    }

    @Override
    public String toString() {
        StringBuilder strRetorno = new StringBuilder();
        No<T> noAuxiliar = referenciaEntrada;

        for (int i = 0; i < this.size(); i++) {
            strRetorno.append("[No{conteudo=").append(noAuxiliar.getConteudo()).append("}]--->");
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno.append("null");
        return strRetorno.toString();
    }

}
