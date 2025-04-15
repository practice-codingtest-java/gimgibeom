import java.util.*;
import java.io.*;
//입력 200,000개 -> 다 넣고 정렬만 해도 200,000 * log(200000) -> 약 천만으로 계산 -> 가능한데? -> 그러면 넣고 정렬해서 pq로 집어넣어?
//그러면 먼저 리스트 생성인가요? 그게 맞나 근데? 근데 여기는 pair 없잖아..? 
//지금 이 상태에서 넣기 전에 sort만 되면은 될텐데 그지?
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Vector<Conf> v = new Vector<Conf>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Conf tmp = new Conf(start, end);
            v.add(tmp);
        }
        Collections.sort(v, new ConfComparator());
        int cnt = n;
        for(int i = 0; i < n; i++){
            System.out.println(v.elementAt(i).start + " " + v.elementAt(i).end);
            for(int j = 1; j >= 0; j++){

            }
        }
    }
    
}

class Conf {
    int start;
    int end;
    public Conf(int a, int b){
        start = a;
        end = b;
    }
}

class ConfComparator implements Comparator<Conf> {
    public int compare(Conf a, Conf b){
        if(a.start == b.start){
            return a.end-b.end;
        } else return a.start-b.start;
    }
}