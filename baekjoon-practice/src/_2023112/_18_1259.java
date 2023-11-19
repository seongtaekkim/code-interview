package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1259 팰린드롬수
 * https://www.acmicpc.net/problem/1259
 */
public class _18_1259 {
    public static void main(String[] args) {
        boolean flag = true;
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String read = null;
            while ((read = br.readLine()) != null) {
                flag = true;
                if ("0".equals(read)) break;
                char[] charArray = read.toCharArray();
                for (int i = 0; i < charArray.length / 2; i++) {
                    if (charArray[i] != charArray[charArray.length - 1 - i]) {
                        flag = false;
                    }
                }
                System.out.println(flag == true ? "yes" : "no");
            }
        } catch (IOException e) {
            //TODO
        }
    }
}
