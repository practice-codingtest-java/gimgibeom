import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    // 같은 문자 → 대각선 값 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 다른 문자 → 위 또는 왼쪽 값 중 큰 것
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
