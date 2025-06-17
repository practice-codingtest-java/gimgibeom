import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i< n; i++){
            s.push(arr[i]);
        }
        for(int i = n-1; i >= 0; i--){
            
        }
    }
}
