import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int cnt = 0;
        int stick = 0;
        int lazer = 0;
        int opened = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == '('){
                if(i+1 < a.length() && a.charAt(i+1) != ')'){
                    stick++;
                }
                opened++;
            }
            if(a.charAt(i) == ')'){
                if(a.charAt(i-1) == '('){
                    lazer++;
                    cnt += stick;
                    opened--;
                }
                else{
                    opened--;
                    if(stick >= 1){
                        cnt++;
                    }
                    stick--;
                }
            }
            // System.out.println("i : "+ i +" cnt: "+ cnt + " stick: " +stick);
        }
        System.out.println(cnt);
    }
}
