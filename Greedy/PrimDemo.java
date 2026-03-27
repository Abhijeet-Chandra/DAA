import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int vertex;
    int weight;

    Pair(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class PrimDemo {

    public static int prim(int V, List<List<Pair>> graph){
        int totalWeight = 0; //intialize it to 0, this will keep minimum weight

        boolean [] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.weight-b.weight
        );

        pq.add(new Pair(0, 0)); // start from vertex 0

        while(!pq.isEmpty()){
            Pair current = pq.poll(); //pop out vertex with min weight
            int currVertex = current.vertex; //vertex number
            int currWeight = current.weight; //vertex weight

            if(visited[currVertex]) continue; //if visited skip it

            visited[currVertex] = true; //mark it visited

            totalWeight+=currWeight; //add its weight to total weight

            for(Pair neighbour : graph.get(currVertex)){
                if(!visited[neighbour.vertex]){
                    pq.add(new Pair(neighbour.vertex, neighbour.weight));
                }
            }
        }
        return totalWeight;
    }
    public static void main(String[] args) {
        int V = 4;

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph (add both sides)
        graph.get(0).add(new Pair(1, 2));
        graph.get(1).add(new Pair(0, 2));

        graph.get(0).add(new Pair(2, 6));
        graph.get(2).add(new Pair(0, 6));

        graph.get(1).add(new Pair(2, 4));
        graph.get(2).add(new Pair(1, 4));

        graph.get(1).add(new Pair(3, 3));
        graph.get(3).add(new Pair(1, 3));

        graph.get(2).add(new Pair(3, 1));
        graph.get(3).add(new Pair(2, 1));

        System.out.println(prim(V, graph));
    }
}
