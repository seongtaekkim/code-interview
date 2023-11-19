package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1978 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */
public class _26_1978 {

    private static boolean findSosu(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        for (int i=2 ; i<n/2+1 ; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");
            int cnt = 0;
            for (int i =0; i<nums.length ; i++) {
                if (findSosu(Integer.parseInt(nums[i])))
                    cnt++;
            }
            System.out.println(cnt);
        } catch (IOException e) {
            //TODO
        }
    }
}
