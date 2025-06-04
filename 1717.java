import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    public static void makeSet(int n){
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }

    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }

    public static String same(int x, int y){
        return find(x) == find(y) ? "YES" : "NO";
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        makeSet(n);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int tr = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(tr == 0){
                union(a, b);
            } else {
                String tmp = same(a, b);
                System.out.println(tmp);
            }
        }
    }
    
}
