package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 14500 테트로미노
 * https://www.acmicpc.net/problem/14500
 */
public class _14500 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int row = Integer.parseInt(s[0]); // row
            int col = Integer.parseInt(s[1]); // col
            int[][] arr = new int[row][col];
            for (int i=0; i<row ;i++) {
                String[] data = br.readLine().split(" ");
                for (int j=0; j<data.length ;j++)
                    arr[i][j] = Integer.parseInt(data[j]);
            }
            List<Integer> sum = new ArrayList<>();
            int[][] dy = new int[][] {{0,1,2,3},{0,0,0,0}
                                        , {0,1,0,1}
                                        , {0,1,2,2},{0,0,0,1},{0,0,1,2},{1,1,1,0}
                                        , {2,0,1,2},{0,1,1,1},{0,1,2,0},{0,0,0,1}
                                        , {0,1,1,2},{1,1,0,0}
                                        , {1,2,0,1},{0,0,1,1}
                                        , {0,0,1,0},{1,0,1,2},{1,0,1,1},{0,1,2,1}};
            int[][] dx = new int[][] {{0,0,0,0},{0,1,2,3}
                                        , {0,0,1,1}
                                        , {0,0,0,1},{0,1,2,0},{0,1,1,1},{0,1,2,2}
                                        , {0,1,1,1},{0,0,1,2},{0,0,0,1},{0,1,2,2}
                                        , {0,0,1,1},{0,1,1,2}
                                        , {0,0,1,1},{0,1,1,2}
                                        , {0,1,1,2},{0,1,1,1},{0,1,1,2},{0,0,0,1}};

            for (int k=0 ; k<19; k++) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        int y1 = i + dy[k][0];
                        int y2 = i + dy[k][1];
                        int y3 = i + dy[k][2];
                        int y4 = i + dy[k][3];

                        int x1 = j + dx[k][0];
                        int x2 = j + dx[k][1];
                        int x3 = j + dx[k][2];
                        int x4 = j + dx[k][3];

                        if (x1 < col && x2 < col && x3 < col && x4 < col
                            && y1 < row && y2 < row && y3 < row && y4 < row) {
                            sum.add(arr[y1][x1] + arr[y2][x2] + arr[y3][x3] + arr[y4][x4]);
                        }
                    }
                }
            }
            System.out.println(Collections.max(sum));

        } catch (IOException e) {
            // TODO
        }
    }
}
