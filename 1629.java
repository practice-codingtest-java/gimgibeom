import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long cnt = 1;
        long mula = a%c;
        while(b>0){
            if(b-cnt>=0){
                b-=cnt;
                mula *= mula;
                mula %= c;
                cnt*=2;
            } else{
                cnt = 1;
                b-=cnt;
                mula *= (a%c);
                mula %= c;
            }
        }
        System.out.println(mula);
    }
}
