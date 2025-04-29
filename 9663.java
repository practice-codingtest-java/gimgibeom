import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int cnt;
    static int n;
    static boolean checking(int y, int x){
        for(int i = 0; i < y; i++){
            if(board[i][x] == 1) return false;
        }
        for(int i = 1; i < n; i++){
            if(y-i < 0 || x+i >= n) break;
            if(board[y-i][x+i] == 1) return false;
        }
        for(int i = 1; i < n; i++){
            if(y-i<0 || x-i < 0) break;
            if(board[y-i][x-i] == 1) return false;
        }
        return true;
    }
    static void backtest(int y, int x){
        if(y == n-1){
            if(checking(y,x)) {
                cnt++;
            }
            
            return;
        }
        for(int i = 0; i < n; i++){
            if(checking(y+1, i)){
                board[y+1][i] = 1;
                backtest(y+1, i);
                board[y+1][i] = 0;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        cnt = 0;
        for(int i = 0; i < n; i++){
            board[0][i] = 1;
            backtest(0,i);
            board[0][i] = 0;
        }
        System.out.println(cnt);
    }
}
