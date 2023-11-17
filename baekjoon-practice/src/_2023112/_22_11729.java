package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11729 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 */
public class _22_11729 {

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    /**
     * 두개의 돌을 목적지로 옮기는 작업을 최소단위로 하였다.
     */
    static void test(int src, int dst, int tmp, int n) {
        if (n == 0) {
            return;
        }
        cnt++;
        test(src, tmp, dst, n - 1); // 가장 아래 돌기둥 이동 전 작업
        sb.append(src + " " + dst + "\n"); // 가장 아래 돌기둥 이동
        test(tmp, dst, src, n -1); // 가장 아래 돌기둥 이동 후 작업
    }


    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            test(1, 3, 2, num);
            System.out.println(cnt);
            System.out.print(sb);
        } catch (IOException e) {
            // TODO
        }
    }
}
