import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> c = new ArrayList<>();
        for(int i = 0; i <= n; i++) c.add(new ArrayList<>());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(c.get(b).contains(a)) continue;
            c.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] nodes = new int[n+1];
        for(int i = 1; i <= n; i++){
            int[] visited = new int[n+1];
            visited[i] = 1;
            q.add(i);
            int cnt = 1;
            while(!q.isEmpty()){
                int index = q.poll();
                List<Integer> l = c.get(index);
                for(int j = 0; j < l.size();j++){
                    int nindex = l.get(j);
                    if(visited[nindex] == 1) continue;
                    q.add(nindex);
                    cnt++;
                    visited[nindex] = 1;
                }
            }
            nodes[i] = cnt;
        }
        int maxVal = 0;
        for(int i = 1; i <= n; i++){
            if(nodes[i] > maxVal) maxVal = nodes[i];
        }
        for(int i = 1; i <= n; i++){
            if(nodes[i] == maxVal) System.out.print(i+ " ");
        }
    }
    
}
