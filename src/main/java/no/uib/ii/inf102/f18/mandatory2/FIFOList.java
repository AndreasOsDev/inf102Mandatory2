package no.uib.ii.inf102.f18.mandatory2;

/**
 * Linked List structure of FIFO type, First in First out.
 *
 * @param <E> Generic Data type
 */
public class FIFOList<E> {
    private Node<E> first;
    private Node<E> last;
    private int n;

    public FIFOList() {
        this.first = null;
        this.last = null;
        this.n = 0;
    }

    public FIFOList(E elem) {
        this.first = new Node<>(elem);
        this.last = getFirst();
        this.n = 1;
    }

    public E peek() {
        return this.first.getData();
    }

    public E poll() {
        Node<E> first = this.first;
        if (first.hasNextNode()) this.first = first.getNextNode();
        else this.first = null;
        n--;
        return first.getData();
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    private Node<E> getFirst() {
        return this.first;
    }

    public void add(E elem) {
        Node<E> newNode = new Node<>(elem);
        if(isEmpty()){
            this.first = newNode;
            this.last = newNode;
            n++;
            return;
        }
        this.last.setNextNode(newNode);
        this.last = newNode;
        n++;
    }

}
