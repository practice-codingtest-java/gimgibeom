import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> a = new Stack<Integer>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                int t = Integer.parseInt(st.nextToken());
                a.push(t);
            }
            if(op.equals("top")){
                if(a.empty()){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(a.lastElement());
            }
            if(op.equals("pop")){
                if(a.size()==0){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(a.pop());
            }
            if(op.equals("size")){
                System.out.println(a.size());
            }
            if(op.equals("empty")){
                if(a.empty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}