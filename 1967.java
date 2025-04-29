import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int to;
        int weight;
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
        pq.add(new Node(start,0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight)continue;

            for(Node next : graph.get(now.to)){
                if(next.to == start) continue;
                // System.out.print(now.to + " " + next.to + " ");
                int cost = dist[now.to] + next.weight;
                if(cost < dist[next.to]){
                    dist[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
                // System.out.println(cost+" " +dist[next.to]);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Node>> graph  = new ArrayList<>();
        int parents[] = new int[n+1];
        parents[1] = 0;
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            parents[b] = a;
        }
        int maxVal = 0;
        int[] dist = new int[n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        for(int i = 1; i <= 1; i++){
            dijkstra(graph, i, dist);
        }
        for(int i = 1; i <=n-1; i++){
            for(int j = i+1; j<= n; j++){
                
            }
        }
    }
}
