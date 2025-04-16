import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int size = 0;
        HashMap<String,Integer> hashMap = new HashMap<>();
        while(size<a.length()){
            String tmp = a;
            for(int i = 0; i < a.length()-size; i++){
                String substring = a.substring(i, i+size+1);
                a = tmp;
                if(hashMap.containsKey(substring)) continue;
                else {
                    // System.out.println(substring);
                    hashMap.put(substring, 0);
                }
            }
            size++;
        }
        System.out.println(hashMap.size());
    }
    
}
