import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        String stmt = br.readLine();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < stmt.length(); i++){
            char tmp = stmt.charAt(i);
            if((tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z')){
                sb.append(tmp);
            }
            if(tmp == '+' || tmp == '-'){
                s.push(tmp);
                if(i+2 >= stmt.length() || stmt.charAt(i+1) == '(' || stmt.charAt(i+2) == '*' || stmt.charAt(i+2) == '/') continue;
                sb.append(stmt.charAt(i+1));
                while(!s.empty()){
                    sb.append(s.pop());
                }
                i++;
            }
            if(tmp == '*' || tmp == '/'){
                s.push(tmp);
                if(i+2 >= stmt.length() || stmt.charAt(i+1) == '(') continue;
                sb.append(stmt.charAt(i+1));
                i++;
            }
        }
    }
}
