import java.io.*;
import java.util.*;

public class Main {
    static int fileCnt;
    static List<Folder> folderList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        folderList = new ArrayList<>();
        
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            String P = st.nextToken();
            String F = st.nextToken();
            int C = Integer.parseInt(st.nextToken());

            Folder now = findFolder(P);

            if(now==null){
                now = new Folder(P);
                folderList.add(now);
            }

            if(C==1) {
                Folder folder = findFolder(F);

                if(folder == null){
                    folder = new Folder(F);
                    now.childFolder.add(folder);
                    folderList.add(folder);

                }else now.childFolder.add(folder);
            }
            else if(C==0){ 
                now.childFile.add(F);
            }
        }

        int Q = Integer.parseInt(br.readLine());

        for(int i=0; i<Q; i++){
            fileCnt = 0;
            String[] str = br.readLine().split("/");
            String lastName = "";
            Folder nowFolder = null;

            lastName = str[str.length-1];

            for(int j=0; j<folderList.size(); j++) {
                if (folderList.get(j).name.equals(lastName)) {
                    nowFolder = folderList.get(j);
                    HashSet<String> hs = new HashSet<>();
                    findFile(nowFolder, hs);
                    bw.write(hs.size() + " " + fileCnt + "\n");
                }
            }
        }
        bw.close();
    }
    static Folder findFolder(String P){
        Folder ret = null;
        for(int j=0; j<folderList.size(); j++){
            if(folderList.get(j).name.equals(P)){
                ret = folderList.get(j);
                break;
            }
        }
        return ret;
    }
    static void findFile(Folder folder, HashSet<String> hs) {
        fileCnt += folder.childFile.size();
        hs.addAll(folder.childFile);
        if(folder.childFolder.size()!=0){
            for(Folder f : folder.childFolder)
                findFile(f, hs);
        }
    }

}
class Folder{
    String name;
    List<Folder> childFolder = new ArrayList<>();
    List<String> childFile = new ArrayList<>();
    Folder(String name){
        this.name = name;
    }

}