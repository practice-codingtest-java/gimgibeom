import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < a.length(); i++){
            stack.add(a.charAt(i));
        }
        int flag = 0;
        String b;
        Queue<Character> q;
        while(!stack.empty()){
            char tmp = stack.pop();
            if(tmp == '>') {
                flag = 1;
                q = new ArrayDeque<>();
            }
            if(tmp == '<') {
                flag = 0;
                while(!q.isEmpty()){
                    System.out.print(q.poll());
                }
            }
            if(flag == 1) {
                q.add(null);
            }
        }
    }
}
