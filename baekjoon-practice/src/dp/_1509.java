package dp;


import java.io.*;

/**
 * 1509 팰린드롬 분할
 * https://www.acmicpc.net/problem/1509
 *
 *
 *
 * dp[i] = min(dp[j-1]) + 1
 */
public class _1509 {

    static boolean[][] palin;
    static int[] dp;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {


            String str = br.readLine();
            palin = new boolean[str.length() + 1][str.length()+1];
            dp = new int[str.length()+1];

            for (int i = 1; i <= str.length(); i++)
                dp[i] = Integer.MAX_VALUE;

            setPalin(str);

            for (int i = 1; i <= str.length(); i++) {
                for (int j = 1; j <= i; j++) {
                    if (palin[j][i])
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }

            System.out.println(dp[str.length()]);
        } catch (IOException e) {
            // TODO
        }


    }

    public static void setPalin(String str) {

        int len = str.length();

        for (int start = 1; start <= len; start++) {
            for (int end = start; end <= len; end++) {
                boolean flag = true;

                int s = start - 1;
                int e = end - 1;
                while (s <= e) {
                    if (str.charAt(s++) != str.charAt(e--)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    palin[start][end] = true;
            }
        }
    }
}
