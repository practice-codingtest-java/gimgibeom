import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans;
        int sum = arr[0];
        if(arr[0] > 1) {
            System.out.println(1);
            return;
        }
        for(int i = 1; i < n; i++){
            if(sum+1 < arr[i]){
                break;
            }
            sum+=arr[i];
        }
        ans=sum+1;
        System.out.println(ans);
    }
}
