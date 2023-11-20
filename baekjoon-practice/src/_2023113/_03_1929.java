package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1929 소수 구하기
 * https://www.acmicpc.net/problem/1929
 */
public class _03_1929 {

    private static boolean findSosu(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        for (int i=2 ; i<Math.sqrt(n)+1 ; i++ ) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] nums = br.readLine().split(" ");
            int start = Integer.parseInt(nums[0]);
            int end = Integer.parseInt(nums[1]);
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int i=start; i<end+1; i++) {
                if (findSosu(i))
                    sb.append(i + "\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            //TODO
        }
    }
}
