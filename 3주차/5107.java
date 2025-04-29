import java.util.*;
import java.io.*;

public class Main {
    static int[] visited = new int[31];
    static int[] arr = new int[31];
    public static int isCircle(int startindex,int putindex){
        visited[putindex] = 1;
        if(arr[putindex] == startindex) return 1;
        if(arr[putindex] == 0) return 0;
        visited[putindex] = 1;
        return isCircle(startindex, arr[putindex]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        while(true){
            HashMap<String,Integer> hashMap = new HashMap<>();
            int mancnt = 1;
            for(int i = 0; i < 31; i++){
                visited[i] = 0;
                arr[i] = 0;
            }
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                if(!hashMap.containsKey(a)){
                    hashMap.put(a, mancnt);
                    mancnt++;
                }
                String b = st.nextToken();
                if(!hashMap.containsKey(b)){
                    hashMap.put(b, mancnt);
                    mancnt++;
                }
                arr[hashMap.get(a)] = hashMap.get(b);
            }
            int cnt = 0;
            for(int i = 1; i < mancnt; i++){
                if(arr[i]!= 0 && visited[i]==0){
                    visited[i] = 1;
                    if(isCircle(i, arr[i])==1) cnt++;
                }
            }
            System.out.println(testCase + " " + cnt);
            testCase++;
        }
    }
}
