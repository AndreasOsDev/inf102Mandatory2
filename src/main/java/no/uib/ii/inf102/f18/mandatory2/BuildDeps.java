package no.uib.ii.inf102.f18.mandatory2;

import java.util.*;

public class BuildDeps {
    private static Graph graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        Map<String, Integer> mapping = new HashMap<>();
        int rules = io.getInt();
        graph = new Graph(rules);
        String[] inverse = new String[rules];
        String target = null;
        int last = -1;
        int firstFree = 0;
        while(io.hasMoreTokens()){
            String token = io.getWord();
            if(token.endsWith(":")){
                token = token.substring(0,token.length()-1);
                if(!mapping.containsKey(token)){
                    mapping.put(token,firstFree);
                    inverse[firstFree] = token;
                    firstFree++;
                }
                last = mapping.get(token);
            }else{
                if(!io.hasMoreTokens()){
                    target = token;
                }
                else{
                    if(!mapping.containsKey(token)){
                        mapping.put(token,firstFree);
                        inverse[firstFree] = token;
                        firstFree++;
                    }
                    graph.addSingleEdge(mapping.get(token),last);
                }
            }
        }
        reachable(mapping.get(target));
        List<Integer> dependencies = refactor();
        for(Integer depend : dependencies){
            if(visited[depend]){
                System.out.println(inverse[depend]);
            }
        }
    }
    private static void reachable(int target){
        LinkedList<Integer> queue = new LinkedList<>();
        visited = new boolean[graph.getV()];
        visited[target] = true;
        queue.add(target);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            for (int other : graph.adj(node)){
                if(!visited[other]){
                    visited[other] = true;
                    queue.add(other);
                }
            }
        }
    }
    private static List<Integer> refactor(){
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> dependencies = new ArrayList<>();
        for (int i = 0; i < graph.getV(); i++) {
            if(graph.inDegree(i)==0) queue.add(i);
        }
        int node;
        while(!queue.isEmpty()){
            node = queue.poll();
            dependencies.add(node);
            for(int other : graph.adj(node)){
                graph.lowerInDegree(other);
                if(graph.inDegree(other)==0){
                    queue.add(other);
                }
            }
        }
        return dependencies;
    }
}
