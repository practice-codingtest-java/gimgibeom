import java.util.*;
import java.io.*;



public class Main {
    static class Node implements Comparable<Node>{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }


    public static void dijkstra( List<List<Node>>graph, int start, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
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
        List<List<Node>>graph = new ArrayList<>();
        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        for(int i = 1; i <= n; i++){
            int dist[] = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dijkstra(graph, i, dist);
            for(int j = 1; j <= n; j++){
                if(dist[j] == Integer.MAX_VALUE) System.out.print(0+ " ");
                else System.out.print(dist[j]+ " ");
            }
            System.out.println();
        }
    }
}
