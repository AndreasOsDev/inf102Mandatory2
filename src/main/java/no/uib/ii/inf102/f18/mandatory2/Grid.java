package no.uib.ii.inf102.f18.mandatory2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Grid {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int row = io.getInt();
        int col = io.getInt();
        int total = row*col;
        int[] grid = new int[total];
        for (int i = 0; i < row; i++) {
            String word = io.getWord();
            for (int j = 0; j < word.length(); j++) {
                grid[(i*col)+j] = Character.getNumericValue(word.charAt(j));
            }
        }
        Graph graph = addEdges(new Graph(total), grid, row, col);
        BFS(graph, row, col);
    }
    @SuppressWarnings("Duplicates")
    private static void BFS(Graph graph, int row, int col) {
        boolean[] visited = new boolean[row*col];
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> parentNodes = new HashMap<>();
        int current = 0;
        visited[current] = true;
        queue.add(current);
        boolean found = false;
        while(queue.size()!=0){
            current = queue.poll();
            if(current == row*col-1){
                found = true;
            }
            for (Integer n : graph.adj(current)) {
                if (!visited[n]) {
                    parentNodes.put(n,current);
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        if(!found) System.out.println("-1");
        else{
            int steps = 0;
            Integer node = row*col-1;
            while (node != null){
                steps++;
                node = parentNodes.get(node);
            }
            System.out.println(steps-1);
        }
    }
    private static Graph addEdges(Graph graph, int[] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            int move = grid[i];
            if(move != 0){
                if(i%col + move < col) graph.addSingleEdge(i,i+move);
                if(i%col - move >= 0) graph.addSingleEdge(i,i-move);
                if(i/col + move < row) graph.addSingleEdge(i,i+move*col);
                if(i/col - move >= 0) graph.addSingleEdge(i,i-move*col);
            }
        }
        return graph;
    }
}
