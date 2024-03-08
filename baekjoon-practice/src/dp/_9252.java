package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9252 LCS2
 * https://www.acmicpc.net/problem/9251
 *
 * Bottom-up 방식
 *
 */
public class _9252 {

    static char[] charArr1;
    static char[] charArr2;
    static Integer[][] dp;


    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            charArr1 = br.readLine().toCharArray();
            charArr2 = br.readLine().toCharArray();
            dp = new Integer[charArr1.length][charArr2.length];

            int[][] dp = new int[charArr1.length+1][charArr2.length+1];

            for(int i=0;i<charArr1.length;i++)
                for(int j=0;j<charArr2.length;j++)
                    dp[i+1][j+1] = (charArr1[i] == charArr2[j]) ? dp[i][j]+1 : Math.max(dp[i+1][j],dp[i][j+1]);

            StringBuilder answer = new StringBuilder();
            int i = charArr1.length;
            int j = charArr2.length;
            while(i>=1 && j>=1){
                if(dp[i][j] == dp[i-1][j])
                    i--;
                else if(dp[i][j] == dp[i][j-1])
                    j--;
                else {
                    answer.insert(0, charArr2[j - 1]);
                    i--; j--;
                }
            }

            System.out.println(answer.length());
            System.out.println(answer);
        } catch (IOException e) {
            // TODO
        }
    }
}
