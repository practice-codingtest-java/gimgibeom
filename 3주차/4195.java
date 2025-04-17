import java.util.*;
import java.io.*;
//100000*100000은 불가능이고 음..
public class Main {
    static int[] parents;
    static int[] members;
    static int find(int a){
        if(parents[a] == a){
            return a;
        }
        parents[a] = find(parents[a]);
        return parents[a];
    }
    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a==b){
            return;
        }
        parents[b] = a;
        members[a] += members[b];
        members[b] = members[a];
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int f = Integer.parseInt(br.readLine());
            HashMap<String, Integer> fm = new HashMap<>();
            parents = new int[f*2+1];
            members = new int[f*2+1];
            for(int i = 0; i < f*2+1; i++){
                parents[i] = i;
                members[i] = 1;
            }
            int man = 1;
            for(int i = 0; i < f; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                if(!fm.containsKey(a)) {
                    fm.put(a, man);
                    man++;
                }
                String b = st.nextToken();
                if(!fm.containsKey(b)){
                    fm.put(b,man);
                    man++;
                }
                union(fm.get(a),fm.get(b));
                int cnt = 0;
                 System.out.println(members[find(fm.get(a))]);
            }
        }
    }    
}
