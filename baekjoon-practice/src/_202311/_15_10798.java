package _202311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10798 세로읽기
 * https://www.acmicpc.net/problem/10798
 */
public class _15_10798 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String read = null;
            int max = -1;
            char[][] arr2 = new char[5][];
            for (int i=0; i<5 ; i++) {
                read = br.readLine();
                if (max < read.length())
                    max = read.length();
                arr2[i] = read.toCharArray();
            }

            for (int j=0; j<max ; j++)
                for (char[] chars : arr2) {
                    if (chars.length > j)
                        System.out.print(chars[j]);
                }
        } catch (IOException e) {
            // TODO
        }
    }
}
