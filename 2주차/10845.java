import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = -1;
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                int t = Integer.parseInt(st.nextToken());
                q.add(t);
                last =t;
            }
            if(op.equals("pop")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.poll());
            }
            if(op.equals("size")){
                System.out.println(q.size());
            }
            if(op.equals("empty")){
                if(q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            if(op.equals("front")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek());
            }
            if(op.equals("back")){
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(last);
            }
        }
    }
}
