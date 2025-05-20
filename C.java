import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int[][] visited = new int[maps.length][maps[0].length()];
        int sy = -1,sx = -1;
        int ly = -1,lx = -1;
        int ey = -1,ex = -1;
        Queue<Integer> y = new ArrayDeque<>();
        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> cnts = new ArrayDeque<>();
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    sy = i;
                    sx = j;
                } else if(maps[i].charAt(j) == 'L'){
                    ly = i;
                    lx = j;
                } else if(maps[i].charAt(j) == 'X'){
                    visited[i][j] = 1;
                } else if(maps[i].charAt(j) == 'E'){
                    ey = i;
                    ex = j;
                }
            }
        }
            y.add(sy);
            x.add(sx);
            cnts.add(0);
            visited[sy][sx] = 1;
            int dy[] = {1,-1,0,0};
            int dx[] = {0,0,1,-1};
            int lcnt = 0;
            while(!y.isEmpty()){
                int py = y.poll();
                int px = x.poll();
                int pcnt = cnts.poll();
                if(py == ly && px == lx) {
                    lcnt = pcnt;
                    break;
                }
                for(int i = 0; i < 4; i++){
                    int ny = py+dy[i];
                    int nx = px+dx[i];
                    if(ny>=0 && nx >= 0 && ny < maps.length && nx < maps[0].length() && visited[ny][nx] == 0){
                        y.add(ny);
                        x.add(nx);
                        cnts.add(pcnt+1);
                        visited[ny][nx] = 1;
                    }
                }
            }
            y.clear();
            x.clear();
            cnts.clear();
            for(int i = 0; i < maps.length; i++){
                for(int j = 0; j < maps[0].length(); j++){
                    if(maps[i].charAt(j) == 'O') visited[i][j] = 0;
                }
            }
            x.add(lx);
            y.add(ly);
            cnts.add(lcnt);
            visited[ly][lx] = 1;
            int ans = -1;
            while(!y.isEmpty()){
                int py = y.poll();
                int px = x.poll();
                int pcnt = cnts.poll();
                if(py == ey && px == ex) {
                    ans = pcnt;
                    break;
                }
                for(int i = 0; i < 4; i++){
                    int ny = py+dy[i];
                    int nx = px+dx[i];
                    if(ny>=0 && nx >= 0 && ny < maps.length && nx < maps[0].length() && visited[ny][nx] == 0){
                        y.add(ny);
                        x.add(nx);
                        cnts.add(pcnt+1);
                        visited[ny][nx] = 1;
                    }
                }
            }
        return ans;
    }
}