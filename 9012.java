import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int j = 0; j < n; j++){
            String a = br.readLine();
            Stack<Character> b = new Stack<Character>();
            for(int i = 0; i < a.length(); i++){
                b.push(a.charAt(i));
            }
            int closed = 0;
            int flag = 0;
            for(int i = 0; i < a.length(); i++){
                char tmp = b.pop();
                if(tmp == ')') closed++;
                else closed--;
                if(closed < 0) {
                    System.out.println("NO");
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) continue;
            if(closed!=0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
