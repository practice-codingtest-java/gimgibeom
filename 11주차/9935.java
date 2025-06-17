import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < a.length(); i++){
            s.push(a.charAt(i));
            if(s.peek() == b.charAt(0)) {
                int flag = 0;
                for(int j = 1; j <b.length(); j++){
                    if(i+j >= a.length()){
                        flag = 1;
                        break;
                    }
                    if(a.charAt(i+j) != b.charAt(j)){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    s.pop();
                    i += (b.length()-1);
                }
            }
        }
        while(!s.empty()){
            System.out.print(s.pop());
        }
    }
}
