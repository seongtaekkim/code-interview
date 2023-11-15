package _202311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10988 팰린드롬인지 확인하기
 * https://www.acmicpc.net/problem/10988
 */
public class _08_10988 {
    public static void main(String[] args) {
        boolean flag = true;
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String read = br.readLine();
            char[] charArray = read.toCharArray();
            for (int i=0 ; i<charArray.length/2; i++) {
                if (charArray[i] != charArray[charArray.length -1 - i]) {
                    flag = false;
                }
            }
            System.out.println(flag == true ? 1 : 0);
        } catch (IOException e) {
            //TODO
        }
    }
}
