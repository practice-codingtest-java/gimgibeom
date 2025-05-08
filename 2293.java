import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[][] a = new int[n][k+1];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        //1부터 갯수를 늘리면 되지 않을지..
        for(int i = 0; i <= k; i++){

        }
    }
}
