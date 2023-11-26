package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 4949 균형잡힌 세상
 * https://www.acmicpc.net/problem/4949
 */
public class _08_4949 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            Stack_4949 stack = null;
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = br.readLine();
                if (".".equals(line)) break;
                char[] charArray = line.toCharArray();
                stack = new Stack_4949(100);
                boolean flag = true;
                for (int i=0 ; i<charArray.length ; i++) {
                    flag = true;
                    if (charArray[i] == '(') stack.push('(');
                    else if (charArray[i] == '[') stack.push('[');
                    else if (charArray[i] == ')') {
                        if (stack.top() == '(')
                            stack.pop();
                        else {
                            flag = false;
                            break ;
                        }
                    }
                    else if (charArray[i] == ']') {
                        if (stack.top() == '[')
                            stack.pop();
                        else {
                            flag = false;
                            break ;
                        }
                    }
                    if (charArray[i] == '.') break;
                }
                if (stack.size() > 0 || !flag)
                    sb.append("NO\n");
                else
                    sb.append("YES\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            //TODO
        }

    }
}

class Stack_4949 {
    char[] resources;
    int size;
    public Stack_4949(int num) {
        resources = new char[num];
        size = 0;
    }
    public void push(char data) {
        resources[size] = data;
        size++;
    }
    public char top() {
        if (this.size == 0)
            return 0;
        return this.resources[size-1];
    }
    public char pop() {
        if (this.size == 0)
            return 0;
        this.size--;
        return this.resources[this.size];
    }
    public int size() {
        return size;
    }
    public int empty() {
        if (size > 0)
            return 0;
        return 1;
    }
}