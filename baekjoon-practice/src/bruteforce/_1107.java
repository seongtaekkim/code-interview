package bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 1108 리모컨
 * https://www.acmicpc.net/problem/1108
 */
public class _1107 {

    static long cnt=0;
    static int N;
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws Exception {

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine()); // 목표번호
            int brokenNum = Integer.parseInt(br.readLine()); // 망가진 번호 개수
            if (brokenNum != 0) {
                String[] s = br.readLine().split(" ");
                for (int i = 0; i < brokenNum; i++)
                    broken[Integer.parseInt(s[i])] = true;
            }
            if (N == 100) {
                System.out.println(0);
                return ;
            }
            cnt = Math.abs(N - 100);
            dfs(0, 0);
            System.out.println(cnt);
        } catch (IOException e) {
            // TODO
        }

    }

    static void dfs(int channel, int disit) {
        long count;
        for (int i=0 ; i<10 ; i++) {
            if (!broken[i]) {
                int newChannel = i + 10 * channel;
                count = Math.abs(N - newChannel) + String.valueOf(newChannel).length();
                cnt = Math.min(cnt, count);

                if (disit <= 6)
                    dfs(newChannel, disit+1);
            }
        }
    }
}
