import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char arr[][] = new char[n][m];
        List<Integer> coinpos = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = tmp.charAt(j);
                if(arr[i][j] == 'o'){
                    coinpos.add(i);
                    coinpos.add(j);
                }
            }
        }
        boolean [][][][] visited = new boolean[n][m][n][m];
        Queue<List<Integer>> pos = new ArrayDeque<>();
        Queue<Integer> cnts = new ArrayDeque<>();
        pos.add(coinpos);
        cnts.add(1);
        visited[coinpos.get(0)][coinpos.get(1)][coinpos.get(2)][coinpos.get(3)] = true;
        int ans = 0;
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        while(!pos.isEmpty()){
            List<Integer> cur = pos.poll();
            int pcnt = cnts.poll();
            int c1y = cur.get(0);
            int c1x = cur.get(1);
            int c2y = cur.get(2);
            int c2x = cur.get(3);
            if(pcnt > 10) {
                System.out.println(-1);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nc1y = c1y + dy[i];
                int nc1x = c1x + dx[i];
                int nc2y = c2y + dy[i];
                int nc2x = c2x + dx[i];
                // System.out.println(nc1y + " " + nc1x + " " + nc2y + " " + nc2x);
                if(((nc1y >= n || nc1y < 0) || (nc1x >= m || nc1x < 0))&&((nc2y>=n || nc2y < 0) || (nc2x >= m || nc2x < 0))){
                    // System.out.println("continue");
                    continue;
                } else if(((nc1y >= n || nc1y < 0)|| (nc1x >= m || nc1x < 0))||((nc2y>=n || nc2y < 0) ||(nc2x >= m || nc2x < 0))){
                    // System.out.println(nc1y + " " + nc1x + " " + nc2y + " " + nc2x + " return");
                    System.out.println(pcnt);
                    return;
                }
                if(arr[nc1y][nc1x] == '#'){
                    nc1y = c1y;
                    nc1x = c1x;
                }
                if(arr[nc2y][nc2x] == '#'){
                    nc2y = c2y;
                    nc2x = c2x;
                }
                if(visited[nc1y][nc1x][nc2y][nc2x]) continue;
                visited[nc1y][nc1x][nc2y][nc2x] = true;
                List<Integer> next = new ArrayList<>();
                next.add(nc1y);
                next.add(nc1x);
                next.add(nc2y);
                next.add(nc2x);
                pos.add(next);
                cnts.add(pcnt+1);

            }
        }
        System.out.println(-1);
    }
}
