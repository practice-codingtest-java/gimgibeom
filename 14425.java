    import java.util.*;
    import java.io.*;

    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            HashSet<String> hs = new HashSet<>();
            for(int i = 0; i < n; i++){
                hs.add(br.readLine());
            }
            int cnt = 0;
            for(int i = 0; i< m; i++){
                if(hs.contains(br.readLine())){
                    cnt++;
                } 
            }
            System.out.println(cnt);
        }
    }
