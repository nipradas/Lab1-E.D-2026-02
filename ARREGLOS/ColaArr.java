package ARREGLOS;

public class ColaArr <T> implements PCola <T> {

    private T[] array;
    private int front;  
    private int rear; 
    private int count;  

    @SuppressWarnings("unchecked")
    public ColaArr() {
        this.array = (T[]) new Object[10];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    private void doubleCap() {
        int newCap = array.length * 2;

        @SuppressWarnings("unchecked")
        T[] newArr = (T[]) new Object[newCap];
        
        int actual = front;
        for (int i = 0; i < count; i++) {
            newArr[i] = array[actual];
            actual = (actual + 1) % array.length;
        }
        array = newArr;
        front = 0;
        rear = count;
    }

    @Override
    public void enqueue(T x) {
        if (count == array.length)
            doubleCap();
        array[rear] = x;
        rear = (rear + 1) % array.length;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) 
            throw new RuntimeException("La cola está vacía");
        T data = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        count--;
        return data;
    }

    @Override
    public T front() {
        if (isEmpty()) 
            throw new RuntimeException("La cola está vacía");
        return array[front];
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
        
        int actual = front;
        for (int i = 0; i < count; i++) {
            if (array[actual].equals(n)) {
                int indiceAMover = actual;
                for (int j = i; j < count - 1; j++) {
                    int siguiente = (indiceAMover + 1) % array.length;
                    array[indiceAMover] = array[siguiente];
                    indiceAMover = siguiente;
                }
                
                rear = (rear - 1 + array.length) % array.length;
                array[rear] = null;
                count--;
                return; 
            }
            actual = (actual + 1) % array.length;
        }
    }
}