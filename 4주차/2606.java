import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] c = new int[n+1][n+1];
        int[] visited = new int[n+1];

        for(int i = 0; i <k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            c[a][b] = 1;
            c[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        visited[1] = 1;
        visited[0] = 1;
        int cnt = 0;
        for(int i = 2; i <= n; i++){
            if(visited[i] == 0 && c[1][i] == 1){
                q.add(i);
                visited[i] = 1;
                cnt++;
                while(!q.isEmpty()){
                    int index = q.poll();
                    // System.out.println(index);
                    for(int j = 2; j <= n; j++){
                        if(visited[j] == 0 && c[index][j] == 1){
                            visited[j] = 1;
                            cnt++;
                            q.add(j);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
