import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int arr[] = new int[100001];
        int visited[] = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = 1;
        while(!q.isEmpty()){
            int p = q.poll();
            if(p+1 <= 100000 && (visited[p+1] == 0 || arr[p+1] > arr[p]+1)){
                q.add(p+1);
                visited[p+1] = 1;
                arr[p+1] = arr[p]+1;
            }
            if(p-1 >=0 && (visited[p-1] == 0 || arr[p-1] > arr[p]+1)){
                q.add(p-1);
                visited[p-1] = 1;
                arr[p-1] = arr[p]+1;
            }
            if(p*2 <= 100000 && (visited[p*2] == 0 || arr[p*2] > arr[p])){
                q.add(p*2);
                visited[p*2] = 1;
                arr[p*2] = arr[p]; 
            }
        }
        System.out.println(arr[b]);
    }
}
