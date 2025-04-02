import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String a = br.readLine();
            if(a.compareTo("0")==0) break;
            boolean flag = false;
            for(int i = 0; i < a.length()/2;i++){
                if(a.charAt(i) != a.charAt(a.length()-1-i)){
                    System.out.println("no");
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.println("yes"); 
        }
    }
}
