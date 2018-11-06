package no.uib.ii.inf102.f18.mandatory2;


public class Graph {
    private Bag<Integer>[] adj;
    private int[] in;
    private final int V;
    private int e;

    @SuppressWarnings("unchecked")
    public Graph(int V){
        if(V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.in = new int[V];
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
        this.in[v] = this.in[v]+1;
        this.in[w] = this.in[w]+1;
        e++;
        adj[v].add(w);
        adj[w].add(v);
    }
    public void addSingleEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        e++;
        this.in[w] = this.in[w]+1;
        adj[v].add(w);
    }
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }
    public int inDegree(int v){
        validateVertex(v);
        return in[v];
    }
    public void resetInDegree(int v){
        validateVertex(v);
        in[v] = 0;
    }
    public void lowerInDegree(int v){
        validateVertex(v);
        in[v] = in[v]-1;
    }
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }
}
