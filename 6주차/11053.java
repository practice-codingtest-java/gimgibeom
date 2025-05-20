import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[][] = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][0] = arr[i];
            dp[i][1] = 1;
        }
        for(int i = n-2; i >= 0; i--){
            int tmp = dp[i][0];
            int max = 0;
            for(int j = i+1; j < n; j++){
                if(dp[i][0] < dp[j][0]){
                    max = Math.max(max,dp[j][1]);
                }
            }
            if(max!=0) dp[i][1] += max;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans,dp[i][1]);
        }
        System.out.println(ans);
    }
}
