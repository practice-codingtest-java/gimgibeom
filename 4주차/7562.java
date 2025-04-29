import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dy = {2,2,-2,-2,1,1,-1,-1};
        int[] dx = {1,-1,1,-1,2,-2,2,-2};
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            Deque<Integer> y = new ArrayDeque<>();
            Deque<Integer> x = new ArrayDeque<>();
            int visited[][] = new int[n][n];
            int[][] cnts = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            y.add(sy);
            x.add(sx);
            visited[sy][sx] = 1;
            while(!y.isEmpty()){
                int py = y.poll();
                int px = x.poll();
                for(int i = 0; i < 8; i++){
                    int ny = py + dy[i];
                    int nx = px + dx[i];
                    if(ny>=0 && nx >=0 && ny < n && nx < n && visited[ny][nx] == 0){
                        y.add(ny);
                        x.add(nx);
                        visited[ny][nx] = 1;
                        cnts[ny][nx] = cnts[py][px] + 1;
                    }
                }
            }
            System.out.println(cnts[ey][ex]);
        }
    }
}
