import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][][][] visited = new boolean[n][m][n][m];
        int[][] arr = new int[n][m];
        int[] sx = {0,0};
        int[] sy = {0,0};
        for(int i = 0; i < n; i++){
            String a = br.readLine();
            for(int j = 0; j < m; j++){
                if(a.charAt(j) == '#'){
                    arr[i][j] = 1;
                } else if(a.charAt(j) == '.'){
                    arr[i][j] = 0;
                } else if(a.charAt(j) == 'R'){
                    arr[i][j] = 2;
                    sx[0] = j;
                    sy[0] = i;
                } else if(a.charAt(j) == 'B'){
                    arr[i][j] = 3;
                    sx[1] = j;
                    sy[1] = i;
                } else {
                    arr[i][j] = 4;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        visited[sy[0]][sx[0]][sy[1]][sx[1]] = true;
        List<Integer> l = new ArrayList<>();
        l.add(sy[0]); l.add(sx[0]); l.add(sy[1]); l.add(sx[1]);
        Queue<List<Integer>> balls = new ArrayDeque<>();
        Queue<Integer> cnts = new ArrayDeque<>();
        balls.add(l);
        cnts.add(0);
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        while(!balls.isEmpty()){
            List<Integer> pball = balls.poll();
            int ry = pball.get(0);
            int rx = pball.get(1);
            int by = pball.get(2);
            int bx = pball.get(3);
        }
    }   
}
