import java.io.*;
import java.util.*;

public class Main {
    static int sy,sx;
    static int fy = -1,fx = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<Integer> y = new ArrayDeque<>();
        Queue<Integer> x = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        int[][] firedue = new int[n][m];
        for(int i = 0; i < n; i++){
            String a = br.readLine();
            for(int j = 0; j < m; j++){
                if(a.charAt(j)=='#') arr[i][j] = 1;
                else if(a.charAt(j) == '.') arr[i][j] = 0;
                else if(a.charAt(j) == 'J') {
                    arr[i][j] = 2;
                    sy = i;
                    sx = j;
                }
                else if(a.charAt(j) == 'F') {
                    y.add(i);
                    x.add(j);
                    visited[i][j] = 1;
                    firedue[i][j] = 1;
                }
            }
        }
        while(!y.isEmpty()){
            int py = y.poll();
            int px = x.poll();
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && visited[ny][nx] == 0 && arr[ny][nx] != 1){
                    firedue[ny][nx] = firedue[py][px] + 1;
                    y.add(ny);
                    x.add(nx);
                    visited[ny][nx] = 1;
                }
            }
        }
        // System.out.println();
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++){
        //         System.out.print(firedue[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int[][] visited2 = new int[n][m];
        Queue<Integer> cnts = new ArrayDeque<>();
        y.clear();
        x.clear();
        y.add(sy);
        x.add(sx);
        cnts.add(1);
        visited2[sy][sx] = 1;
        while(!y.isEmpty()){
            int py = y.poll();
            int px = x.poll();
            int pcnt = cnts.poll();
            // System.out.println(py + " " + px);
            if(py == n-1 || py == 0 || px == m-1 || px == 0) {
                // System.out.println(py + " " + px);
                System.out.println(pcnt);
                return;
            }
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && visited2[ny][nx] == 0 && arr[ny][nx] != 1 && (firedue[ny][nx] > pcnt+1 || firedue[ny][nx] == 0)){
                    y.add(ny);
                    x.add(nx);
                    cnts.add(pcnt+1);
                    visited2[ny][nx] = 1;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
        return;
    }
}
