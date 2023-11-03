package me.innovation.pilha;

public class Main {
    public static void main(String[] args) {
        Pilha mPilha = new Pilha();
        mPilha.push(new No(1));
        mPilha.push(new No(2));
        mPilha.push(new No(3));
        mPilha.push(new No(4));
        mPilha.push(new No(5));
        mPilha.push(new No(6));

        System.out.println(mPilha);

        System.out.println(mPilha.pop());
        System.out.println(mPilha);

        mPilha.push(new No(99));

        System.out.println(mPilha);

    }
}
