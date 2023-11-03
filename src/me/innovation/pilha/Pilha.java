package me.innovation.pilha;

/**
 * Classe que representa uma Pilha.
 */
public class Pilha {
    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    /**
     * Insere um novo nó na Pilha.
     * 
     * @param novoNo O nó a ser inserido na Pilha.
     */
    public void push(No novoNo) {
        No refAuxiliar = this.refNoEntradaPilha;
        this.refNoEntradaPilha = novoNo;
        this.refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    /**
     * Remove o nó do topo da Pilha.
     * 
     * @return O nó removido do topo da Pilha.
     */
    public No pop() {
        if (!this.isEmpty()) {
            No noPoped = this.refNoEntradaPilha;
            this.refNoEntradaPilha = this.refNoEntradaPilha.getRefNo();
            return noPoped;
        } else {
            return null;
        }
    }

    /**
     * Retorna o nó do topo da Pilha.
     * 
     * @return O nó do topo da Pilha.
     */
    public No top() {
        return this.refNoEntradaPilha;
    }

    /**
     * Verifica se a Pilha está vazia.
     * 
     * @return true se a Pilha estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return this.refNoEntradaPilha == null;
    }

    /**
     * Retorna uma representação em String da Pilha.
     * 
     * @return A representação em String da Pilha.
     */
    @Override
    public String toString() {
        StringBuilder stringRetorno = new StringBuilder("--------------\n");
        stringRetorno.append("    Pilha\n");
        stringRetorno.append("--------------\n");

        No noAuxiliar = this.refNoEntradaPilha;

        while (true) {
            if (noAuxiliar != null) {
                stringRetorno.append("[No{dado=").append(noAuxiliar.getDado()).append("}]\n");
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }

        }
        stringRetorno.append("==============\n");
        return stringRetorno.toString();
    }
}
