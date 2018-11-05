package no.uib.ii.inf102.f18.mandatory2;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<E> implements Iterable<E> {
    private Node<E> first;
    private int n;

    public Bag(){
        first = null;
        n = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return this.n;
    }
    public void add(E elem) {
        Node<E> oldFirst = first;
        first = new Node<>(elem);
        first.setNextNode(oldFirst);
        n++;
    }
    public Node<E> getFirst(){
        if(!isEmpty()) return this.first;
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = getFirst();
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.getData();
                current = current.getNextNode();
                return data;
            }
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer action) {
        Iterator iter = this.iterator();
        while(iter.hasNext()){
            action.accept(iter.next());
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
