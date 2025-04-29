import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            tree.get(tmp1).add(tmp2);
            tree.get(tmp2).add(tmp1);
        }
        Stack<Integer> s = new Stack<>();
        s.push(1);
        int visited[] = new int[n+1];
        int parents[] = new int[n+1]; 
        while(!s.empty()){
            int node = s.pop();
            if(visited[node]==1) continue;
            visited[node] = 1;
            List<Integer> tmp = tree.get(node);
        }
    }
}
