import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+2][k+2];
        for(int i = 4; i <= n; i++){
            dp[i][1] = i;
        }
        dp[4][2] = 2;
        if(n == 4){
            System.out.println(dp[n][k]);
            return;
        }
        dp[5][1] = 5;
        dp[5][2] = 5;
        for(int i = 6; i <= n; i++){
            for(int j = 2; j <= k; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1])%1000000003;
            }
        }
        System.out.println(dp[n][k]);
    }
}
