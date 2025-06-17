import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < n-3; i++){
            for(int j = i+1; j < n-2;j++){
                for(int k = j+1; k < n-1; k++){
                    for(int l = k+1; l < n; l++){
                        if(arr[i]+arr[j]+arr[k] == arr[l]){
                            ans = Math.max(ans,arr[l]);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
