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
        int minCost = 0;
        int minidx = 0;
        int minidx2 = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(visited[cur.to]) continue;

            visited[cur.to] = true;
            totalCost += cur.weight;

            for(int i = 0; i < graph.get(cur.to).size(); i++){
                Edge next = graph.get(cur.to).get(i);
                if(!visited[next.to]){
                    pq.add(next);
                    if(minCost == 0 || minCost > next.weight){
                        minCost = next.weight;
                        minidx = cur.to;
                        minidx2 = next.to;
                    }
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
        // graph.get(minidx2).remove(minidx);
        // graph.get(minidx).remove(minidx2);
        List<Edge> l1 = graph.get(minidx);
        for(int i = 0; i < l1.size(); i++){
            if(l1.get(i).to == minidx2){
                graph.get(minidx).remove(i);
                break;
            }
        }
        List<Edge> l2 = graph.get(minidx2);
        for(int i = 0; i < l2.size(); i++){
            if(l2.get(i).to == minidx){
                graph.get(minidx2).remove(i);
                break;
            }
        }
        return totalCost;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, i+1));
            graph.get(b).add(new Edge(a, i+1));
        }

        for(int i = 0; i < k; i++){
            System.out.print(prim(n, graph)+ " ");
        }
    }
}
