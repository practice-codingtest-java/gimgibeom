import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return e.weight - this.weight;
        }
    }
    static void dijkstra(List<List<Edge>> graph,int start,int[] dist,boolean[] visited){
        List<Edge> l = graph.get(start);
        for(int i = 0; i < l.size();i++){
            Edge edge = l.get(i);
            if(visited[edge.to])continue;
            dist[edge.to] = dist[start] + edge.weight;
            visited[edge.to] = true;
            dijkstra(graph, edge.to, dist, visited);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            List<Edge> l = graph.get(start);
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Edge(to, weight));
                graph.get(to).add(new Edge(start, weight));
            }
        }
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        dist[0] = 0;
        dist[1] = 0;
        visited[1] = true;
        dijkstra(graph, 1, dist, visited);
        int midx = 0;
        int maxval = 0;
        for(int i = 1; i <= n; i++){
            // System.out.print(dist[i] + " ");
            if(maxval < dist[i]){
                maxval = dist[i];
                midx = i;
            }
        }
        // System.out.println();
        Arrays.fill(dist,0);
        Arrays.fill(visited,false);
        visited[midx] = true;
        dijkstra(graph, midx, dist,visited);
        for(int i = 1; i <= n; i++){
            // System.out.print(dist[i] + " ");
            maxval = Math.max(maxval, dist[i]);
        }
        System.out.println(maxval);
    }
}
