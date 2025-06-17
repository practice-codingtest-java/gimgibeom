import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = Integer.MAX_VALUE;
        int max = (1 << n) - 1;
        for(int i = 1; i < max; i++){
            int tmp = i;
            int cnt = 0;
            for(int j = 1; j < max; j = j<<1){
                if((j & tmp) == j){
                    cnt++;
                }
            }
            List<Integer> idxs1 = new ArrayList<>();
            List<Integer> idxs2 = new ArrayList<>();
            if(cnt != n/2) continue;
            int index = 0;
            for(int j = 1; j < max; j= j<<1){
                if((j&tmp) == j){
                    idxs1.add(index);
                } else{
                    idxs2.add(index);
                }
                index++;
            }
            int sum1 = 0;
            int sum2 = 0;
            for(int j = 0; j < idxs1.size(); j++){
                for(int k = j+1; k < idxs1.size(); k++){
                    sum1 += arr[idxs1.get(j)][idxs1.get(k)];
                    sum1 += arr[idxs1.get(k)][idxs1.get(j)];
                    sum2 += arr[idxs2.get(j)][idxs2.get(k)];
                    sum2 += arr[idxs2.get(k)][idxs2.get(j)];
                }
            }
            int mins = Math.max(sum1-sum2, sum2-sum1);
            // for(int j = 0; j < idxs1.size(); j++){
            //     System.out.print(idxs1.get(j) + " ");
            // }
            // System.out.println(mins);
            ans = Math.min(ans, mins);
        }
        System.out.println(ans);
    }    
}
