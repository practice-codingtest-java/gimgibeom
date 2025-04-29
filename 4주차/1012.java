import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];
            int[][] visited = new int[n][m];
            int dx[] = {1,-1,0,0};
            int dy[] = {0,0,1,-1};
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            int cnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 1 && visited[i][j] == 0){
                        cnt++;
                        visited[i][j] = 1;
                        Queue<Integer> y = new LinkedList<>();
                        Queue<Integer> x = new LinkedList<>();
                        y.add(i);
                        x.add(j);
                        while(!x.isEmpty()&&!y.isEmpty()){
                            int py = y.poll();
                            int px = x.poll();
                            for(int r = 0; r < 4; r++){
                                int ny = py + dy[r];
                                int nx = px + dx[r];
                                if(ny>=0 && nx >= 0 && ny<n && nx < m &&visited[ny][nx] == 0 && arr[ny][nx] == 1){
                                    y.add(ny);
                                    x.add(nx);
                                    visited[ny][nx] = 1;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
