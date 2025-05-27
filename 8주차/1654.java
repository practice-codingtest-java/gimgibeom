import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        long min = 0;
        long max = Integer.MAX_VALUE;
        int cnt = 0;
        long ans = 0;
        while(min <= max){
            cnt = 0;
            long mid = (min + max) / 2;
            for(int i = 0; i < k; i++){
                cnt += (arr[i]/mid);
            }
            if(cnt < n){
                max = mid-1;
            } else {
                ans = mid;
                min = mid+1;
            }
        }
        System.out.println(ans);
    }
}
