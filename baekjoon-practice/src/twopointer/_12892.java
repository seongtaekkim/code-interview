package twopointer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 12892 생일 선물
 * https://www.acmicpc.net/problem/12892
 */
public class _12892 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tk = null;

    static int N, D;
    static Gift[] gifts;
    static long ans;

    public static void main(String[] args) throws Exception {
        tk = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(tk.nextToken());
        D = Integer.parseInt(tk.nextToken());

        gifts = new Gift[N];
        for (int i=0; i<N; i++) {
            tk = new StringTokenizer(rd.readLine());
            int p = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            gifts[i] = new Gift(p, v);
        }

        Arrays.sort(gifts);

        long sum = 0;
        int p=0;	// inclusive
        int q=0;	// exclusive
        ans = sum;

        while (true) {
            while (q < N && gifts[q].p - gifts[p].p < D) {
                sum += gifts[q].v;
                q++;
            }
            ans = Math.max(ans, sum);
            if (q == N) break;

            sum -= gifts[p].v;
            p++;
        }

        System.out.println(ans);
    }

    static class Gift implements Comparable<Gift>{
        int p, v;
        Gift(int p, int v) {
            this.p = p;
            this.v = v;
        }
        @Override
        public int compareTo(Gift o) {
            return Integer.compare(this.p, o.p);
        }
    }
}
