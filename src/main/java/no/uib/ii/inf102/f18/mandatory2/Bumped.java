package no.uib.ii.inf102.f18.mandatory2;

public class Bumped {
    private static int V;
    private static int start;
    private static int target;
    private static WeightedGraph graph;
    private static long[] distance;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        V = io.getInt();
        int E = io.getInt();
        int F = io.getInt();
        start = io.getInt();
        target = io.getInt();
        graph = new WeightedGraph(V * 2);
        for (int i = 0; i < E; i++) {
            int v = io.getInt();
            int w = io.getInt();
            int weight = io.getInt();
            graph.addEdge(new Edge(v, w, weight));
            graph.addEdge(new Edge(v + V, w + V, weight));
        }
        for (int i = 0; i < F; i++) {
            int v = io.getInt();
            int w = io.getInt();
            graph.addDirectedEdge(new Edge(v, w + V, 0));
        }
        Dijkstra();
    }

    private static void Dijkstra() {
        if(start == target){
            System.out.println(0);
            return;
        }
        IndexMinPQ<Long> queue = new IndexMinPQ<>(V*2);
        distance = new long[V*2];
        for (int i = 0; i < V*2; i++) {
            distance[i] = Integer.MAX_VALUE;
            queue.add(i,distance[i]);
        }
        distance[start] = 0;
        queue.changeKey(start, 0L);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Edge neighbor : graph.adj(node)) {
                int other = neighbor.other(node);
                long alt = distance[node] + neighbor.getWeight();
                if (distance[other] > alt) {
                    distance[other] = alt;
                    queue.changeKey(other,alt);
                }
            }
        }
        getPath();
    }

    private static void getPath() {
        if (distance[target] < distance[target + V]) System.out.print(distance[target]);
        else System.out.print(distance[target + V]);
    }
}
