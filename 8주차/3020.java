import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, h;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[] a = new int[h + 2];
        int[] b = new int[h + 2];

        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                a[k]++;
            } else {
                b[h - k + 1]++;
            }
        }

        for (int i = h; i >= 2; i--) {
            a[i - 1] += a[i];
        }

        for (int i = 2; i <= h; i++) {
            b[i] += b[i - 1];
        }

        for (int i = 1; i <= h; i++) {
            a[i] += b[i];
        }

        Arrays.sort(a, 1, h + 1);
        int min = a[1];
        int count = 1;

        for (int i = 2; i <= h; i++) {
            if (a[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
