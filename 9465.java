import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+2];
            int[][] dp = new int[2][n];
            for(int i = 0 ; i < 2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 2; j <= n+1; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < n; i++){
                int tmp = Math.max(arr[0][i],arr[1][i]);
                arr[0][i+2] += Math.max(arr[1][i+1],tmp);
                arr[1][i+2] += Math.max(arr[0][i+1],tmp);
            }
            System.out.println(Math.max(arr[0][n+1],arr[1][n+1]));
        }
    }
}
