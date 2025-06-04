import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int crains[] = new int[n];
        for(int i = 0; i < n; i++){
            crains[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] boxs = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            boxs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crains);
        int days = 0;
        Arrays.sort(boxs);
        int flag = 0;
        int j = n-1;
        if(crains[n-1] < boxs[m-1]) {
            System.out.println(-1);
            return;
        }
        while(flag == 0){
            flag = 1;
            j = n-1;
            for(int i = m-1; i >= 0; i--){
                if(boxs[i] == 0) continue;
                else flag = 0;
                if(boxs[i] <= crains[j]){
                    boxs[i] = 0;
                    j--;
                }
                if(j < 0){
                    j = n-1;
                    break;
                }
            }
            days++;
        }
        System.out.println(days-1);
    }
}
