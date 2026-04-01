import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair{
    int vertex;
    int weight;

    Pair(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Dijkstra {

    public static void Dijkstra(List<List<Pair>> graph, int V, int start){
        boolean [] explored = new boolean[V]; //for marking a vertex visited once it is visited
        int [] dist = new int[V]; //storing minimum dist of vertex from start

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        int count = V; //keeps count of number of vertices still left to be explored, once its 0 it means all vertices are explored

        while(count --> 0){
            //find unexplored vertex which has min dist 
            int node = -1;
            int val = Integer.MAX_VALUE;
            for(int i = 0; i<V; i++){
                if(!explored[i] && dist[i]<val){
                    node = i;
                    val = dist[i];
                }
            }

            if (node == -1) break;

            //mark it as explored
            explored[node] = true;

            //explore all neighbouring vertices and update their dist if possible
            for(Pair neighbour : graph.get(node)){
                if(!explored[neighbour.vertex]){
                    if(dist[node]+neighbour.weight<dist[neighbour.vertex]){
                        dist[neighbour.vertex] = dist[node]+neighbour.weight;
                    }
                }
            }
        }

        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 4;
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1, 1));
        graph.get(0).add(new Pair(2, 4));
        graph.get(1).add(new Pair(2, 2));
        graph.get(1).add(new Pair(3, 6));
        graph.get(2).add(new Pair(3, 3));
    
        Dijkstra(graph, V, 0);
    }
}
