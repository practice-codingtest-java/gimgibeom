import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            int val1 = Integer.parseInt(br.readLine());
            coins[i] = val1;
        }
        Arrays.sort(coins);
        if(k == 0) {
            System.out.println(-1);
            return;
        }
        int[][] arr = new int[coins.length+1][k+1];
        int[] successed = new int[k+1];
        successed[0] = 1;
        for(int j = 1; j <= k; j++){
            int minVal = 0;
            for(int i = 0; i < coins.length; i++){
                if(j-coins[i] >=0 &&successed[j-coins[i]] == 1){
                    successed[j] = 1;
                    arr[i][j] = arr[coins.length][j-coins[i]] + 1;
                    if(minVal == 0 || minVal > arr[i][j]) minVal = arr[i][j];
                }
            }
            if(successed[j] == 1) arr[coins.length][j] = minVal;
        }
        if(arr[coins.length][k] == 0){
            System.out.println(-1);
            return;
        }
        System.out.println(arr[coins.length][k]);
    }
}
