import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] leaf = new int[n];
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            if(tmp != -1){
                leaf[tmp] = 1;
            }
        }
        int d = Integer.parseInt(br.readLine());
        leaf[d] = 1;
        int flag = 0;
        for(int i = 0; i < n; i++){
            if(i == d) continue;
            if(arr[i] == arr[d]) flag = 1;
        }
        if(flag==0){
            if(arr[d]!= -1){
                leaf[arr[d]] = 0;
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(leaf[i] == 0){
                int before = arr[i];
                while(before != -1){
                    if(before == d){
                        leaf[i] = 1;
                        break;
                    }
                    before = arr[before];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(leaf[i] == 0) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
