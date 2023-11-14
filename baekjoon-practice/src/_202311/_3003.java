package _202311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 3003 킹, 퀸, 룩, 비숍, 나이트, 폰
 * https://www.acmicpc.net/problem/3003
 *
 *
 * sprit 대신 StringTokenizer 참고
 */
public class _3003 {
    public static void main(String[] args) {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        /**
         *  킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개
         */
        final int[] chess = new int[] {1, 1, 2, 2, 2, 8};
        try {
            String readStr = br.readLine();
            String[] readChess = readStr.split(" ");
            if (readChess.length != 6)
                return ;
            for (int i = 0; i < chess.length ; i++)
                System.out.print(chess[i] - Integer.parseInt(readChess[i]) + ((i == chess.length -1) ? "" : " "));
        } catch (IOException e) {
        }
    }
}
