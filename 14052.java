import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n;
    static int m;
    public static void bfs(int starty,int startx, int[][]visited, int[][] map){
        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qx = new LinkedList<>();
        qy.add(starty);
        qx.add(startx);
        while(!qx.isEmpty() && ! qy.isEmpty()){
            int py = qy.poll();
            int px = qx.poll();
            for(int i = 0; i < 4; i++){
                int ny = py + dy[i];
                int nx = px + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && visited[ny][nx] == 0 && map[ny][nx] == 0){
                    map[ny][nx] = 2;
                    visited[ny][nx] = 1;
                    qy.add(ny);
                    qx.add(nx);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];
        int zeros = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) visited[i][j] = 1;
                if(map[i][j] == 0) zeros++;
            }
        }
        int[] zerox = new int[zeros];
        int[] zeroy = new int[zeros];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    zeroy[index] = i;
                    zerox[index] = j;
                    index++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < zeros-2; i++){
            for(int j = i+1; j <zeros-1;j++){
                for(int k = j+1; k < zeros; k++){
                    int[][] newMap = new int[n][m];
                    int[][] newVisited = new int[n][m];
                    for(int l = 0; l < n; l++){
                        for(int o = 0; o < m; o++){
                            newMap[l][o] = map[l][o];
                            newVisited[l][o] = visited[l][o];
                        }
                    }
                    int cnt = 0;
                    newMap[zeroy[i]][zerox[i]] = 1;
                    newMap[zeroy[j]][zerox[j]] = 1;
                    newMap[zeroy[k]][zerox[k]] = 1;
                    newVisited[zeroy[i]][zerox[i]] = 1;
                    newVisited[zeroy[j]][zerox[j]] = 1;
                    newVisited[zeroy[k]][zerox[k]] = 1;
                    for(int l = 0; l < n; l++){
                        for(int o = 0; o < m; o++){
                            if(newMap[l][o] == 2 && newVisited[l][o] == 0){
                                newVisited[l][o] = 1;
                                bfs(l,o,newVisited,newMap);
                            }
                        }
                    }
                    for(int l = 0; l < n; l++){
                        for(int o = 0; o < m; o++){
                            System.out.print(newMap[l][o]+ " ");
                            if(newMap[l][o] == 0) cnt++;
                        }
                        System.out.println();
                    }
                    System.out.println();
                    if(cnt > ans) ans = cnt;
                }
            }
        }
        System.out.println(ans);
    }
}
