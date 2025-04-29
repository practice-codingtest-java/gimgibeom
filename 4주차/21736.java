import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        int visited[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = tmp.charAt(j);
                if(arr[i][j] == 'I'){
                    x.add(j);
                    y.add(i);
                    visited[i][j] = 1;
                }
            }
        }
        // System.out.println();
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }
        int cnt = 0;
        int dy[] = {1,-1,0,0};
        int dx[] = {0,0,1,-1};
        while(!x.isEmpty()&&!y.isEmpty()){
            int px = x.poll();
            int py = y.poll();
            // System.out.println(px+ " " + py);
            if(arr[py][px] == 'P')cnt++;
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny>=0 && nx >= 0 && ny < n && nx < m && visited[ny][nx] != 1 && arr[ny][nx] != 'X'){
                    x.add(nx);
                    y.add(ny);
                    visited[ny][nx] = 1;
                }
            }
        }
        if(cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
    }
}
