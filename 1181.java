import java.util.*;
import java.io.*;




public class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Vector<String> a = new Vector<>();
        for(int i = 0; i < n; i++){
            
            String tmp = br.readLine();
            a.add(tmp);
        }
        Collections.sort(a,new stringComparator());
        System.out.println(a.elementAt(0));
        for(int i = 1; i < a.size(); i++){
            if(a.elementAt(i).compareTo(a.elementAt(i-1)) == 0) continue;
            System.out.println(a.elementAt(i));
        }
    }

    
}
class stringComparator implements Comparator<String>{
    public int compare(String str1, String str2){
        if(str1.length() == str2.length()){
            return str1.compareTo(str2) < 0 ? -1 :1;
        }
        else return str1.length() < str2.length() ? -1 : 1;
    }
}