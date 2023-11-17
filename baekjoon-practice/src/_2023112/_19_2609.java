package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2609 최대공약수와 최소공배수
 * https://www.acmicpc.net/problem/2609
 */
public class _19_2609 {
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String read = br.readLine();
            String[] nums = read.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            System.out.println(gcd(a, b));
            System.out.println(lcm(a, b));
        } catch (IOException e) {
            //TODO
        }
    }
}
