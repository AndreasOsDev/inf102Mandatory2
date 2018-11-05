package no.uib.ii.inf102.f18.mandatory2;

import java.util.LinkedList;

public class WheresMyInternet {
    private static final String FULL_GRAPH = "Connected";
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int V = io.getInt();
        int e = io.getInt();
        Graph graph = new Graph(V);
        for (int i = 0; i < e; i++) {
            int start = io.getInt()-1;
            int end = io.getInt()-1;
            graph.addEdge(start,end);
        }
        boolean[] visited = breadthFirst(graph,V);
        boolean fullGraph = true;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                System.out.println(i+1);
                fullGraph = false;
            }
        }
        if(fullGraph){
            System.out.println(FULL_GRAPH);
        }
    }
    @SuppressWarnings("Duplicates")
    public static boolean[] breadthFirst(Graph graph, int V){
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        int current = 0;
        visited[current] = true;
        queue.add(current);
        while(queue.size()!=0){
            current = queue.poll();
            for (Integer n : graph.adj(current)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return visited;
    }
}
