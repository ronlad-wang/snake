package snake.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class queue implements Queue{
    //the first node is used as a sentinel node connecting both ends of the queue

    public class Node<T> {
        public Node prev;
        public Node next;
        public T item;

        public Node(T temp) {
            item = temp;
        }
    }

    public int size;
    public Node firstNode;
    public Node lastNode;

    public queue() {
        size = 0;
        Node temp = new Node(new int[2]);
        temp.next = temp;
        firstNode = temp;
        lastNode = temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        Node tempNode = firstNode.next;
        for(int i = 0; i < size; i++) {
            temp[i] = tempNode.item;
            tempNode = tempNode.next;
        }
        return temp;
    }


    @Override
    public boolean add(Object o) {
        Node tempNode = new Node(o);
        lastNode.next = tempNode;
        lastNode = lastNode.next;
        size += 1;
        return true;
    }

    @Override
    public Object remove() {
        if(size == 0) {
            return null;
        }
        Node temp = firstNode.next;
        firstNode.next.next.prev = firstNode.next;
        firstNode.next = firstNode.next.next;
        size -= 1;
        return temp.item;
    }

    @Override
    public Object peek() {
        return firstNode.next.item;
    }

    public Object peekLast() {
        return lastNode.item;
    }












    //Unused functions were not implemented
    @Override
    public Object element() {
        return null;
    }
    @Override
    public Object poll() {
        return null;
    }
    @Override
    public boolean offer(Object o) {
        return false;
    }
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
    @Override
    public boolean addAll(Collection c) {
        return false;
    }
    @Override
    public void clear() {

    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean contains(Object o) {
        return false;
    }
    @Override
    public Iterator iterator() {
        return null;
    }
    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
