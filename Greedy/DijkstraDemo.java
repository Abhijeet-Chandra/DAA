import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
class Pair{
    int weight;
    int vertex;
    
    Pair(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}


public class DijkstraDemo {
    public static void main(String[] args) {
        int V = 4;
        int [] explored = new int[V];
        int [] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Pair(1, 1));
        graph.get(0).add(new Pair(2, 4));
        graph.get(1).add(new Pair(2, 2));
        graph.get(1).add(new Pair(3, 6));
        graph.get(2).add(new Pair(3, 3));

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair currVertex = pq.poll();

            if(explored[currVertex.vertex] == 1)continue;
            explored[currVertex.vertex] = 1;
            
            for(Pair neighbour : graph.get(currVertex.vertex)){
                if(explored[neighbour.vertex] == 0){
                    if(dist[currVertex.vertex]+neighbour.weight<dist[neighbour.vertex]){
                        dist[neighbour.vertex] = dist[currVertex.vertex]+neighbour.weight;
                    }
                    pq.add(new Pair(neighbour.vertex, dist[neighbour.vertex]));
                }
            }
        }


        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }
}
