import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        int[][] arr = new int[n+1][m+1];
        int[][][] visited = new int[n+1][m+1][k+1];
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
        Deque<Integer> breaked = new ArrayDeque<>();
        int ans = -1;
        
        y.add(0);
        x.add(0);
        cnts.add(1);
        breaked.add(0);
        visited[0][0][0] = 1;
        while(!y.isEmpty()){
            int px = x.poll();
            int py = y.poll();
            int pcnt = cnts.poll();
            int pbreaked = breaked.poll();
            if(px == m-1 && py == n-1){
                ans = pcnt; break;
            }
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny>=0 && nx >= 0 && ny < n && nx < m && arr[ny][nx] == 0 && visited[ny][nx][pbreaked] == 0){
                    x.add(nx);
                    y.add(ny);
                    cnts.add(pcnt+1);
                    breaked.add(pbreaked);
                    visited[ny][nx][pbreaked] = 1;
                } else if(pbreaked < k && ny>=0 && nx >= 0 && ny < n && nx < m && arr[ny][nx] == 1 && visited[ny][nx][pbreaked] == 0){
                    if(pcnt%2 == 0){
                        x.add(px);
                        y.add(py);
                        cnts.add(pcnt+1);
                        breaked.add(pbreaked);
                        continue;
                    }
                    x.add(nx);
                    y.add(ny);
                    
                    cnts.add(pcnt+1);
                    
                    breaked.add(pbreaked+1);
                    visited[ny][nx][pbreaked] = 1;
                    
                }
            }
        }
        System.out.println(ans);
    }
}