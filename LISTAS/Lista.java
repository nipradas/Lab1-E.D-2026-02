package LISTAS;
public interface Lista <T> {

    void pushFront(T data);

    void pushBack(T data);

    T popFront();

    T popBack();

    boolean find(T data);

    void erase(T data);

    void addBefore(T nodedata, T Ndata);

    void addAfter(T nodedata, T Ndata);
    
    boolean empty();
}