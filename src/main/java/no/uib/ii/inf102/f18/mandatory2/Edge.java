package no.uib.ii.inf102.f18.mandatory2;

public class Edge {
    private int v;
    private int w;
    private int weight;
    public Edge(int v, int w, int weight){
        if(v<0) throw new IllegalArgumentException("vertex index must be nonnegative");
        if(w<0) throw new IllegalArgumentException("vertex index must be nonnegative");
        if(weight<0) throw new IllegalArgumentException("weight must be a number");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int getWeight(){
        return this.weight;
    }
    public int either(){
        return this.v;
    }
    public int other(int vertex){
        if (vertex == this.v) return this.w;
        if (vertex == this.w) return this.v;
        throw new IllegalArgumentException("vertex " + vertex + "  is not in this edge. This edge is from " + this.v + " to " + this.w);
    }
    @Override
    public String toString(){
        return String.format("This edge is from vertex %d to vertex %d with weight %d",this.v,this.w,this.weight);
    }
}