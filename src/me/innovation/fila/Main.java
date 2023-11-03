package me.innovation.fila;

public class Main {
    public static void main(String[] args) {
        Fila<String> minhaFila = new Fila<>();

        minhaFila.enqueue("primeiroNo");
        minhaFila.enqueue("segundoNo");
        minhaFila.enqueue("TerceiroNo");
        minhaFila.enqueue("QuartoNo");

        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());

        System.out.println(minhaFila);

        minhaFila.enqueue("UltimoNo");

        System.out.println(minhaFila);

        System.out.println(minhaFila.first());
        System.out.println(minhaFila);

    }
}
