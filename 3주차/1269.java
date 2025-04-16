import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        st = new StringTokenizer(br.readLine());
        int ans = n;
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(st.nextToken());
            hashMap.put(k, 1);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int k = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(k)) ans--;
            else ans++;
        }
        System.out.println(ans);
    }
    
}
