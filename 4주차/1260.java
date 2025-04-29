import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int[] visited2 = new int[n+1];
        Stack<Integer> s = new Stack<>();
        s.push(v);
        while(!s.empty()){
            int node = s.pop();
            if(visited2[node] == 1) continue;
            visited2[node] = 1;
            System.out.print(node + " ");
            for(int i = n; i >= 1; i--){
                if(arr[node][i] == 1 && visited2[i]==0){
                    s.push(i);
                }
            }
        }

        System.out.println();

        int[] visited = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+ " ");
            for(int i = 1; i <= n; i++){
                if(arr[node][i] == 1 && visited[i] == 0){
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
        
    }
    
}
