import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[][] a = new int[n][k];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        
    }
}
