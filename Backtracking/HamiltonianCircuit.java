package Backtracking;

import java.util.ArrayList;
import java.util.List;

class Pair{
    int vertex;
    int weight;

    Pair(int v, int w) {
        vertex = v;
        weight = w;
    }
}

public class HamiltonianCircuit {
    static int V = 5; //no of vertices
    static boolean [] visited;
    static int noOfCircuits;
    public static void HamiltonianCircuits(List<List<Pair>> graph, int current, int start, int count){
        visited[current] = true;
        count++;
        if(count == V){
            for(Pair neighbour : graph.get(current)){
                if(neighbour.vertex == start){
                    noOfCircuits++;
                    break;
                }
            }
        }
        else{
            for(Pair neighbour : graph.get(current)){
            if(!visited[neighbour.vertex]){
                HamiltonianCircuits(graph, neighbour.vertex, start, count);
                }
            }
        }
        visited[current] = false;
    }
    public static void main(String[] args) {
        visited = new boolean[V];
        List<List<Pair>> graph = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges (undirected graph)
        graph.get(0).add(new Pair(1, 1));
        graph.get(0).add(new Pair(3, 1));

        graph.get(1).add(new Pair(0, 1));
        graph.get(1).add(new Pair(2, 1));
        graph.get(1).add(new Pair(3, 1));
        graph.get(1).add(new Pair(4, 1));

        graph.get(2).add(new Pair(1, 1));
        graph.get(2).add(new Pair(4, 1));

        graph.get(3).add(new Pair(0, 1));
        graph.get(3).add(new Pair(1, 1));
        graph.get(3).add(new Pair(4, 1));

        graph.get(4).add(new Pair(1, 1));
        graph.get(4).add(new Pair(2, 1));
        graph.get(4).add(new Pair(3, 1));

        HamiltonianCircuits(graph, 0, 0, 0);

        System.out.println("Number of Hamiltonian Circuits: " + (noOfCircuits/2));
    }
}
