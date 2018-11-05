package no.uib.ii.inf102.f18.mandatory2;


import java.util.Stack;

public class Graph {
    private Bag<Integer>[] adj;
    private final int V;
    private int e;

    @SuppressWarnings("unchecked")
    public Graph(int V){
        if(V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[getV()];
        for (int i = 0; i < getV(); i++) {
            adj[i] = new Bag<>();
        }
    }



    public int getV(){
        return this.V;
    }
    public int getE(){
        return this.e;
    }

    private void validateVertex(int v){
        if(v<0 || v >= this.getV()) throw new IllegalArgumentException("Vertex is not valid");
    }
    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        e++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public void addSingleEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        e++;
        adj[v].add(w);
    }
    public void linkGraphsEdge(int v, int w, Graph other){

    }
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }
}
