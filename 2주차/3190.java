import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[101][101];
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y][x] = 10;
        }
        int l = Integer.parseInt(br.readLine());
        int[] sec = new int[l];
        String[] moves = new String[l];
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            String m = st.nextToken();
            sec[i] = s;
            moves[i] = m;
        }
        int[][] m = {{0,1},{1,0},{0,-1},{-1,0}};
        int moveCursur = 0;
        int cursur = 0;
        board[1][1] = 1;
        Deque<Integer> xDeque = new ArrayDeque<>();
        Deque<Integer> yDeque = new ArrayDeque<>();
        xDeque.addFirst(1);;
        yDeque.addFirst(1);;
        int cnt = 0;
        while(true){
            int py = yDeque.peekFirst();
            int px = xDeque.peekFirst();
            int dy = m[cursur][0];
            int dx = m[cursur][1];
            int ny = py+dy;
            int nx = px+dx;
            if(ny <= 0 || ny > n || nx <= 0 || nx > n) break;
            if(board[ny][nx] == 1) break;
            if(board[ny][nx] != 10) {
                board[yDeque.pollLast()][xDeque.pollLast()] = 0;
            }
            board[ny][nx] = 1;
            xDeque.addFirst(nx);
            yDeque.addFirst(ny);
            // System.out.println(ny + " " + nx);
            cnt++;
            int msec = sec[moveCursur];
            String move = moves[moveCursur];
            if(msec == cnt){
                if(move.equals("D")){
                    if(cursur == 3) cursur = 0;
                    else cursur++;
                }
                if(move.equals("L")){
                    if(cursur == 0) cursur = 3;
                    else cursur--;
                }
                if(moveCursur + 1 < l) moveCursur++;
            }
        }
        System.out.println(cnt+1);
    }
}
