import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int k;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> q = new ArrayList<Integer>();
        for(int i = n-3; i >= 0; i--){
            for(int j = n-2; j>i; j--){
                for(int k = n-1; k>j;k--){
                    q.addFirst(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        Collections.sort(q);
        int prev = -1;
        int flag = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int val = q.remove(q.size()-1);
            // System.out.println(val);
            if(prev == val) continue;
            prev = val;
            cnt++;
            if(cnt == k) {
                flag = 1;
                break;
            }
        }
        // System.out.println();
        if(flag == 0) System.out.println(-1);
        else {
            System.out.println(prev);
        }
    }
}
