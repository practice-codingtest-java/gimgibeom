import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            q.add(i);
        }
        int cnt = 0;
        System.out.print("<");
        while(q.size() > 1){
            cnt++;
            if(cnt < k){
                q.add(q.poll());
            } else {
                System.out.print(q.poll()+", ");
                cnt=0;
            }
        }
        System.out.print(q.poll()+">");
    }
}
