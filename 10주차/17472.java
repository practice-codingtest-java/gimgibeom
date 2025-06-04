import java.io.*;
import java.util.*;

public class Main {
    static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static int prim(int n, List<List<Edge>> graph){
        boolean visited[] = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e->e.weight));
        pq.add(new Edge(1, 0));
        int total = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            total += cur.weight;
            // System.out.println(cur.weight);
            for(Edge next : graph.get(cur.to)){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }
        for(int i = 1; i < n; i++){
            // System.out.println(i +" " + visited[i]);
            if(visited[i] == false) return -1;
        }
        if(total == 0) return -1;
        return total;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int visited[][] = new int[n][m];
        int cnt = 1;
        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> y = new ArrayDeque<>();
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && arr[i][j] == 1){
                    x.add(j);
                    y.add(i);
                    visited[i][j] = 1;
                    arr[i][j] = cnt;
                    while(!y.isEmpty()){
                        int py = y.poll();
                        int px = x.poll();
                        for(int k = 0; k < 4; k++){
                            int ny = py + dy[k];
                            int nx = px + dx[k];
                            if(ny>=0 && nx >= 0 && ny < n && nx < m && visited[ny][nx] == 0 && arr[ny][nx] == 1){
                                x.add(nx);
                                y.add(ny);
                                visited[ny][nx] = 1;
                                arr[ny][nx] = cnt;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        // System.out.println();
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int graph[][] = new int[cnt][cnt];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        // System.out.println(cnt);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 0) continue;
                int start = arr[i][j];
                int sx = j;
                int sy = i;
                cnt = 0;
                while(true){
                    sx--;
                    cnt++;
                    if(sx < 0 || arr[i][sx] == start) break;
                    if(arr[i][sx] != 0 && cnt < 3) break;
                    if(arr[i][sx] != 0 && cnt >= 3){
                        int to = arr[i][sx];
                        graph[start][to] = Math.min(graph[start][to], cnt-1);
                        break;
                    }
                }
                sx = j;
                cnt = 0;
                while(true){
                    sx++;
                    cnt++;
                    if(sx >= m || arr[i][sx] == start) break;
                    if(arr[i][sx] != 0 && cnt < 3) break;
                    if(arr[i][sx] != 0 && cnt >= 3){
                        int to = arr[i][sx];
                        graph[start][to] = Math.min(graph[start][to], cnt-1);
                        break;
                    }
                }
                sy = i;
                cnt = 0;
                while(true){
                    sy--;
                    cnt++;
                    if(sy < 0 || arr[sy][j] == start) break;
                    if(arr[sy][j] != 0 && cnt < 3) break;
                    if(arr[sy][j] != 0 && cnt >= 3){
                        int to = arr[sy][j];
                        graph[start][to] = Math.min(graph[start][to], cnt-1);
                        break;
                    }
                }
                sy = i;
                cnt = 0;
                while(true){
                    sy++;
                    cnt++;
                    if(sy >= n || arr[sy][j] == start) break;
                    if(arr[sy][j] != 0 && cnt < 3) break;
                    if(arr[sy][j] != 0 && cnt >= 3){
                        int to = arr[sy][j];
                        graph[start][to] = Math.min(graph[start][to], cnt-1);
                        break;
                    }
                }
            }
        }
        // System.out.println();
        List<List<Edge>> graphl = new ArrayList<>();
        for(int i = 0; i <= graph.length; i++){
            graphl.add(new ArrayList<>());
        }
        for(int i = 1; i < graph.length; i++){
            for(int j = 1; j < graph[i].length; j++){
                if(graph[i][j] == Integer.MAX_VALUE) graph[i][j] = 0;
                if(graph[i][j] != 0){
                    graphl.get(i).add(new Edge(j, graph[i][j]));
                }
                // System.out.print(graph[i][j] + " ");
            }
            // System.out.println();
        }
        System.out.println(prim(graph.length, graphl));
    }    
}
