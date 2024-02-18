package twopointer;

import java.io.IOException;

/**
 * 1644 소수의 연속합
 * https://www.acmicpc.net/problem/1644
 */
public class _1644 {

    // 123456 * 2 + 1
    public static boolean[] prime = new boolean[8000001];

    public static void main(String[] args) throws IOException {

        get_prime();
        int n = readInt();
        int left =0;
        int right=0;
        int sum =0;
        int cnt=0;
        while (right <= n) {
            if (sum >= n) {
                if (sum == n)
                    cnt++;
                left = nextPrime(left+1);
                sum -= left;
            } else {
                right = nextPrime(right+1);
                sum += right;
            }
        }
        System.out.println(cnt);
    }

    private static int nextPrime(int i) {
        while (prime[i])
            i++;
        return i;
    }

    public static void get_prime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    static int readInt() throws IOException {
        int sum = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return isNegative ? sum * -1 : sum;
            else if (input == '-')
                isNegative = true;
            else
                sum = (sum * 10) + input - '0';
        }
    }
}
