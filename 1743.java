import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n+2][m+2];
        for(int i = 0 ; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
        }
        boolean visited[][] = new boolean[n+2][m+2];
        int ans = 0;
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(visited[i][j] || arr[i][j] == 0) continue;
                // System.out.println();
                int cnt = 0;
                Queue<Integer> y = new ArrayDeque<>();
                Queue<Integer> x = new ArrayDeque<>();
                y.add(i);
                x.add(j);
                visited[i][j] = true;
                while(!y.isEmpty()){
                    int py = y.poll();
                    int px = x.poll();
                    cnt++;
                    // System.out.println(py+" "+px);
                    for(int l = 0; l < 4; l++){
                        int ny = py + dy[l];
                        int nx = px + dx[l];
                        if(ny > 0 && nx > 0 && ny <= n && nx <= m && !visited[ny][nx] && arr[ny][nx] == 1){
                            visited[ny][nx] = true;
                            y.add(ny);
                            x.add(nx);
                        }
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}