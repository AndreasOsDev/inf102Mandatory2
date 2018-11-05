package no.uib.ii.inf102.f18.mandatory2;

public class WeightedGraph {

    private int V;
    private int E;
    private Bag<Edge>[] adj;


    @SuppressWarnings("unchecked")
    public WeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[getV()];
        for (int i = 0; i < getV(); i++) {
            adj[i] = new Bag<>();
        }
    }

    public int getV(){
        return this.V;
    }
    public int getE(){
        return this.E;
    }
    public void addDirectedEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        E++;
    }
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    private void validateVertex(int v){
        if(v<0 || v >= this.getV()) throw new IllegalArgumentException("Vertex " + v + " is not valid");
    }
    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
}
