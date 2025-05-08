import java.util.*;
import java.io.*;

public class Main {
    static int n;

    static int udlr(int[][] arr,int cnt){
        int maxVal = 0;
        int[][] up;
        int[][] down;
        int[][] left;
        int[][] right;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                up[i][j] = arr[i][j];
                down[i][j] = arr[i][j];
                left[i][j] = arr[i][j];
                right[i][j] = arr[i][j];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
