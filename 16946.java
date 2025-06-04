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
        int[][] visited = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < m; j++){
                if(tmp.charAt(j) == '0') arr[i][j] = 0;
                else {
                    arr[i][j] = 1;
                }
            }
        }
        Queue<Integer> y = new ArrayDeque<>();
        Queue<Integer> x = new ArrayDeque<>();
        int[][] ans = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != 0 || visited[i][j] != 0) continue;
                int cnt = 0;
                List<Integer> oney;
                List<Integer> onex;
                y.add(i);
                x.add(j);
                while(!y.isEmpty()){
                    int py = y.poll();
                    int px = x.poll();
                    for(int k = 0; k < 4; k++){
                        int ny = py + dy[k];
                        int nx = px + dx[k];
                        if(ny >= 0 && nx >= 0 && ny < n && nx < m && visited[ny][nx] == 0){
                            if(arr[ny][nx] == 1)
                                if(onex.contains(nx) && oney.contains(ny)) continue;
                                
                            }
                        } 
                    }
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.append(String.valueOf(ans[i][j]));
            }
            bw.append('\n');
        }
        bw.flush();
        bw.close();
    }
}
