package _2023123;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1012 유기농 배추
 * https://www.acmicpc.net/problem/1012
 */
public class _1012 {

    static int ROW , COL;

    static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < ROW) && (col >= 0)
                && (col < COL)
                && (M[row][col] == 1 && !visited[row][col]);
    }

    static void DFS(int M[][], int row, int col,
             boolean visited[][]) {
        int rowNbr[] = new int[] { -1, 0, 0, 1};
        int colNbr[] = new int[] {  0, -1, 1, 0};
        visited[row][col] = true;
        for (int k = 0; k < 4; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    static int countIslands(int M[][]) {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine()); // test 개수

            int[][] mat = null;
            for (int i=0 ;i<N ; i++) {
                String[] line = br.readLine().split(" ");
                COL = Integer.parseInt(line[0]); // 가로길이
                ROW = Integer.parseInt(line[1]); // 세로길이
                int num = Integer.parseInt(line[2]); // 배추벌레 개수

                mat = new int[ROW][COL];
                for (int j=0 ; j<num ; j++) {
                    String[] data = br.readLine().split(" ");
                    mat[Integer.parseInt(data[1])][Integer.parseInt(data[0])] = 1;
                }
                System.out.println(countIslands(mat));
            }
        } catch (IOException e) {
            // TODO
        }

    }

}
