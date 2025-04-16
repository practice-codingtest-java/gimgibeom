import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[] arr = new int[26];
        for(int i = 0; i < a.length(); i++){
            char tmp = a.charAt(i);
            arr[tmp-'a']++;
        }
        for(int i = 0; i < b.length();i++){
            char tmp = b.charAt(i);
            arr[tmp-'a']--;
        }
        int cnt = 0;
        for(int i = 0; i < 26; i++){
            if(arr[i] == 0) continue;
            if(arr[i] < 0) cnt += -arr[i];
            if(arr[i] > 0) cnt += arr[i];
        }
        System.out.println(cnt);
    }
}
