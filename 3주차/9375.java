import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String,Integer> hashMap = new HashMap<>();
            String[] categories = new String[30];
            int index = 0;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                if(!hashMap.containsKey(category)){
                    hashMap.put(category, 1);
                    categories[index] = category;
                    index++;
                } else {
                    int cnt = hashMap.get(category);
                    hashMap.replace(category, cnt+1);
                }
            }
            int ans = keyset.get(0)+1;
            for(int i = 1; i < keyset.size();i++){
                ans *= keyset.get(i)+1;
            }
            System.out.println(ans-1);
        }
    }
}
