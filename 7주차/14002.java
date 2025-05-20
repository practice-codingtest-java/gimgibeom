import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[][] = new int[n][2];
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            l.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][0] = arr[i];
            dp[i][1] = 1;
            l.get(i).add(arr[i]);
        }
        for(int i = n-2; i >= 0; i--){
            int tmp = dp[i][0];
            int max = 0;
            int maxi = -1;
            for(int j = i+1; j < n; j++){
                if(dp[i][0] < dp[j][0]){
                    if(max < dp[j][1]){
                        max = dp[j][1];
                        maxi = j;
                    }
                    max = Math.max(max,dp[j][1]);
                }
            }
            if(max!=0) {
                dp[i][1] += max;
                l.get(i).addAll(l.get(maxi));
            }
        }
        int ans = 0;
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(ans < dp[i][1]){
                ans = dp[i][1];
                idx = i;
            }
        }
        System.out.println(ans);
        Collections.sort(l.get(idx));
        for(int i = 0; i < l.get(idx).size(); i++){
            System.out.print(l.get(idx).get(i)+" ");
        }
    }
}
