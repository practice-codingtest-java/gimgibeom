import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = (y*100)/x;

        if(z>=99) {
            // System.out.println(z);
            System.out.println(-1);
            return;
        }

        long min = 1, max = x;
        long ans = -1;
        while (max >= min) {
            long mid = (min+max)/2;
            long now = ((y+mid)*100)/(x+mid);
            if(now > z){
                ans = mid;
                max = mid -1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
