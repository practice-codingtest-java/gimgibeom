import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int parents[] = new int[n+1];
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i <= n; i++) l.add(new ArrayList<>());
        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l.get(a).add(b);
            l.get(b).add(a);
        }
        Stack<Integer> s = new Stack<>();
        s.push(1);
        int[] visited = new int[n+1];
        while(!s.empty()){
            int index = s.pop();
            List<Integer> tmp = l.get(index); 
            if(visited[index] == 1) continue;
            visited[index] = 1;
            for(int i = 0; i < tmp.size(); i++){
                if(visited[tmp.get(i)] == 0) {
                    parents[tmp.get(i)] = index;
                    s.push(tmp.get(i));
                }
            }
        }
        for(int i = 2; i <= n; i++){
            System.out.println(parents[i]);
        }
    }
}
