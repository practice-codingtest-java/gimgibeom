import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int cnt = 0;
        int xindex = 0;
        int yindex = 0;
        int len = 0;
        while(yindex < n && xindex < n){
            if(xindex == yindex){
                cnt += y[yindex]-x[xindex];
                xindex++;
            } else if(x[xindex] <= y[yindex] && xindex > yindex){
                x[xindex] = y[yindex];
                yindex++;
            } else if(x[xindex] >= y[yindex] && xindex > yindex){
                yindex++;
            }
        }
        System.out.println(cnt);
    }
}
