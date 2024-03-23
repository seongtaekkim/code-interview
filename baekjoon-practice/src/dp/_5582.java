package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5582 공통 부분 문자열
 * https://www.acmicpc.net/problem/5582
 *
 *
 * ABRACADABRA
 * ECADADABRBCRDARA
 *
 * 1~4000
 */
public class _5582 {

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String str1 = br.readLine();
            String str2 = br.readLine();
            int[][] dp = new int[str1.length()+1][str2.length()+1];
            int ans = 0;

            for(int i = 1 ; i <= str1.length() ; i++){
                for (int j = 1 ; j <= str2.length(); j++){
                    if(str1.charAt(i-1) == str2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            System.out.println(ans);

        } catch (IOException e) {
            // TODO
        }
    }
}
