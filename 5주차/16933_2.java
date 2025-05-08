import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int[][] days;
    static int[][] breakcp;
    static int[][] visited;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
    static class State {
        int x, y, cnt, breaked;
        State(int x, int y, int cnt, int breaked) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breaked = breaked;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n + 1][m + 1];
        days = new int[n + 1][m + 1];
        breakcp = new int[n + 1][m + 1];
        visited = new int[n+1][m+1];
        
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = tmp.charAt(j - 1) - '0';
            }
        }
        
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(1, 1, 1, 0));
        days[1][1] = 1;
        breakcp[1][1] = 0;
        visited[1][1] = 1;
        int ans = -1;
        
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            int px = curr.x;
            int py = curr.y;
            int pcnt = curr.cnt;
            int pbreaks = curr.breaked;
            
            if (px == m && py == n) {
                if (ans == -1) {
                    ans = pcnt;
                } else if (ans > pcnt) {
                    ans = pcnt;
                }
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx > 0 && ny > 0 && ny <= n && nx <= m){
                    if(days[ny][nx] != 0 && days[ny][nx] <= pcnt+1 && breakcp[ny][nx] != 0 && breakcp[ny][nx] <= pbreaks) continue;
                    if(arr[ny][nx] == 1 && pbreaks < k && visited[ny][nx] == 0){
                        if((pcnt%2) == 1){
                            if(days[ny][nx] == 0 || (days[ny][nx] != 0 && breakcp[ny][nx] != 0 && days[ny][nx] > pcnt+1 && breakcp[ny][nx] > pbreaks+1)){
                                days[ny][nx] = pcnt+1;
                                breakcp[ny][nx] = pbreaks+1;
                                queue.add(new State(nx, ny, pcnt+1, pbreaks+1));
                            } else if(days[ny][nx] != 0 && days[ny][nx] > pcnt+1){
                                days[ny][nx] = pcnt+1;
                                breakcp[ny][nx] = pbreaks+1;
                                queue.add(new State(nx, ny, pcnt+1, pbreaks+1));
                            } else if(breakcp[ny][nx] != 0 && breakcp[ny][nx] > pbreaks+1){
                                days[ny][nx] = pcnt+1;
                                breakcp[ny][nx] = pbreaks;
                                queue.add(new State(nx, ny, pcnt+1, pbreaks+1));
                            }
                        } else {
                            if(days[ny][nx] == 0 || (days[ny][nx] != 0 && breakcp[ny][nx] != 0 && days[ny][nx] > pcnt+2 && breakcp[ny][nx] > pbreaks+1)){
                                days[ny][nx] = pcnt+2;
                                breakcp[ny][nx] = pbreaks;
                                queue.add(new State(nx, ny, pcnt+2, pbreaks+1));
                            } else if(days[ny][nx] != 0 && days[ny][nx] > pcnt+2){
                                days[ny][nx] = pcnt+2;
                                breakcp[ny][nx] = pbreaks+1;
                                queue.add(new State(nx, ny, pcnt+2, pbreaks+1));
                            } else if(breakcp[ny][nx] != 0 && breakcp[ny][nx] > pbreaks+1){
                                days[ny][nx] = pcnt+2;
                                breakcp[ny][nx] = pbreaks;
                                queue.add(new State(nx, ny, pcnt+2, pbreaks+1));
                            }
                        }
                    } else if(arr[ny][nx] == 0){
                        if(visited[ny][nx] == 1 && breakcp[ny][nx] > pbreaks) continue;
                        if(days[ny][nx] == 0 || (days[ny][nx] != 0 && breakcp[ny][nx] != 0 && days[ny][nx] > pcnt+1 && breakcp[ny][nx] > pbreaks)){
                            days[ny][nx] = pcnt+1;
                            breakcp[ny][nx] = pbreaks;
                            queue.add(new State(nx, ny, pcnt+1, pbreaks));
                        } else if(days[ny][nx] != 0 && days[ny][nx] > pcnt+1){
                            days[ny][nx] = pcnt+1;
                            breakcp[ny][nx] = pbreaks;
                            queue.add(new State(nx, ny, pcnt+1, pbreaks));
                        } else if(breakcp[ny][nx] != 0 && breakcp[ny][nx] > pbreaks){
                            days[ny][nx] = pcnt+1;
                            breakcp[ny][nx] = pbreaks;
                            queue.add(new State(nx, ny, pcnt+1, pbreaks));
                        }
                        
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}
