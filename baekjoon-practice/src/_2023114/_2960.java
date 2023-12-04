package _2023114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2960 에라토스테네스의 체
 * https://www.acmicpc.net/problem/2960
 */
public class _2960 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);

            boolean[] arr = new boolean[N + 1];
            int cnt =0;
            for (int i=2 ; i<=N ; i++) {
                for (int j=i ; j <= N ; j+=i) {

                    if (!arr[j]) {
                       cnt++;
                       arr[j] = true;
                    }
                    if (cnt == K) {
                        System.out.println(j);
                        return ;
                    }
                }
            }
        } catch (IOException e) {
            // TODO
        }
    }
}
