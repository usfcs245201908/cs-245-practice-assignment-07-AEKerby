import java.lang.*;
public class LinkedList<T> implements List<T> {

    public class Node<T>{
        private T data;
        private Node next;

        public Node(T item){
            data = item;
            next = null;
        }
    }

    private int size;
    private Node head;

    public LinkedList() {
        head = null;
        size = 0;

    }

    public void add(T item) {
        if (head == null){
            head = new Node(item);
            size++;
        } else {
            Node prev = head;
            while (prev.next != null){
                prev = prev.next;
            }
            Node current = new Node(item);
            prev.next = current;
            size++;
        }
    }

    public void add(int pos, T item) {
        if (pos > size || pos < 0){
            System.out.println("Out of Bounds!");
        }
        if (pos == 0){
			Node current = new Node(item);
			current.next = head;
			head = current;
			size++;
		} else {
			Node current = new Node(item);
			Node prev = head;
			for (int i = 0; i < pos - 1; i++){
                prev = prev.next;
            }
			current.next = prev.next;
			prev.next = current;
			size++;
		}
    }

    public T get(int pos) {
        if (pos > 0 || pos <= size){
            Node prev = head;
            for (int i = 0; i < pos; i++){
                prev = prev.next;
            }
            return (T)prev.data;
        }
        return null;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size){
            return null;
        }
        if (pos == 0){
            Node rem = head;
            head = head.next;
            size--;
            return (T)rem.data;
        } else {
            Node prev = head;
            for (int i = 0; i < pos - 1; i++){
                prev = prev.next;
            }
            Node rem = prev.next;
            prev.next = rem.next;
            size--;
            return (T)rem.data;
        }
    }

    public int size() {
        return size;
    }
}
