import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i = 0; i < n; i++){
            int[] visited = new int[n];
            Arrays.fill(visited,0);
            Stack<Integer> s = new Stack<>();
            s.push(i);
            Stack<Integer> cnts = new Stack<>();
            cnts.push(1);
            while(!s.empty()){
                int now = s.pop();
                int pcnt = cnts.pop();
                if(visited[now] == 1) continue;
                // System.out.println("now: " + now + " cnt: "+pcnt);
                if(pcnt >= 5){
                    System.out.println(1);
                    return;
                }
                visited[now] = 1;
                List<Integer> list = graph.get(now);
                for(int j = 0 ; j < list.size();j++){
                    if(visited[list.get(j)] != 1) {
                        s.add(list.get(j));
                        cnts.add(pcnt+1);
                    }
                }
            }
            cnts.clear();
            s.clear();
            // System.out.println("\n");
        }
        System.out.println(0);
    }
}
