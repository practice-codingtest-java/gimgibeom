import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int to, weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    public static void dijkstra(List<List<Node>> graph, int start, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight) continue;

            for(Node next : graph.get(now.to)){
                int cost = dist[now.to] + next.weight;
                if(cost < dist[next.to]){
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(graph, start, dist);
        System.out.println(dist[end]);
    }
}
