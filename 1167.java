import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static long backtracking(List<List<Edge>> graph, boolean[] visited,long weight,int start){
        long cweight = weight;
        List<Edge> cur = graph.get(start);
        long maxval = 0;
        for(int i = 0; i < cur.size(); i++){
            if(visited[cur.get(i).to]) continue;
            visited[cur.get(i).to] = true;
            maxval = Math.max(maxval, backtracking(graph, visited, cur.get(i).weight, cur.get(i).to));
        }
        // System.out.println("cur: " + start + " return: " + (cweight+maxval));
        return cweight+maxval;
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
                int flag = 1;
                for(int j = 0; j < l.size();j++){
                    Edge tmp = l.get(j);
                    if(tmp.to == to){
                        tmp.weight = Math.max(tmp.weight, weight);
                        flag = 0;
                    }
                }
                if(flag == 0) continue;
                graph.get(start).add(new Edge(to, weight));
            }
        }
        long ans = 0;
        boolean[] checked = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            if(graph.get(i).size() != 1 || checked[i]) continue;
            boolean visited[] = new boolean[n+1];
            visited[i] = true;
            checked[i] = true;
            ans = Math.max(ans, backtracking(graph, visited, 0, i));
        }
        System.out.println(ans);
    }
}
