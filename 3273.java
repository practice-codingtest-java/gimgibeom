import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        int m = Integer.parseInt(br.readLine());
        Arrays.sort(a);
        int tmp = n;
        for(int i = 0; i < n-1; i++){
            if(tmp <= i) tmp = n;
            for(int j= i+1;j<tmp;j++){
                if(a[i]+a[j] == m) {
                    cnt++;
                    tmp = j;
                    // System.out.println(i + " " + j);
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
    
}
