import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= v; i++){
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                graph.get(s).add(f);
                graph.get(f).add(s);
            }
            Queue<Integer> node = new ArrayDeque<>();
            int[] color = new int[v+1];
            boolean[] visited = new boolean[v+1];
            int flag = 0;
            for(int tmp = 1; tmp <= v; tmp++){
            if(visited[tmp]) continue;
            visited[tmp] = true;
            node.add(tmp);
            color[tmp] = 1;
            
            while(!node.isEmpty()){
                int now = node.poll();
                List<Integer> list = graph.get(now);
                for(int i = 0; i < list.size(); i++){
                    int next = list.get(i);
                    if(visited[next]) continue;
                    if(color[now] == 1){
                        color[next] = 2;
                    } else {
                        color[next] = 1;
                    }
                    visited[next] = true;
                    node.add(next);
                }
            }
        }
            for(int i = 1; i <= v; i++){
                List<Integer> l = graph.get(i);
                for(int j = 0; j < l.size(); j++){
                    if(color[i] == color[l.get(j)]){
                        flag = 1;
                    }
                }
            }
            if(flag == 0){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
