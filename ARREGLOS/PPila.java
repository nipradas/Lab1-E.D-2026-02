package ARREGLOS;

public interface PPila <T> {
    void push(T x);

    T pop();

    T peek();

    boolean isEmpty();

    int size();
    
    void delete(T n);
}