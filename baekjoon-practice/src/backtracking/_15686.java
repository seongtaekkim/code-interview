package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15686 치킨 배달
 * https://www.acmicpc.net/problem/15686
 *
 * 1. LinkedList 타입 house, chichen 을 만들어 좌표 {i,j}를 담는다.
 * 2. chichen 개수 중 M 개만큼의 조합을 구한다 (백트래킹)
 * 3. 조합의 요소마다 모든 house 에서 M개만큼의 치킨집으로의 최단거리를 구해서 더한다.
 * 4. 3의 결과를 전역변수에 넣고, 모든 조합을 수행한 후 가장작은 값을 출력한다.
 */
public class _15686 {
    public static int[] arr;
    public static int[][] map;
    public static StringBuilder sb;

    static List<int[]> house;
    static List<int[]> chichen;
    static int[][] distance;
    static int N,M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            house = new LinkedList<>();
            chichen = new LinkedList<>();
            for (int i=0 ;i<N ; i++) {
                String[] cols = br.readLine().split(" ");
                for (int j=0 ; j< cols.length ; j++) {
                    int tmp = Integer.parseInt(cols[j]);
                    if (tmp == 2)
                        chichen.add(new int[] {i, j});
                    else if (tmp == 1)
                        house.add(new int[] {i, j});
                }
            }
            distance = new int[chichen.size()][2];
            comb(0,0);

            System.out.println(result);
        } catch (IOException e) {
            // TODO
        }
    }
    private static void comb(int cnt, int start) {
        if (cnt == M) {
            diff();
        }

        for (int i=start ; i<chichen.size() ; i++) {
            distance[cnt][0] = chichen.get(i)[0];
            distance[cnt][1] = chichen.get(i)[1];
            comb(cnt+1, i+1);
        }
    }
    private static void diff() {
        int dis=0;

        for (int i=0; i < house.size() ; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j=0; j < M; j++) {
                tmp = Math.min(tmp, Math.abs(distance[j][0] - house.get(i)[0]) + Math.abs(distance[j][1] - house.get(i)[1]));
            }
            dis += tmp;
        }
        result = Math.min(result, dis);
    }

}
