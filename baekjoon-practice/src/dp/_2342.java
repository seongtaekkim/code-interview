package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2342 Dance Dance Revolution
 * https://www.acmicpc.net/problem/2342
 */
public class _2342 {

    // [명령어][왼발위치][오른발위치]
    static int[][][] dp;
    static List<Integer> inList;

    // 현재발판[]에서 다음발판[][] 으로의 비용
    static int[][] weight = {
            {1, 2, 2, 2, 2},
            {0, 1, 3, 4, 3},
            {0, 3, 1, 3, 4},
            {0, 4, 3, 1, 3},
            {0, 3, 4, 3, 1}
    };
    public static void main(String[] args) {

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            inList = new ArrayList<>();
            while (true) {
                int in = Integer.parseInt(st.nextToken());
                if (in == 0) break ;
                inList.add(in);
            }
            dp = new int[inList.size()][5][5];

            System.out.println(calc(0, 0, 0));

        } catch (IOException e) {
            // TODO
        }
    }

    private static int calc(int idx, int left, int right) {

        if (idx == inList.size()) return 0;

        if (dp[idx][left][right] != 0) return dp[idx][left][right] ;

        int next = inList.get(idx);

        dp[idx][left][right] = Math.min(calc(idx+1, next, right) + weight[left][next] // 왼발로 다음 발판 밟기
                                        ,calc(idx+1, left, next) + weight[right][next] ); // 오른발로 다음 발판 밟기
        return dp[idx][left][right];
    }
}
