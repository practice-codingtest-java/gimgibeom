import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] bag = new int[n+1][k+1];
        int[] weights = new int[n+1];
        int[] values = new int[n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            weights[i] = w;
            int v = Integer.parseInt(st.nextToken());
            values[i] = v;
        }
        for(int i = 1; i <=n; i++){
            for(int j = 0; j <= k; j++){
                if(weights[i]>j){
                    bag[i][j] = bag[i-1][j];
                } else{
                    bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-weights[i]] + values[i]);
                }
            }
        }
        System.out.println(bag[n][k]);
    }
}
