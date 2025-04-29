import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        int[][] arr = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        int[][] dpbreaked = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < m; j++){
                if(tmp.charAt(j) == '0') arr[i][j] = 0;
                else {
                    arr[i][j] = 1;
                }
            }
        }
        Deque<Integer> y = new ArrayDeque<>();
        Deque<Integer> x = new ArrayDeque<>();
        Deque<Integer> cnts = new ArrayDeque<>();
        int ans = 10000000;
        int[][] visited = new int[n][m];
        
        y.add(0);
        x.add(0);
        cnts.add(1);
        visited[0][0] = 1;
        dp[0][0] = 1;
        while(!y.isEmpty()){
            int px = x.poll();
            int py = y.poll();
            int pcnt = cnts.poll();
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny>=0 && nx >= 0 && ny < n && nx < m && visited[ny][nx] == 0 && arr[ny][nx] == 0){
                    x.add(nx);
                    y.add(ny);
                    cnts.add(pcnt+1);
                    dp[ny][nx] = pcnt+1;
                    visited[ny][nx] = 1;
                }
                if(arr[ny][nx] == 1 && visited[ny][nx] == 0);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 1){
                    
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        if(ans == 10000000){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
}