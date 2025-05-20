import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] files = new int[k + 1];
            int[] sum = new int[k + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + files[i];
            }

            int[][] dp = new int[k + 1][k + 1];

            for (int len = 2; len <= k; len++) {
                for (int i = 1; i <= k - len + 1; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int mid = i; mid < j; mid++) {
                        dp[i][j] = Math.min(dp[i][j],
                            dp[i][mid] + dp[mid + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }

            System.out.println(dp[1][k]);
        }
    }
}
