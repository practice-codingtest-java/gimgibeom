import java.util.*;
import java.io.*;

public class Main {
    public static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int start, int[] dist){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(dist[now.to] < now.weight) continue;

            for(Edge next : graph.get(now.to)){
                int cost = dist[now.to] + next.weight;
                if(cost < dist[next.to]){
                    dist[next.to] = cost;
                    pq.add(new Edge(next.to, cost));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, l));
            graph.get(b).add(new Edge(a, l));
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int dist[] = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            int tmp = 0;
            dijkstra(graph, i, dist);
            for(int j = 1; j <= n; j++){
                if(dist[j] <= m) tmp += arr[j];
            }
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }
}
