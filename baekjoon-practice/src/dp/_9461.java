package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9461 파도반 수열
 * https://www.acmicpc.net/problem/9461
 */
public class _9461 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            long[] N = new long[101];
            N[0] = -1;
            N[1] = 1;
            N[2] = 1;
            N[3] = 1;
            N[4] = 2;
            N[5] = 2;
            N[6] = 3;
            for (int i=6; i<N.length ; i++) {
                N[i] = N[i-1] + N[i-5];
            }
            int T = Integer.parseInt(br.readLine());
            for (int i=0; i<T ; i++) {
                System.out.println(N[Integer.parseInt(br.readLine())]);
            }
        } catch (IOException e) {
            // TODO
        }
    }
}
