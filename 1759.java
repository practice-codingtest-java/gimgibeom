import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[] arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        int bit = (1 << c) - 1;
        StringBuffer b = new StringBuffer();
        HashSet<String> hs = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for(int i = bit; i >= 0; i--){
            int tmp = 1;
            int cnt = 0;
            for(int j = 0; j < c; j++){
                int comp = tmp << j;
                if((comp & i) == 0){
                    cnt++;
                }
            }
            if(cnt == l){
                for(int j = 0; j < c; j++){
                    int comp = tmp << j;
                    if((comp & i) == 0){
                        b.append(arr[j]);
                    }
                }
                ans.add(b.toString());
                b = new StringBuffer();
            }
        }
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            String k = ans.get(i);
            int aeiou = 0;
            int rest = 0;
            for(int j = 0; j < k.length(); j++){
                char tmp = k.charAt(j);
                if(tmp == 'a'||tmp=='e'||tmp=='i'||tmp=='o'||tmp=='u') aeiou++;
                else rest++;
            }
            if(aeiou < 1 || rest < 2) continue;
            char[] tmp = k.toCharArray();
            Arrays.sort(tmp);
            String k2 = new String(tmp);
            if(k.compareTo(k2) == 0){
                System.out.println(k);
            }
        }
    }
}
