import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            // System.out.println(ans);
            if(arr[i] < 0){
                pq.add(ans);
            }
            if(arr[i] < 0 && (arr[i]*-1 >= ans)){
                // System.out.println("in");
                pq.add(ans);
                ans = 0;
                continue;
            }
            else ans+=arr[i];
        }
        // System.out.println(ans);
        pq.add(ans);
        int ans2 = 0;
        // System.out.println(pq.size());
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            // System.out.println(tmp);
            ans2 = Math.max(ans2, tmp);
        }
        if(ans2 == 0){
            Arrays.sort(arr);
            System.out.println(arr[n-1]);
            return;
        }
        System.out.println(ans2);
    }
}