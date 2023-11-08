package me.innovation.listaduplamenteencadeada;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> minhaListaEncadeada = new ListaDuplamenteEncadeada<>();

        minhaListaEncadeada.add(0, "node1");
        minhaListaEncadeada.add(1, "node2");
        minhaListaEncadeada.add(3, "nodeX");
        minhaListaEncadeada.add(2, "nodeZ");
        System.out.println(minhaListaEncadeada);
    }
}
