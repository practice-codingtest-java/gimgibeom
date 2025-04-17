import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        String[] words2 = new String[n];
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            words[i] = br.readLine();
            words2[i] = words[i];
            if(!hashMap.containsKey(words[i])){
                hashMap.put(words[i],i);
            }
        }
        Arrays.sort(words2);
        int maxlen = 0;
        int index1 = 1000, index2 = 1000;
        for(int i = 0; i < n-1; i++){
            if(words2[i] == words2[i+1]) continue;
            int t = i+1;
            while(t < n &&maxlen <= words2[i].length() && maxlen <= words2[t].length() && (maxlen == 0  || (maxlen > 0 && words2[i].charAt(maxlen-1) == words2[t].charAt(maxlen-1)))){
            int prefixlen = 0;
            if(words2[i] == words2[i+1]) continue;
            int wordindex =  hashMap.get(words2[i]);
            int wordindex2 = hashMap.get(words2[t]);
            int bigindex,smallindex;
            if(wordindex>wordindex2){
                bigindex = wordindex;
                smallindex = wordindex2;
            } else {
                bigindex = wordindex2;
                smallindex = wordindex;
            }
            if(words2[i].length() >= words2[t].length()){
                for(int j = 0; j < words2[t].length();j++){
                    if(words2[i].charAt(j) == words2[t].charAt(j)) prefixlen++;
                    else break;
                }
            } else {
                for(int j = 0; j < words2[i].length();j++){
                    if(words2[i].charAt(j) == words2[t].charAt(j)) prefixlen++;
                    else break;
                }
            }
            if(prefixlen > maxlen){
                maxlen = prefixlen;
                index1 = smallindex;
                index2 = bigindex;
            } else if(prefixlen == maxlen){
                if(index1 > smallindex){
                    index1 = smallindex;
                    index2 = bigindex;
                } else if(index1 == smallindex){
                    if(index2 > bigindex){
                        index2 = bigindex;
                    }
                }
            }
            t++;
        }
        }
        System.out.println(words[index1]);
        System.out.println(words[index2]);
    }
}

