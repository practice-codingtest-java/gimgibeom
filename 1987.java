import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void backtracking(char[][] arr, List<Character> output, int idx, boolean[][] visited,int y, int x){
        output.add(arr[y][x]);
        idx++;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]) continue;
            char next = arr[ny][nx];
            for(int j = 0; j < output.size())
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }
        List<Character> l = new ArrayList<>();
        boolean visited[][] = new boolean[n][m];
        visited[0][0] = true;

    }
}
