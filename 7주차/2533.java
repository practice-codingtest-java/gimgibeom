import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int val;
        int onOff[] = new int[2];
        List<Node> child = new ArrayList<>();
    }

    static int[] backtracking(Node node){
        int[] dp = new int[2];
        
        if(node.child.size() == 0){
            dp[0] = 0;
            dp[1] = 1;
        } else{
            for(int i = 0; i < node.child.size(); i++){
                int[] tmp = backtracking(node.child.get(i));
                dp[0] += tmp[1];
                dp[1] += Math.min(tmp[0],tmp[1]);
            }
            dp[1] += 1;
        }
        // System.out.println(dp[0] + " " + dp[1]);
        return dp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n+1];
        int[] arr2 = new int[n+1];
        int[] visited = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
            arr[i] = new Node();
        }
        for(int i = 0 ; i < n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        arr[1].val = 1;
        visited[1] = 1;
        Stack<Integer> s = new Stack<>();
        List<Integer> tree= graph.get(1);
        int size = tree.size();
        for(int i = 0; i < size; i++){
            int tmp = tree.get(i);
            arr2[tmp] = 1;
            s.push(tmp);
        }
        while (!s.empty()) {
            int now = s.pop();
            visited[now] = 1;
            List<Integer> l = graph.get(now);
            for(int i = 0; i < l.size(); i++){
                int next = l.get(i);
                if(visited[next] == 1) continue;
                s.push(next);
                arr2[next] = now;
            }
        }
        for(int i = 2; i <= n; i++){
            arr[arr2[i]].child.add(arr[i]);
        }
        // for(int i = 1; i <= n; i++){
        //     System.err.print(arr2[i]+" ");
        // }
        // System.out.println();
        int[] ans = backtracking(arr[1]);
        System.out.println(Math.min(ans[0],ans[1]));
    }
}