import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        Vector<Integer> b = new Vector<Integer>();
        for(int i = 0; i < a.length(); i++){
            int tmp = a.charAt(i)-'0';
            b.add(tmp);
        }
        Collections.sort(b);
        for(int i = a.length()-1; i >= 0; i--){
            System.out.printf(String.valueOf(b.elementAt(i)));
        }
    }
}