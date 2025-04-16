import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        HashMap<String,Integer> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            String tmp = st.nextToken();
            hm.put(tmp,0);
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            while(cnt > 0){
                String name = st.nextToken();
                int val = hm.get(name);
                hm.replace(name, val+1);
                cnt--;
            }
        }
        List<String> keySet = new ArrayList<>(hm.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(hm.get(o2).compareTo(hm.get(o1)) == 0){
                    return o1.compareTo(o2);
                }
                return hm.get(o2).compareTo(hm.get(o1));
            }
        });
        for(String key : keySet){
            System.out.println(key + " " + hm.get(key));
        }
    }
}
