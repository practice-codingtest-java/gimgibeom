import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][n+1];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,-1,1};
        for(int i = 0; i < 100; i++){
            int cnt = 0;
            int [][] visited = new int[n+1][n+1];
            Queue<Integer> y = new ArrayDeque<>();
            Queue<Integer> x = new ArrayDeque<>();
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(visited[j][k] == 0 && arr[j][k] > i){
                        visited[j][k] = 1;
                        y.add(j);
                        x.add(k);
                        cnt++;
                        while(!y.isEmpty()){
                            int py = y.poll();
                            int px = x.poll();
                            for(int l = 0; l < 4; l++){
                                int ny = dy[l] + py;
                                int nx = dx[l] + px;
                                if(ny >= 0 && nx >= 0 && ny < n && nx < n && visited[ny][nx] == 0 && arr[ny][nx] > i){
                                    y.add(ny);
                                    x.add(nx);
                                    visited[ny][nx] = 1;
                                }
                            }
                        }
                    }
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
