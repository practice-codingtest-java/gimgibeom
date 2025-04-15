import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push_front")){
                int t = Integer.parseInt(st.nextToken());
                dq.addFirst(t);
            }
            if(op.equals("push_back")){
                int t = Integer.parseInt(st.nextToken());
                dq.addLast(t);
            }
            if(op.equals("pop_front")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.pollFirst());
            }
            if(op.equals("pop_back")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.pollLast());
            }
            if(op.equals("size")){
                System.out.println(dq.size());
            }
            if(op.equals("empty")){
                if(dq.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            if(op.equals("front")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.peekFirst());
            }
            if(op.equals("back")){
                if(dq.isEmpty()) System.out.println(-1);
                else System.out.println(dq.peekLast());
            }
        }
    }
}
