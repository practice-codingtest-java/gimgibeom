import java.util.*;
import java.io.*;
//bfs + combination? -> 시간초과 나겠는데? n^2 * nCk 이면 못해도 n^3 이면 거의 10초.. 흠
//최대 가능한게? n^2 * logN 
//일단 1이 어디 있는지는 알아야겠고 시작점이랑 끝점은 나와있고 흠 심지어 낮 밤? -> 일단 이거는 나중에 이게 어렵지는 않을것 같고
public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int[][] days;
    static int[][] breakcp;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        days = new int[n+1][m+1];
        breakcp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            String tmp = br.readLine();
            for(int j = 1; j <= m; j++){
                arr[i][j] = tmp.charAt(j-1) - '0';
            }
        }
        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> y = new ArrayDeque<>();
        Queue<Integer> cnts = new ArrayDeque<>();
        Queue<Integer> breaked = new ArrayDeque<>();
        x.add(1);
        y.add(1);
        cnts.add(1);
        breaked.add(0);
        days[1][1] = 1;
        breakcp[1][1] = 0;
        int ans = -1;
        while(!x.isEmpty()){
            int px = x.poll();
            int py = y.poll();
            int pcnt = cnts.poll();
            if(px == m && py == n){
                if(ans == -1) {
                    ans = pcnt;
                } else if (ans > pcnt){
                    ans = pcnt;
                }
                continue;
            }
            int pbreaks = breaked.poll();
            // System.out.println("py: "+py+" px: "+px+" pcnt: "+pcnt+" pbreak: "+pbreaks);
            // Thread.sleep(500);
            for(int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx > 0 && ny > 0 && ny <= n && nx <= m){
                    if(days[ny][nx] != 0 && days[ny][nx] <= pcnt+1 && breakcp[ny][nx] != 0 && breakcp[ny][nx] <= pbreaks) continue;
                    if(arr[ny][nx] == 1 && pbreaks < k){
                        if((pcnt%2) == 1){
                            if(days[ny][nx] == 0 || (days[ny][nx] != 0 && breakcp[ny][nx] != 0 && days[ny][nx] > pcnt+1 && breakcp[ny][nx] > pbreaks+1)){
                                days[ny][nx] = pcnt+1;
                                breakcp[ny][nx] = pbreaks;
                                cnts.add(pcnt+1);
                                breaked.add(pbreaks+1);
                                x.add(nx);
                                y.add(ny);
                            } else if(days[ny][nx] != 0 && days[ny][nx] > pcnt+1){
                                days[ny][nx] = pcnt+1;
                                breakcp[ny][nx] = pbreaks+1;
                                cnts.add(pcnt+1);
                                breaked.add(pbreaks);
                                x.add(nx);
                                y.add(ny);
                            } else if(breakcp[ny][nx] != 0 && breakcp[ny][nx] > pbreaks+1){
                                days[ny][nx] = pcnt+1;
                                breakcp[ny][nx] = pbreaks;
                                cnts.add(pcnt+1);
                                breaked.add(pbreaks);
                                x.add(nx);
                                y.add(ny);
                            }
                        } else {
                            if(days[ny][nx] == 0 || (days[ny][nx] != 0 && breakcp[ny][nx] != 0 && days[ny][nx] > pcnt+2 && breakcp[ny][nx] > pbreaks+1)){
                                days[ny][nx] = pcnt+2;
                                breakcp[ny][nx] = pbreaks;
                                cnts.add(pcnt+2);
                                breaked.add(pbreaks+1);
                                x.add(nx);
                                y.add(ny);
                            } else if(days[ny][nx] != 0 && days[ny][nx] > pcnt+2){
                                days[ny][nx] = pcnt+2;
                                breakcp[ny][nx] = pbreaks+1;
                                cnts.add(pcnt+2);
                                breaked.add(pbreaks);
                                x.add(nx);
                                y.add(ny);
                            } else if(breakcp[ny][nx] != 0 && breakcp[ny][nx] > pbreaks+1){
                                days[ny][nx] = pcnt+2;
                                breakcp[ny][nx] = pbreaks;
                                cnts.add(pcnt+2);
                                breaked.add(pbreaks);
                                x.add(nx);
                                y.add(ny);
                            }
                        }
                    } else if(arr[ny][nx] == 0){
                        if(days[ny][nx] == 0 || (days[ny][nx] != 0 && breakcp[ny][nx] != 0 && days[ny][nx] > pcnt+1 && breakcp[ny][nx] > pbreaks)){
                            days[ny][nx] = pcnt+1;
                            breakcp[ny][nx] = pbreaks;
                            cnts.add(pcnt+1);
                            breaked.add(pbreaks);
                            x.add(nx);
                            y.add(ny);
                        } else if(days[ny][nx] != 0 && days[ny][nx] > pcnt+1){
                            days[ny][nx] = pcnt+1;
                            breakcp[ny][nx] = pbreaks;
                            cnts.add(pcnt+1);
                            breaked.add(pbreaks);
                            x.add(nx);
                            y.add(ny);
                        } else if(breakcp[ny][nx] != 0 && breakcp[ny][nx] > pbreaks){
                            days[ny][nx] = pcnt+1;
                            breakcp[ny][nx] = pbreaks;
                            cnts.add(pcnt+1);
                            breaked.add(pbreaks);
                            x.add(nx);
                            y.add(ny);
                        }
                        
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
