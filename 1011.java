import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            long start = 0;
            long end = y-x;
            long cnt = 0;
            for(long i = 1; i < (1<<16)-1; i++){
                if(i*i == end){
                    System.out.println((2*i)-1);
                    break;
                } else if(i*i > end && (i-1)*(i-1)+(i-1) < end){
                    System.out.println((i-1)*2 + 1);
                    break;
                } else if(i*i > end && (i-1)*(i-1)+(i-1) >= end){
                    System.out.println((i-1)*2);
                    break;
                }
            }
        }
    }
}
