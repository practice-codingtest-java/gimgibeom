import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());
        long min = 1;
        long max = k;
        long ans = 0;
        while(min <= max) {
            long mid = (min+max)/2;
            long scnt = 0;
            for(int i = 1; i <= n; i++){
                scnt += Math.min(n,mid/i);
            }
            if(scnt < k){
                min = mid + 1;
            } else {
                ans = mid;
                max = mid-1;
            }
        }
        System.out.println(ans);
    }
}
