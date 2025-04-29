import java.util.*;
import java.io.*;

public class Main {
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
    static int v,e,k;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i <= v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, w));
        }
        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(graph, k, dist);
        for(int i = 1; i <= v; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else{
                System.out.println(dist[i]);
            }
        }
    }
}


class Node implements Comparable<Node>{
    int to, weight;

    public Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}