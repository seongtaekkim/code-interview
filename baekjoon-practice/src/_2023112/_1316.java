package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1316 그룹 단어 체커
 * https://www.acmicpc.net/problem/1316
 */
public class _1316 {
    public static void main(String[] args) {

        short groupWordCnt = 0;
        int[] alpha;
        boolean checker = true;
        int beforeAlpha = 0;
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            for (int i=0 ; i<num ; i++) {
                alpha = new int[255];
                char[] charArray =  br.readLine().toCharArray();
                checker = true;

                for (int j=0 ; j<charArray.length ; j++) {
                    // 이전 알파벳이 현재와 다른데, 카운트 이력이 있으면 그룹체커단어가 아니다.
                    if (alpha[charArray[j]] != 0 && beforeAlpha != charArray[j]) {
                        checker = false;
                        break ;
                    }
                    alpha[charArray[j]]++;
                    beforeAlpha = charArray[j];
                }
                if (checker == true) groupWordCnt++;
            }
            System.out.print(groupWordCnt);
        } catch (IOException e) {
            //TODO
        }
    }
}
