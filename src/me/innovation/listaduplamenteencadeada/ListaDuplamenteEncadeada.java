package me.innovation.listaduplamenteencadeada;

/**
 * Classe que representa uma lista duplamente encadeada.
 * 
 * @param <T> Tipo generic de dado que a lista irá armazenar.
 */
public class ListaDuplamenteEncadeada<T> {

    /**
     * Referência para o primeiro nó da lista.
     */
    private NoDuplo<T> refPrimeiroNo;

    /**
     * Referência para o último nó da lista.
     */
    private NoDuplo<T> refUltimoNo;

    /**
     * Tamanho atual da lista.
     */
    private int tamanhoLista;

    /**
     * Construtor da classe ListaDuplamenteEncadeada.
     * Inicializa as referências para o primeiro e último nó como nulas e o tamanho
     * da lista como zero.
     */
    public ListaDuplamenteEncadeada() {
        this.refPrimeiroNo = null;
        this.refUltimoNo = null;
        this.tamanhoLista = 0;
    }

    /**
     * Retorna o elemento da lista na posição especificada pelo índice.
     * 
     * @param index índice do elemento a ser retornado.
     * @return elemento da lista na posição especificada pelo índice.
     * @throws IndexOutOfBoundsException se o índice estiver fora dos limites da
     *                                   lista.
     */
    public T get(int index) {
        NoDuplo<T> noAuxiliar = getNo(index);

        if (noAuxiliar != null) {
            return noAuxiliar.getConteudo();
        } else {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
    }

    /**
     * Adiciona um elemento ao final da lista.
     * 
     * @param conteudo elemento a ser adicionado à lista.
     */
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

    /**
     * Adiciona um elemento à lista na posição especificada pelo índice.
     * 
     * @param index    índice onde o elemento será adicionado.
     * @param conteudo elemento a ser adicionado à lista.
     * @throws IndexOutOfBoundsException se o índice estiver fora dos limites da
     *                                   lista.
     */
    public void add(int index, T conteudo) {
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
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

    /**
     * Remove o elemento da lista na posição especificada pelo índice.
     * 
     * @param index índice do elemento a ser removido.
     */
    public void remove(int index) {
        if (index == 0) {
            refPrimeiroNo = refPrimeiroNo.getRefNoPosterior();
            if (refPrimeiroNo != null) {
                refPrimeiroNo.setRefNoAnterior(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = getNo(index);
            if (noAuxiliar != null) {
                noAuxiliar.getRefNoAnterior().setRefNoPosterior(noAuxiliar.getRefNoPosterior());
                if (noAuxiliar != refUltimoNo) {
                    noAuxiliar.getRefNoPosterior().setRefNoAnterior(noAuxiliar.getRefNoAnterior());
                } else {
                    refUltimoNo = noAuxiliar;
                }
                this.tamanhoLista--;
            }
        }
    }

    /**
     * Retorna o nó da lista na posição especificada pelo índice.
     * 
     * @param index índice do nó a ser retornado.
     * @return nó da lista na posição especificada pelo índice.
     */
    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = refPrimeiroNo;

        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getRefNoPosterior();
        }
        return noAuxiliar;
    }

    /**
     * Retorna o tamanho atual da lista.
     * 
     * @return tamanho atual da lista.
     */
    public int size() {
        return this.tamanhoLista;
    }

    /**
     * Retorna uma representação em string da lista.
     * 
     * @return representação em string da lista.
     */
    @Override
    public String toString() {
        StringBuilder strRetorno = new StringBuilder();
        NoDuplo<T> noAuxiliar = refPrimeiroNo;
        for (int i = 0; i < size(); i++) {
            strRetorno.append("[No{conteudo=").append(noAuxiliar.getConteudo()).append("}]--->");
            noAuxiliar = noAuxiliar.getRefNoPosterior();
        }
        strRetorno.append("null");
        return strRetorno.toString();
    }
}
