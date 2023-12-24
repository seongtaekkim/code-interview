package _2023123;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2667 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */
public class _2667 {

    static int ROW , COL;
    static List<Integer> ret = new ArrayList<>();

    static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL)
                && (M[row][col] == 1 && !visited[row][col]);
    }

    static int cnt = 0;
    static void DFS(int M[][], int row, int col,
             boolean visited[][]) {
        cnt++;
        int rowNbr[] = new int[] { -1, 0, 0, 1};
        int colNbr[] = new int[] {  0, -1, 1, 0};
        visited[row][col] = true;
        for (int k = 0; k < 4; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    static int countIslands(int M[][]) {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    ++count;
                    ret.add(cnt);
                    cnt =0;
                }

        return count;
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine()); // N*N map

            int[][] mat = new int[N][N];
            COL = N;
            ROW = N;
            for (int i=0 ;i<N ; i++) {
                char[] charArray = br.readLine().toCharArray();
                for (int j=0; j<charArray.length ; j++)
                    mat[i][j] = charArray[j] - '0';
            }
            System.out.println(countIslands(mat));
            Collections.sort(ret);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (Integer i : ret) {
                bw.write(i + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            // TODO
        }

    }

}
