import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Vector<String> v = new Vector<String>();
        int len;
        for(int i = 0 ; i < n ; i++){
            String a = br.readLine();
            v.add(a);
            len = a.length();
        }
        int cnt = 0;
        for(int i = 0; i < n-1; i++){
            String a = v.elementAt(i);
            for(int j = i+1; j < n; j++){
                String b = v.elementAt(j);
                HashMap<Character,Character> m = new HashMap<>();
                boolean flag = false;
                for(int k = 0; k < a.length();k++){
                    if(!m.containsKey(a.charAt(k)) && !m.containsValue(b.charAt(k))){
                        m.put(a.charAt(k), b.charAt(k));
                    } else{
                        if(m.get(a.charAt(k)) == null ||m.get(a.charAt(k)) != b.charAt(k)){
                            flag = true; break;
                        }
                    }
                }
                if(!flag) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
