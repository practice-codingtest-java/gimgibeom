import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int to,weight;
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
            // System.out.println(now.to);
            if(dist[now.to]< now.weight) continue;
            for(Node next : graph.get(now.to)){
                int cost = dist[now.to] + next.weight;
                if(cost < dist[next.to]){
                    dist[next.to] = cost;
                    pq.add(new Node(next.to,cost));
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<List<Node> > graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }
        int[][] dist = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for(int i = 1; i <= n; i++){
            dijkstra(graph, i, dist[i]);
        }
        int[] answer = new int[n+1];
        int maxVal = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i][x] == Integer.MAX_VALUE || dist[x][i] == Integer.MAX_VALUE) continue;
            answer[i] = dist[i][x] + dist[x][i];
            if(answer[i] > maxVal) maxVal = answer[i];
        }
        System.out.println(maxVal);
    }
}
