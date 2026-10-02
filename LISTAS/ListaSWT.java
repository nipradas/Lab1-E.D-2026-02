package LISTAS;

public class ListaSWT <T> implements Lista <T>{

    private Node <T> head;
    private Node <T> tail;

    public ListaSWT() {
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
            head = newNode;
        }
    }

    @Override
    public void pushBack(T data) {
        Node <T> newNode = new Node<>(data);
        if (empty()) 
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode; 
        }
    }

    @Override
    public T popFront() {
            if (empty()) 
                throw new RuntimeException("Lista vacia");
        T data = head.data;
            if (head == tail)
                head = tail = null;
            else 
                head = head.next;
        return data;
    }

    @Override
    public T popBack() {
            if (empty()) 
                throw new RuntimeException("Lista vacia");
        T data = tail.data;
            if (head == tail) { 
                head = tail = null;
                return data;
        }
        Node <T> act = head;
            while (act.next != tail) 
                act = act.next;
        act.next = null;
        tail = act;
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
        Node <T> act = head;
        while (act.next != null && !act.next.data.equals(data)) 
            act = act.next;

        if (act.next != null) {
            if (act.next == tail) 
                tail = act;
            act.next = act.next.next;
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

        while (act.next != null && !act.next.data.equals(nodeData)) 
            act = act.next;
        if (act.next != null) {
            Node <T> newNode = new Node<>(Ndata);
            newNode.next = act.next;
            act.next = newNode;
        }
    }

    @Override
    public void addAfter(T nodeData, T Ndata) {
        Node <T> act = head;
        
        while (act != null && !act.data.equals(nodeData)) 
            act = act.next;
        if (act != null) {
            Node <T> newNode = new Node<>(Ndata);
            newNode.next = act.next;
            act.next = newNode;
                if (act == tail)
                    tail = newNode;
        }
    }
}