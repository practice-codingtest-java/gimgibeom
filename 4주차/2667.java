import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=1;
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            int[][] visited = new int[n][n];
            int dx[] = {1,-1,0,0};
            int dy[] = {0,0,1,-1};
            for(int i = 0; i < n; i++){
                String tmp = br.readLine();
                for(int j = 0; j < n; j++){
                    if(tmp.charAt(j)=='1') arr[i][j] = 1;
                    else arr[i][j] = 0;
                }
            }
            int cnt = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 1 && visited[i][j] == 0){
                        int c2 = 1;
                        cnt++;
                        visited[i][j] = 1;
                        Queue<Integer> y = new LinkedList<>();
                        Queue<Integer> x = new LinkedList<>();
                        y.add(i);
                        x.add(j);
                        while(!x.isEmpty()&&!y.isEmpty()){
                            int py = y.poll();
                            int px = x.poll();
                            for(int r = 0; r < 4; r++){
                                int ny = py + dy[r];
                                int nx = px + dx[r];
                                if(ny>=0 && nx >= 0 && ny<n && nx < n &&visited[ny][nx] == 0 && arr[ny][nx] == 1){
                                    y.add(ny);
                                    x.add(nx);
                                    visited[ny][nx] = 1;
                                    c2++;
                                }
                            }
                        }
                        list.add(c2);
                    }
                }
            }
            System.out.println(cnt);
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
        }
    }
}
