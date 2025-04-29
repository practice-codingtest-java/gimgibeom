import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] board = new int[52][52];
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                } else if (board[i][j] == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }

        int[] permutation = new int[chicken.size()];
        for (int i = chicken.size() - m; i < chicken.size(); i++) {
            permutation[i] = 1;
        }

        do {
            int dist = 0;

            for (int[] h : home) {
                int minDist = Integer.MAX_VALUE;

                for (int i = 0; i < chicken.size(); i++) {
                    if (permutation[i] == 1) {
                        int[] c = chicken.get(i);
                        int cur = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
                        minDist = Math.min(minDist, cur);
                    }
                }

                dist += minDist;
            }

            answer = Math.min(answer, dist);

        } while (nextPermutation(permutation));

        System.out.println(answer);
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i <= 0) return false;

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) j--;

        // swap
        int tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;

        // reverse
        j = arr.length - 1;
        while (i < j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }

        return true;
    }
}
