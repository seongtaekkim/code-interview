package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10986 나머지 합
 * https://www.acmicpc.net/problem/10986
 *
 * 구간 합(S[j]-S[i-1])를 M으로 나누었을 때 나머지가 0이 되는 (i,j) 쌍의 개수 계산
 */
public class _10986 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] in = br.readLine().split(" ");
            int N = Integer.parseInt(in[0]);
            int M = Integer.parseInt(in[1]);
            long result = 0;
            long[] S = new long[N + 1];
            long[] cnt = new long[M];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
                if(S[i] == 0) {
                    result++;
                }
                cnt[(int) S[i]]++;
            }

            for(int i=0; i<M; i++) {
                if(cnt[i] > 1) {
                    result += (cnt[i]* (cnt[i]-1) / 2);
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            // TODO
        }
    }
}
