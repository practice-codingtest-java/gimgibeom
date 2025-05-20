import java.util.*;
import java.io.*;

public class Main {
    static void divide(int sy, int sx, int ey,int ex, int[][] arr){
        int totaly = ey-sy+1;
        int totalx = ex-sx+1;
        int val = totaly/3;
        if(totaly == 1) {
            arr[sy][sx] = 1;
            return;
        }
        divide(sy,sx,sy+val-1,sx+val-1,arr);
        divide(sy,sx+val,sy+val-1,sx+val+val-1,arr);
        divide(sy,sx+2*val,sy+val-1,ex,arr);
        divide(sy+val,sx,sy+val+val-1,sx+val-1,arr);
        divide(sy+val,sx+val+val,sy+val+val-1,ex,arr);
        divide(sy+val+val,sx,ey,sx+val-1,arr);
        divide(sy+val+val,sx+val,ey,sx+val+val-1,arr);
        divide(sy+val+val,sx+val+val,ey,ex,arr);
        return;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        divide(0,0,n-1,n-1,arr);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1){
                    bw.append("*");
                } else{
                    bw.append(" ");
                }
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
    }
}
