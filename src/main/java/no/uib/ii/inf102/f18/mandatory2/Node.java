package no.uib.ii.inf102.f18.mandatory2;

public class Node<E> {
    private E data;
    private int sortKey;
    private Node<E> nextNode;
    private Node<E> prevNode;

    public Node(E data) {
        this.data = data;
        this.sortKey = 0;
        this.nextNode = null;
        this.prevNode = null;
    }

    public Node(E data, int sortKey) {
        this.data = data;
        this.sortKey = sortKey;
        this.nextNode = null;
        this.prevNode = null;
    }

    public int getSortKey() {
        return sortKey;
    }

    public void setSortKey(int sortKey) {
        this.sortKey = sortKey;
    }
    public boolean hasNextNode(){
        return this.nextNode != null;
    }
    public boolean hasPrevNode(){
        return this.prevNode != null;
    }

    public Node<E> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<E> prevNode) {
        this.prevNode = prevNode;
    }

    public Node<E> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node<E> node) {
        this.nextNode = node;
    }

    public E getData() {
        if(data != null){
            return data;
        }
        throw new IllegalArgumentException("This object has no data!" + this.getSortKey() + " " + this.getPrevNode());
    }

    public void setData(E data) {
        this.data = data;
    }
}
