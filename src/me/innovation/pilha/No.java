package me.innovation.pilha;

/**
 * Classe que representa um nó de uma pilha encadeada.
 */
public class No {
    private int dado;
    private No refNo;

    /**
     * Construtor padrão da classe No.
     */
    public No() {
    }

    /**
     * Construtor da classe No que recebe um dado como parâmetro.
     * 
     * @param dado O dado a ser armazenado no nó.
     */
    public No(int dado) {
        this.dado = dado;
        this.refNo = null;
    }

    /**
     * Retorna o dado armazenado no nó.
     * 
     * @return O dado armazenado no nó.
     */
    public int getDado() {
        return this.dado;
    }

    /**
     * Define o dado a ser armazenado no nó.
     * 
     * @param dado O dado a ser armazenado no nó.
     */
    public void setDado(int dado) {
        this.dado = dado;
    }

    /**
     * Retorna a referência para o próximo nó da pilha.
     * 
     * @return A referência para o próximo nó da pilha.
     */
    public No getRefNo() {
        return this.refNo;
    }

    /**
     * Define a referência para o próximo nó da pilha.
     * 
     * @param proximo A referência para o próximo nó da pilha.
     */
    public void setRefNo(No proximo) {
        this.refNo = proximo;
    }

    /**
     * Retorna uma representação em string do nó.
     * 
     * @return Uma representação em string do nó.
     */
    @Override
    public String toString() {
        return "No[{" + "dado=" + this.dado + "}]";
    }
}
