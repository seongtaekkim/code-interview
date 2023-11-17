package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1018 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 *
 * 기본 템플릿을 만들어 브루트포스로 비교하여 최소치를 출력함
 */
public class _23_1018 {
    static char[][] WHITE = new char[8][8];
    static char[][] BLACK = new char[8][8];
    static {
        // 비교할 템플릿 맵 생성
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0)
                    WHITE[i][j] = (j % 2 == 0) ? 'W' : 'B';
                else
                    WHITE[i][j] = (j % 2 == 1) ? 'W' : 'B';
            }
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0)
                    BLACK[i][j] = (j % 2 == 0) ? 'B' : 'W';
                else
                    BLACK[i][j] = (j % 2 == 1) ? 'B' : 'W';
            }
    }

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] mapSize = br.readLine().split(" ");
            int M = Integer.parseInt(mapSize[0]);
            int N = Integer.parseInt(mapSize[1]);
            char[][] map = new char[M][];
            for (int i=0 ; i<M ; i++)
                map[i] = br.readLine().toCharArray();

            // 한칸씩 이동하며 템플릿과 비교
            int min = 64;
            int cntB;
            int cntW;
            for (int i=0 ; i<M-7 ; i++) {
                for (int j=0; j<N-7 ; j++) {
                    cntB = 0; cntW = 0;
                    for (int k=0 ; k<8 ; k++)
                        for (int l=0 ; l<8 ; l++) {
                            if (WHITE[k][l] != map[i+k][j+l]) cntW++;
                            if (BLACK[k][l] != map[i+k][j+l]) cntB++;
                        }
                    if (min > cntB) min = cntB;
                    if (min > cntW) min = cntW;
                }
            }
            System.out.println(min);
        } catch (IOException e) {
            // TODO
        }
    }
}
