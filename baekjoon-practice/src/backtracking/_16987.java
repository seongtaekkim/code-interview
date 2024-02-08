package backtracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 16987 계란으로 계란치기
 * https://www.acmicpc.net/problem/16987
 */
public class _16987 {
    public static int N;
    public static int answer = 0;
    public static int[][] EGGS;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        EGGS = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            EGGS[i][0] = Integer.parseInt(st.nextToken());
            EGGS[i][1] = Integer.parseInt(st.nextToken());
        }

        simulate(0);
        System.out.println(answer);
    }

    public static void simulate(int nowIdx) {

        int max = 0;
        for(int i=0;i<N;i++) {
            if(EGGS[i][0] <= 0) {
                max += 1;
            }
        }
        answer = Math.max(answer,  max);

        if(nowIdx == N) {

            return ;
        }
        if(EGGS[nowIdx][0] > 0) {
            for(int i=0; i<N;i++) {
                if(i == nowIdx) continue;
                if(EGGS[i][0] <= 0) continue;

                EGGS[nowIdx][0] -= EGGS[i][1];
                EGGS[i][0] -= EGGS[nowIdx][1];

                simulate(nowIdx + 1);

                EGGS[nowIdx][0] += EGGS[i][1];
                EGGS[i][0] += EGGS[nowIdx][1];
            }
        }else {
            simulate(nowIdx + 1);
        }



    }
}
