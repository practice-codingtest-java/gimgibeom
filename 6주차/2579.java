import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for(int i = 0; i < n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1){
            System.out.println(score[0]);
            return;
        }
        if(n == 2){
            System.out.println(score[0] + score[1]);
            return;
        }
        int dp[][] = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = score[0];
        dp[0][2] = 0;
        dp[1][0] = score[1];
        dp[1][1] = 0;
        dp[1][2] = score[0] + score[1];
        for(int i = 2; i < n; i++){
            dp[i][0] = Math.max(dp[i-2][0],dp[i-2][1]);
            dp[i][0] = Math.max(dp[i][0],dp[i-2][2]);
            dp[i][0] += score[i];
            dp[i][1] = dp[i-1][0] + score[i];
        }
        int ans = 0;
        for(int i = 0; i < 2; i++){
            if(ans < dp[n-1][i]) ans = dp[n-1][i];
        }
        System.out.println(ans);
    }
}
