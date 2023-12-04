package _2023114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 13241 최소공배수
 * https://www.acmicpc.net/problem/13241
 */
public class _13241 {

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            System.out.println(lcm(Long.parseLong(line[0]), Long.parseLong(line[1])));;
        } catch (IOException e) {
            // TODO
        }
    }
}
