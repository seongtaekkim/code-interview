package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2947 크로아티아 알파벳
 * https://www.acmicpc.net/problem/2941
 */
public class _07_2941 {
    public static void main(String[] args) {

        /**
         * c= c- dz= d- lj nj s= z=
         */
        short cnt = 0;
        String[] croatia = new String[] {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String read = br.readLine();
            char[] charArray = read.toCharArray();
            for (int i = 0; i < charArray.length ; i++) {
                for (int j =0 ; j< croatia.length ; j++) {
                    if (i < charArray.length-1 && croatia[j].equals(read.substring(i, i+2))) {
                        i += 1;
                        break ;
                    }
                    if (i+1 < charArray.length-1 && croatia[j].equals(read.substring(i, i+3))) {
                        i += 2;
                        break ;
                    }
                }
                cnt++;
            }
        } catch (IOException e) {
            // TODO
        }
        System.out.println(cnt);
    }
}
