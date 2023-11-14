package _202311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1157 단어 공부
 * https://www.acmicpc.net/problem/1157
 *
 * System.in.read() 참고
 */
public class _1157 {
    public static void main(String[] args) {

        int[] alpha = new int[255]; // 알파벳 아스키코드 의 개수를 담는다
        int maxIdx = 0; // 가장많은 알파벳 인덱스
        boolean tiFlag = false; // 같은개수 여부

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String read = br.readLine();
            char[] charArray = read.toUpperCase().toCharArray();
            for (int i = 0 ; i < charArray.length ; i++) {
                alpha[charArray[i]] += 1;
                if (alpha[charArray[i]] > alpha[maxIdx])
                    maxIdx = charArray[i];
            }
            for (int i = 0 ; i < alpha.length ; i++) {
                if (alpha[i] != 0 && i != maxIdx)
                    if (alpha[i] == alpha[maxIdx])
                        tiFlag = true;
            }
            System.out.println(tiFlag ? "?" : (char)maxIdx);
        } catch (IOException e) {
            // TODO
        }
    }
}
