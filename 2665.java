import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < n; j++){
                if(tmp.charAt(j) == '1'){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        boolean[][][] visited = new boolean[n][n][n*2];
        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> y = new ArrayDeque<>();
        Queue<Integer> breaked = new ArrayDeque<>();
        x.add(0);
        y.add(0);
        breaked.add(0);
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        visited[0][0][0] = true;
        while(!y.isEmpty()){
            int py = y.poll();
            int px = x.poll();
            int pbreak = breaked.poll();
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny < 0 || nx < 0 || ny>=n || nx >=n) continue;
                if(arr[ny][nx] == 0 &&pbreak+1 < n*2 && !visited[ny][nx][pbreak+1]){
                    visited[ny][nx][pbreak+1] = true;
                    x.add(nx);
                    y.add(ny);
                    breaked.add(pbreak+1);
                }
                if(arr[ny][nx] == 1 && !visited[ny][nx][pbreak]){
                    visited[ny][nx][pbreak] = true;
                    x.add(nx);
                    y.add(ny);
                    breaked.add(pbreak);
                }
            }
        }
        for(int i = 0; i < n*2; i++){
            if(visited[n-1][n-1][i]){
                System.out.println(i);
                return;
            }
        }
    }
}
