import java.util.*;
import java.io.*;

public class Main {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int prim(int v, List<List<Edge>> graph){
        boolean visited[] = new boolean[v+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(1, 0));
        int totalCost = 0;
        int maxCost = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(visited[cur.to]) continue;

            visited[cur.to] = true;
            totalCost += cur.weight;
            if(cur.weight > maxCost) maxCost = cur.weight;
            for(int i = 0; i < graph.get(cur.to).size(); i++){
                Edge next = graph.get(cur.to).get(i);
                if(!visited[next.to]){
                    pq.add(next);
                }
            }

            // for(Edge next : graph.get(cur.to)){
            //     if(!visited[next.to]){
            //         pq.add(next);
            //     }
            // }
        }
        for(int i = 1; i <= v; i++){
            if(!visited[i]) return 0;
        }
        return totalCost - maxCost;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, v));
            graph.get(b).add(new Edge(a, v));
        }
        System.out.println(prim(n, graph));
    }
}
