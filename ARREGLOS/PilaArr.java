package ARREGLOS;

public class PilaArr <T> implements PPila <T>{
    private T[] arr;
    private int count; 

    @SuppressWarnings("unchecked")
    public  PilaArr() {
        this.arr = (T[]) new Object[10]; 
        this.count = 0;
    }

    private void doubleCap() {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < count; i++)
            newArray[i] = arr[i];
        arr = newArray;
    }

    @Override
    public void push(T x) {
        if (count == arr.length)
            doubleCap();
        arr[count] = x;
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) 
            throw new RuntimeException("Pila vacia");
        count--;
        T data = arr[count];
        arr[count] = null;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) 
            throw new RuntimeException("Pila vacia");
        return arr[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void delete(T n) {
        if (isEmpty()) 
            return;
        
        for (int i = count - 1; i >= 0; i--) {
            if (arr[i].equals(n)) {
                for (int j = i; j < count - 1; j++)
                    arr[j] = arr[j + 1];
                arr[count - 1] = null;
                count--;
                return;
            }
        }
    }
}