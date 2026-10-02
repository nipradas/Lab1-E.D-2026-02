package LISTAS;

public class ListaDWT <T> implements Lista <T>{

    private Node <T> head;
    private Node <T> tail; 

    public ListaDWT() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public void pushFront(T data) {
        Node <T> newNode = new Node<>(data);
            if (empty())
                head = tail = newNode;
            else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
    }

    @Override
    public void pushBack(T data) {
        Node <T> newNode = new Node<>(data);
            if (empty()) 
                head = tail = newNode;
            else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode; 
        }
    }

    @Override
    public T popFront() {
        if (empty()) 
            throw new RuntimeException("Lista vacía");
        T data = head.data;
        if (head == tail) 
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    @Override
    public T popBack() {
        if (empty()) 
            throw new RuntimeException("Lista vacía");
        T data = tail.data;
        if (head == tail) 
            head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
        }
        return data;
    }

    @Override
    public boolean find(T data) {
        Node <T> act = head;
            while (act != null) {
                if (act.data.equals(data)) 
                    return true;
                act = act.next;
            }
        return false;
    }

    @Override
    public void erase(T data) {
        if (empty()) 
            return;
        if (head.data.equals(data)) {
            popFront();
            return;
        }
        if (tail.data.equals(data)) {
            popBack();
            return;
        }
        Node <T> act = head;
        while (act != null && !act.data.equals(data))
            act = act.next;
        if (act != null) {
            act.prev.next = act.next;
            if (act.next != null)
                act.next.prev = act.prev;
        }
    }

    @Override
    public void addBefore(T nodeData, T Ndata) {
        if (empty()) 
            return;
        if (head.data.equals(nodeData)) {
            pushFront(Ndata);
            return;
        }
        Node <T> act = head;
        
        while (act != null && !act.data.equals(nodeData))
            act = act.next;

        if (act != null) {
            Node <T> newNode = new Node<>(Ndata);
            newNode.next = act;
            newNode.prev = act.prev;
            act.prev.next = newNode;
            act.prev = newNode;
        }
    }

    @Override
    public void addAfter(T nodeData, T Ndata) {
        if (empty()) 
            return;
        if (tail.data.equals(nodeData)) {
            pushBack(Ndata);
            return;
        }
        Node <T> act = head;

        while (act != null && !act.data.equals(nodeData))
            act = act.next;

        if (act != null) {
            Node <T> newNode = new Node<>(Ndata);
            newNode.prev = act;
            newNode.next = act.next;
                if (act.next != null) 
                    act.next.prev = newNode;
            act.next = newNode;
        }
    }
}