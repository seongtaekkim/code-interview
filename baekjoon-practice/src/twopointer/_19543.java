package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 19543 던전 지도
 * https://www.acmicpc.net/problem/19543
 *
 *
 * 200000 개의 행과 200000 개의 열이 주어질 수 있기 때문에 일반적인 탐색 알고리즘을 사용하면
 * 당연히 시간 초과가 나는 문제이다.
 *
 * 따라서 투 포인터를 이용해 200000개의 행만 탐색함으로써 O(n) 만에 풀이할 수 있다.
 * 투 포인터의 구간 = 현재 행에서 보스 방으로 갈 수 있는 구간
 *
 * 왼쪽(LP), 오른쪽(RP) 포인터를 다음과 같이 정의한다.(오른쪽부터 탐색했을 때 - 보스방이 오른쪽 위이므로)
 *
 * LP = 이전 LP 에서 다음 U 가 나오기 바로 전의 인덱스
 * RP = 이전 RP 에서 다음 번 U의 인덱스(그대로 내려올 수도 있다.)
 *
 * 보스 방에서부터 구간을 차례대로 내려오면 구간이 계단 모양 혹은 그대로 내려오게 되는데,
 * 매번 해당 구간의 수를 세어주면 된다.
 *
 * 매 행마다 U를 찾으면 시간 초과가 나므로 미리 26가지의 행에 대해 U의 next 인덱스 정보를 전처리 해 주어야 한다.
 */
public class _19543 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int[][] nextU = new int[26][200001];

            String[] in1 = br.readLine().split(" ");
            int N = Integer.parseInt(in1[0]);
            int M = Integer.parseInt(in1[1]);
            int K = Integer.parseInt(in1[2]);

            for (int i=0; i<K ; i++) {
                char[] charArray = br.readLine().toCharArray();
                int prevU = -1;
                for (int j=0; j<charArray.length ; j++) {
                    if (charArray[j] == 'U') {
                        prevU = j;
                    }
                    nextU[i][j] = prevU; //현재 idx에서 다음 번 U의 idx
                }
            }

            char[] order = br.readLine().toCharArray();
            int left = 0;

            if(M > 1)
                left = nextU[order[N - 1] - 'A'][M - 2] + 1;

            int right = M - 1;

            long ans = right - left + 1;

            for (int i = N - 2; i >= 0; i--) {
                int nowRow = order[i] - 'A';

                right = nextU[nowRow][right];
                if(left > 0)
                    left = nextU[nowRow][left - 1] + 1;
                if (right < left) break; // 다음맵이 없으면 탈출
                ans += (right - left + 1);
            }
            System.out.println(ans);
        } catch (IOException e) {
            // TODO
        }
    }
}
