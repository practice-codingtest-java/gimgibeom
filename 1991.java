import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][]tree = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left!='.'){
                tree[p-'A'][0] = left-'A';
            } else {
                tree[p-'A'][0] = -1;
            }
            if(right =='.'){
                tree[p-'A'][1] = -1;
            } else {
                tree[p-'A'][1] = right-'A';
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < 2; j++){
        //         System.out.print(tree[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        preorder(tree, 0);
        System.out.println();
        inorder(tree, 0);
        System.out.println();
        postorder(tree, 0);
    }
    public static void preorder(int[][] tree, int node){
        if(node == -1) return;
        System.out.print((char)(node +'A'));
        preorder(tree, tree[node][0]);
        preorder(tree, tree[node][1]);
    }
    public static void postorder(int[][] tree, int node){
        if(node == -1) return;
        postorder(tree, tree[node][0]);
        postorder(tree, tree[node][1]);
        System.out.print((char)(node +'A'));
        
    }
    public static void inorder(int[][] tree, int node){
        if(node == -1) return;
        inorder(tree, tree[node][0]);
        System.out.print((char)(node +'A'));
        inorder(tree, tree[node][1]);
    }
}
