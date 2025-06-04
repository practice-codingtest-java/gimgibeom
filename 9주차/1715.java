import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            int sum = a+b;
            pq.add(sum);
            cnt+=sum;
        }
        System.out.println(cnt);
    }
}
