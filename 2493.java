import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();
        Stack<Integer> indexs = new Stack<>();

        s.push(arr[0]);
        indexs.push(0);
        for(int i = 1; i < n; i++){
            while(!s.empty() && s.peek() < arr[i]){
                s.pop();
                int index = indexs.pop();
                ans[index] = i;
            }
            s.push(arr[i]);
            indexs.push(i);
        }
        while(!indexs.empty()){
            int index = indexs.pop();
            ans[index] = 0; 
        }
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
