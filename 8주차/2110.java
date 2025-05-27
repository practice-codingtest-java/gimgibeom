import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long min = 1;
        // System.out.println(arr[n-1] + " " + arr[0]);
        long max = arr[n-1] - arr[0];
        long ans = 0;
        while(max>=min){
            long mid = (max+min)/2;
            int cnt = 1;
            int mind = 0;
            int prev = arr[0];
            for(int i = 1; i < n; i++){
                if(arr[i]-prev >= mid){
                    prev = arr[i];
                    cnt++;
                }
            }
            if(cnt >= c){
                ans = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        System.out.println(ans);
    }
}
