package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9251 LCS
 * https://www.acmicpc.net/problem/9251
 *
 * 재귀는 TOP-DOWN 방식
 *
 */
public class _9251 {

    static char[] charArr1;
    static char[] charArr2;
    static Integer[][] dp;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            charArr1 = br.readLine().toCharArray();
            charArr2 = br.readLine().toCharArray();
            dp = new Integer[charArr1.length][charArr2.length];
            System.out.println(lcs(charArr1.length-1, charArr2.length-1));
        } catch (IOException e) {
            // TODO
        }
    }

    public static int lcs(int a, int b) {

        if (a<0 || b<0) return 0;

        if (dp[a][b] == null) {
            dp[a][b] = 0;
            if(charArr1[a] == charArr2[b])
                dp[a][b] = lcs(a-1, b-1) + 1;
            else
                dp[a][b] = Math.max(lcs(a-1,b), lcs(a,b-1));
        }

        return dp[a][b];
    }
}
