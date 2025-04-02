import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int [n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i < r; i++){
            int x = 0, y = 0;
            while(m-(x+x)>0 && n-(y+y)>0){
                int topLeft = arr[y][x];
                int topRight = arr[y][m-1-x];
                int bottomLeft = arr[n-1-y][x];
                int bottomRight = arr[n-1-y][m-1-x];
                for(int j = x; j < m-x-2; j++){
                    arr[y][j] = arr[y][j+1];
                }
                for(int j = n-y-1; j > y+1; j--){
                    arr[j][x] = arr[j-1][x];
                }
                for(int j = m-x-1; j > x+1; j--){
                    arr[n-1-y][j] = arr[n-1-y][j-1];
                }
                for(int j = y; j < n-y-2; j++){
                    arr[j][m-1-x] = arr[j+1][m-1-x];
                }
                arr[y+1][x] = topLeft;
                arr[y][m-2-x] = topRight;
                arr[n-1-y][x+1] = bottomLeft;
                arr[n-2-y][m-1-x] = bottomRight;
                x++;
                y++;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
