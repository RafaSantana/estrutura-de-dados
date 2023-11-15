package me.innovation.arvorebinaria.model;

public abstract class ObjArvore<T> implements Comparable<T> {

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract String toString();
}
