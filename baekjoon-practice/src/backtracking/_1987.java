package backtracking;

import java.io.*;

/**
 * 1987 알파벳
 * https://www.acmicpc.net/problem/1987
 *
 * 깊은탐색 + 백트래킹
 * 1.(0,0) 부터 시작해서, 상하좌우로 이동을 하는 좌표에서 이 전에 지나온 알파벳은 지나갈 수 없다.
 * 2.map 배열에 [R][C] 크기의 알파벳을 입력하여 2차원 배열을 생성한다.
 * 3.(0,0)부터 DFS로 map전체를 탐색하면서 visit 배열을 1차원 배열로 선언하여 중복된 알파벳을 방문하였는지 판단한다.
 * 4.중복된 알파벳이 있으면, 거리갱신 후 리턴
 * 5.다른 루트로 DFS 탐색하기 위해 visit 배열 false
 */
public class _1987 {

    static int ROW , COL;

    static int ret = 0;
    static void DFS(int M[][], int row, int col,
                    boolean visited[], int cnt) {

        if (visited[M[row][col]]) {
            ret = Math.max(ret, cnt);
            return ;
        }

        int rowNbr[] = new int[] {-1, 0, 0, 1};
        int colNbr[] = new int[] {0, -1, 1, 0};
        visited[M[row][col]] = true;
        for (int k = 0; k < 4; ++k) {
            if (row+ rowNbr[k] >= 0 && row+ rowNbr[k] < ROW && col+ colNbr[k] >= 0 && col+ colNbr[k] < COL) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, cnt+1);
            }
        }
        visited[M[row][col]] = false;
    }

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            ROW = Integer.parseInt(line[0]);
            COL = Integer.parseInt(line[1]);

            int[][] mat = new int[ROW][COL];
            for (int i=0 ;i<ROW ; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j=0; j<charArray.length ; j++)
                    mat[i][j] = charArray[j] - 'A';
            }
            boolean visited[] = new boolean[26];
            if (ROW == 1 && COL == 1) {
                System.out.println(1);
                return ;
            }
            DFS(mat, 0, 0, visited, 0);
            System.out.println(ret);
        } catch (IOException e) {
            // TODO
        }

    }

}
/*
2 2
AB
CD

10 10
ASWERHGCFH
QWERHDLKDG
ZKFOWOHKRK
SALTPWOKSS
BMDLKLKDKF
ALSKEMFLFQ
GMHMBPTIYU
DMNKJZKQLF
HKFKGLKEOL
OTOJKNKRMW


* */
