package me.innovation.arvorebinaria;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
        if (atual == null) {
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        } else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }

    public void exibirInOrdem() {
        System.out.println("\n Exibindo InOrdem");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
    }

    public void exibirPosOrdem() {
        System.out.println("\n Exibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrdem() {
        System.out.println("\n Exibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual) {
        if (atual != null) {
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    public void remover(T conteudo) {
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)) {
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0) {
                    atual = atual.getNoEsq();
                } else {
                    atual = atual.getNoDir();
                }
            }

            if (atual == null) {
                System.out.println("Conteúdo não encontrado. Bloco Try");
                return;
            }

            if (pai == null) {
                removerRaiz();
            } else if (atual.getNoDir() == null) {
                removerNoComApenasUmFilho(pai, atual, atual.getNoEsq());
            } else if (atual.getNoEsq() == null) {
                removerNoComApenasUmFilho(pai, atual, atual.getNoDir());
            } else {
                removerNoComDoisFilhos(atual);
            }

        } catch (NullPointerException erro) {
            System.out.println("Conteúdo não encontrado! Bloco Catch");
        }
    }

    private void removerRaiz() {
        if (raiz.getNoDir() == null) {
            this.raiz = raiz.getNoEsq();
        } else if (raiz.getNoEsq() == null) {
            this.raiz = raiz.getNoDir();
        } else {
            BinNo<T> temporario = null;
            BinNo<T> filho = null;
            for (temporario = raiz, filho = raiz.getNoEsq(); filho.getNoDir() != null; temporario = filho, filho = filho
                    .getNoDir()) {
                if (filho != raiz.getNoEsq()) {
                    temporario.setNoDir(filho.getNoEsq());
                    filho.setNoEsq(raiz.getNoEsq());
                }
            }
            filho.setNoDir(raiz.getNoDir());
            raiz = filho;
        }
    }

    private void removerNoComApenasUmFilho(BinNo<T> pai, BinNo<T> atual, BinNo<T> filho) {
        if (pai.getNoEsq() == atual) {
            pai.setNoEsq(filho);
        } else {
            pai.setNoDir(filho);
        }
    }

    private void removerNoComDoisFilhos(BinNo<T> atual) {
        BinNo<T> temporario = null;
        BinNo<T> filho = null;
        for (temporario = atual, filho = atual.getNoEsq(); filho.getNoDir() != null; temporario = filho, filho = filho
                .getNoDir()) {
            if (filho != atual.getNoEsq()) {
                temporario.setNoDir(filho.getNoEsq());
                filho.setNoEsq(atual.getNoEsq());
            }
        }
        filho.setNoDir(atual.getNoDir());
        if (atual == raiz) {
            raiz = filho;
        } else if (atual.getConteudo().compareTo(temporario.getConteudo()) < 0) {
            temporario.setNoEsq(filho);
        } else {
            temporario.setNoDir(filho);
        }
    }
}