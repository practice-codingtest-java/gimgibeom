import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] days = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            long ans = 0;
            for(int i = 0; i < n; i++){
                days[i] = Integer.parseInt(st.nextToken());
            }
            long cnt = 0;
            int idx = n-1;
            for(int i = n -1; i >= 0; i--){
                if(days[i] < days[idx]){
                    cnt += (long)(days[idx] - days[i]);
                } else {
                    idx = i;
                }
            }
            System.out.println(cnt);
        }
    }    
}
