import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        Vector<Word> w = new Vector<Word>();
        for(int i = 0; i < n; i++){
            String a = br.readLine();
            if(a.length() < m) continue;
            if(!map.containsKey(a)){
                map.put(a, 1);
                w.add(new Word(a, 1));
            } else {
                int tmp = map.get(a);
                map.replace(a,tmp+1);
            }
        }
        for(int i = 0; i < w.size(); i++){
            w.elementAt(i).cnt = map.get(w.elementAt(i).a);
        }
        Collections.sort(w,new WordCompator());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < w.size();i++){
            bw.write(w.elementAt(i).a + "\n");
        }
        bw.flush();
        bw.close();
    }
}
class Word{
    String a;
    int cnt;
    public Word(String a, int cnt){
        this.a = a;
        this.cnt = cnt;
    }
}
class WordCompator implements Comparator{
    public int compare(Object arg1, Object arg2){
        if(((Word)arg1).cnt != ((Word)arg2).cnt) return ((Word)arg1).cnt > ((Word)arg2).cnt ? -1:1;
        else if(((Word)arg1).a.length()!= ((Word)arg2).a.length()) return ((Word)arg1).a.length() < ((Word)arg2).a.length()?1:-1;
        else return ((Word)arg1).a.compareTo(((Word)arg2).a) > 0?1:-1;
    }
}
