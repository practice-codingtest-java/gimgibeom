import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }//여기까지는 뭐 할 거 없음
            
            int cycleIndex[] = new int[n+1];
            int[]visited = new int[n+1];
            for(int i = 1; i <=n; i++){
                if(cycleIndex[i] == 1 || cycleIndex[i] == -1) continue;
                HashMap<Integer,Integer> hm = new HashMap<>();
                List<Integer> l = new ArrayList<>();
                int now = i;
                int index = 0;
                l.add(i);
                hm.put(i, index);
                int endindex = -1;
                int hascycle = 0;
                while(visited[now] != 1){
                    visited[now] = 1;
                    if(cycleIndex[arr[now]] != 0){
                        cycleIndex[now] = -1;
                        break;
                    }
                    index++;
                    if(arr[now] == i){
                        for(int j = 0; j < l.size(); j++){
                            cycleIndex[l.get(j)] = 1;
                        }
                        break;
                    }
                    if(arr[now] == now){
                        for(int j = 0; j < l.size()-1; j++){
                            cycleIndex[l.get(j)] = -1;
                        }
                        cycleIndex[now] = 1;
                        break;
                    }
                    now = arr[now];
                    if(hm.containsKey(now)){
                        hascycle = 1;
                        endindex = index;
                        index = hm.get(now);
                        break;
                    } else {
                        hm.put(now, index);
                    }
                    l.add(now);
                }
                if(hascycle == 1){
                    for(int j = index; j < endindex; j++){
                        cycleIndex[l.get(j)] = 1;
                    }
                }
            }
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(cycleIndex[j] == 0 || cycleIndex[j] == -1){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
