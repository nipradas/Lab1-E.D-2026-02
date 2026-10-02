package LISTAS;

public class ListaDNoT <T> implements Lista <T>{
    private Node <T>head;

    public ListaDNoT() {
        this.head = null;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public void pushFront(T data) {
        Node <T>newNode = new Node<>(data);
        newNode.next = head;
            if (head != null) 
                head.prev = newNode; 
        head = newNode;
    }

    @Override
    public void pushBack(T data) {
        Node <T>newNode = new Node<>(data);
            if (empty()) {
                head = newNode;
                return;
            }
        Node <T>act = head;
            while (act.next != null)
                act = act.next;
        act.next = newNode;
        newNode.prev = act;
    }

    @Override
    public T popFront() {
        if (empty()) 
            throw new RuntimeException("Lista vacia");
        T data = head.data;
        head = head.next;
        if (head != null) 
            head.prev = null;
        return data;
    }

    @Override
    public T popBack() {
        if (empty()) 
            throw new RuntimeException("Lista vacia");

        if (head.next == null) {
            T data = head.data;
            head = null;
            return data;
        }
        Node <T>act = head;
            while (act.next != null) 
                act = act.next;
        T data = act.data;
        act.prev.next = null;
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
        if (empty()) return;
        if (head.data.equals(data)) {
            popFront();
            return;
        }
        Node <T>act = head;
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
        Node <T>act = head;

        while (act != null && !act.data.equals(nodeData))
            act = act.next;

        if (act != null) {
            Node <T>newNode = new Node<>(Ndata);

            newNode.next = act;
            newNode.prev = act.prev;
            act.prev.next = newNode;
            act.prev = newNode;
        }
    }

    @Override
    public void addAfter(T nodeData, T Ndata) {
        Node <T>act = head;
        while (act != null && !act.data.equals(nodeData)) 
            act = act.next;
        
        if (act != null) {
            Node <T>newNode = new Node<>(Ndata);

            newNode.prev = act;
            newNode.next = act.next;
            if (act.next != null) 
                act.next.prev = newNode;
            act.next = newNode;
        }
    }
}