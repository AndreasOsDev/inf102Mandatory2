package no.uib.ii.inf102.f18.mandatory2;

import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements IIndexPQ<Key> {
    private int N;
    private int maxN;
    private int[] pq;
    private int[] qp;
    private Key[] keys;
    @SuppressWarnings("unchecked")
    public IndexMinPQ(int maxN){
        this.maxN = maxN;
        this.keys = (Key[]) new Comparable[maxN + 1];
        this.pq = new int[maxN + 1];
        this.qp = new int[maxN + 1];
        for (int i = 0; i < maxN; i++) qp[i]=-1;
    }


    private void upHeapify(int index){
        while (index > 1 && greater(index/2, index)) {
            swap(index, index/2);
            index = index/2;
        }
    }

    private void downHeapify(int index){
        while (2*index <= N){
            int temp = 2*index;
            if(temp < N && greater(temp,temp+1)) temp++;
            if(!greater(index,temp)) break;
            swap(index,temp);
            index = temp;
        }
    }


    @Override
    public void add(int index, Key key) {
        if(contains(index)) throw new IllegalArgumentException("Index is already in priority queue!");
        N++;
        qp[index] = N;
        pq[N] = index;
        keys[index] = key;
        upHeapify(N);
    }

    @Override
    public void changeKey(int index, Key key) {
        if(index < 0 || index >= maxN) throw new IllegalArgumentException();
        if(!contains(index)) throw new NoSuchElementException("Index doesn't exist in priority queue");
        keys[index] = key;
        upHeapify(qp[index]);
        downHeapify(qp[index]);
    }

    @Override
    public boolean contains(int index) {
        return qp[index] != -1;
    }

    @Override
    public void delete(int index) {
        int i = qp[index];
        swap(i,N--);
        downHeapify(i);
        upHeapify(i);
        keys[index] = null;
        qp[index] = -1;
    }

    @Override
    public Key getKey(int index) {
        if(!contains(index)) throw new IllegalArgumentException("Index doesn't exist in priority queue");
        return keys[index];
    }

    @Override
    public Key peekKey() {
        if(N > 0) return keys[1];
        return null;
    }

    @Override
    public int peek() {
        if(N > 0) return pq[1];
        return -1;
    }

    @Override
    public int poll() {
        if(N < 1) return -1;
        int index = pq[1];
        swap(1,N--);
        downHeapify(1);
        keys[index] = null;
        qp[index] = -1;
        return index;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    private void swap(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
    private boolean greater(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
}
