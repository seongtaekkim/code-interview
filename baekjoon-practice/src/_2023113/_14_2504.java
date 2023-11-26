package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2504 괄호의 값
 * https://www.acmicpc.net/problem/2504
 *
 * 코드좀 정리하자;;
 */
public class _14_2504 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            // (()[[]])([]) => ((2)+((3))*3)*2+((3))*2 변경
            char[] data = br.readLine().toCharArray();

            Stack_2504 checkStack = new Stack_2504(data.length);
            for (int i=0 ; i<data.length ; i++) {
                if (data[i] != '(' && data[i] != ')' && data[i] != '[' && data[i] != ']') {
                    System.out.println(0);
                    return;
                }
                if (data[i] == '(') checkStack.push(data[i]);
                if (data[i] == '[') checkStack.push(data[i]);
                if (data[i] == ')') {
                    if (checkStack.top() == '(')
                        checkStack.pop();
                    else if (checkStack.top() == '[') {
                        System.out.println(0);
                        return ;
                    } else {
                        System.out.println(0);
                        return ;
                    }
                }
                if (data[i] == ']') {
                    if (checkStack.top() == '[')
                        checkStack.pop();
                    else if (checkStack.top() == '(') {
                        System.out.println(0);
                        return ;
                    } else {
                        System.out.println(0);
                        return ;
                    }
                }
            }
            if (checkStack.size() > 0) {
                System.out.println(0);
                return ;
            }

            Stack_2504 stack = new Stack_2504(data.length);
            char[] ret = new char[data.length*2];
            int retIdx =0;
            for (int i=0 ; i<data.length ; i++) {
                if (data[i] == '(') {
                    if (stack.top() == ')' || stack.top() == ']') {
                        ret[retIdx++] = '+';
                    }
                    ret[retIdx++] = '(';
                }
                if (data[i] == ')') {
                    if (stack.top() == '(') {
                        ret[retIdx++] = '2';
                        ret[retIdx++] = ')';
                    } else {
                        ret[retIdx++] = ')';
                        ret[retIdx++] = '*';
                        ret[retIdx++] = '2';
                    }
                }
                if (data[i] == '[') {
                    if (stack.top() == ')' || stack.top() == ']') {
                        ret[retIdx++] = '+';
                    }
                    ret[retIdx++] = '[';
                } if (data[i] == ']') {
                    if (stack.top() == '[') {
                        ret[retIdx++] = '3';
                        ret[retIdx++] = ']';
                    } else {
                        ret[retIdx++] = ']';
                        ret[retIdx++] = '*';
                        ret[retIdx++] = '3';
                    }
                }
                stack.push(data[i]);
            }

            for (int i=0 ;i<retIdx; i++) {
                if (ret[i] == '[') ret[i] = '(';
                if (ret[i] == ']') ret[i] = ')';
            }

            // 후위연산자로 변경
            // ((2)+((3))*3)*2+((3))*2 => 233*+2*32*+
            Stack_2504 stack2 = new Stack_2504(retIdx);
            char[] input = new char[retIdx];
            int retIdx2 =0;
            for (int i=0 ; i<ret.length ; i++) {
                if (ret[i] == '2' || ret[i] == '3') {
                    input[retIdx2++] = ret[i];
                }
                else {
                    if (ret[i] == '(') {
                        stack2.push(ret[i]);
                    }
                    else if (ret[i] == ')') {
                        while (stack2.top() != '(') {
                            input[retIdx2++] = stack2.pop();
                        }
                        stack2.pop();
                    }
                    else if (ret[i] == '+') {
                        while (stack2.top() == '+' || stack2.top() == '*') {
                            input[retIdx2++] = stack2.pop();
                        }
                        stack2.push(ret[i]);
                    }
                    else if (ret[i] == '*') {
                        while (stack2.top() == '*') {
                            input[retIdx2++] = stack2.pop();
                        }
                        stack2.push(ret[i]);
                    }
                }
            }
            while (stack2.size() != 0) {
                input[retIdx2++] = stack2.pop();
            }


            // 후위연산자 연산
            // 233*+2*32*+ => 28
            Stack_2504_2 stack3 = new Stack_2504_2(retIdx2);
            for (int i=0 ; i<retIdx2 ; i++) {
                if (input[i] == '2' || input[i] == '3') {
                    stack3.push(input[i]-'0');
                } else {
                    int second = stack3.pop();
                    int first = stack3.pop();
                    int r = 0;
                    if (input[i] == '+')
                        r = first + second;
                    else if (input[i] == '*')
                        r = first * second;
                    stack3.push(r);
                }
            }
            System.out.println(stack3.pop());

        } catch (IOException e) {
            //TODO
        }

    }
}

class Stack_2504 {
    char[] resources;
    int size;
    public Stack_2504(int num) {
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

class Stack_2504_2 {
    int[] resources;
    int size;
    public Stack_2504_2(int num) {
        resources = new int[num];
        size = 0;
    }
    public void push(int data) {
        resources[size] = data;
        size++;
    }
    public int top() {
        if (this.size == 0)
            return -1;
        return this.resources[size-1];
    }
    public int pop() {
        if (this.size == 0)
            return -1;
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
