package ARREGLOS;

public interface PCola <T> {
    void enqueue(T x);

    T dequeue();

    T front();

    boolean isEmpty();

    int size();

    void delete(T n);
}