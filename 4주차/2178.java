import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i = 0; i<n;i++){
            String a = br.readLine();
            for(int j = 0; j < m; j++){
                if(a.charAt(j) == '1') arr[i][j] = 1;
                else arr[i][j] = 0;
            }
        }
        // System.out.println();
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }
        int[][] visited = new int[n][m];
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};
        visited[0][0] = 1;
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        x.add(0);
        y.add(0);
        c.add(0);
        int cnt = 0;
        while(!x.isEmpty() && !y.isEmpty()){
            int px = x.poll();
            int py = y.poll();
            int pcnt = c.poll();
            if(py == n-1 && px == m-1){
                cnt = pcnt;
                break;
            }
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && visited[ny][nx] == 0 && arr[ny][nx] ==1){
                    x.add(nx);
                    y.add(ny);
                    c.add(pcnt+1);
                    visited[ny][nx] = 1;
                }
            }
        }
        System.out.println(cnt+1);
    }
    
}
