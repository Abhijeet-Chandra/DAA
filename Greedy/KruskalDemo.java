import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int weight;
    Edge(int u, int v, int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class KruskalDemo {
    static int [] parent;
    static int [] rank;

    static int find(int x){
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int u, int v){
        int pU = find(u);
        int pV = find(v);

        if(rank[pU] < rank[pV]){
            parent[pU] = pV;
        }
        else if(rank[pU] > rank[pV]){
            parent[pV] = pU;
        }
        else{
            parent[pV] = pU;
            rank[pU]++;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        Collections.sort(edges);

        parent = new int[V];
        rank = new int[V];

        int cost = 0;

        for(int i = 0; i<V; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(Edge e: edges){
            if(find(e.u) != find(e.v)){
                union(e.u,e.v);
                cost+=e.weight;
            }
        }
        System.out.println(cost);
    }
}
