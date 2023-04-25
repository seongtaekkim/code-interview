package datastructure;

import java.util.*;

/**
 * 1. valid parentheses
 * 2. max stack
 * 3. remove adjacent duplicate
 * 4. later
 * 5. later
 * 6. later
 */
public class Stack {

    public static void main(String[] args) {
        new Stack();
    }

    public Stack() {

       // new IntStackTester();

        /*Integer[] arr = new Integer[]{1,2,2,3,4,4,4,5,6};
        removeAdjacentDuplicates(arr,3);*/

        /*String[] parentheses = new String[]{"[","{","]","[","}","]"};
        System.out.println(validParentheses(parentheses));*/

        Integer[] maxStackArr = new Integer[]{1,3,3,2,5,1};
        maxStack(maxStackArr).dump();
    }

    private GenericStack<Integer> maxStack(Integer[] data) {
        GenericStack<Integer> stack = new GenericStack<>(data.length);
        GenericStack<Integer> maxStack = new GenericStack<>(data.length);

        for(int i=0 ; i<data.length ; i++) {
            if(maxStack.isEmpty()) {
                stack.push(data[i]);
                maxStack.push(data[i]);
            } else {
                if(data[i] > stack.peek()) {
                    maxStack.push(data[i]);
                }
                stack.push(data[i]);
            }
        }
        stack.dump();
        return maxStack;
    }
    /**
     * valid parentheses
     * @param parentheses
     * @return
     */
    private boolean validParentheses(String[] parentheses) {

        Map<String,String> pair = new HashMap<>();
        pair.put(")","(");
        pair.put("]","[");
        pair.put("}","{");
        GenericStack<String> stack = new GenericStack<>(parentheses.length);

        for(int i=0 ; i<parentheses.length ; i++) {
            if(stack.isEmpty())
                stack.push(parentheses[i]);
            else {
                if("(".equals(parentheses[i]) || "[".equals(parentheses[i]) || "{".equals(parentheses[i]))
                    stack.push(parentheses[i]);
                if(")".equals(parentheses[i]) || "]".equals(parentheses[i]) || "}".equals(parentheses[i])) {
                    if(stack.peek().equals(pair.get(stack.peek())))
                        stack.pop();
                    else return false;
                }
            }
        }
        stack.dump();
        return stack.isEmpty() == true;
    }

    /**
     * remove adjacent duplicate
     * @param arr
     * @param k
     */
    public void removeAdjacentDuplicates(Integer[] arr, int k) {
        GenericStack s1 = new GenericStack(arr.length);

        GenericStack s2 = new GenericStack(arr.length);

        for(int i=0 ; i<arr.length ; i++){
            if(i==0){
                s1.push(arr[i]);
                s2.push(1);
            } else {
                if(arr[i] == s1.peek()) {
                    s1.push(arr[i]);
                    Integer data = (Integer) s2.peek();
                    s2.pop();
                    s2.push(data+1);
                    if((Integer)s2.peek() == k) {
                        s2.pop();
                    }
                } else {
                    s1.push(arr[i]);
                    s2.push(1);
                }
            }
        }

        s1.dump();;
        s2.dump();;
    }
}

class IntStackTester {

    public IntStackTester() {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(5);

        while(true) {
            System.out.println("current size is " +s.size() + "/" + s.capacity());
            System.out.println("(0)exit (1)push (2)pop (3)peek (4)dump (5)indexOf (6)clear (7)isEmpty (8)isFull (9)max");

            int menu = stdIn.nextInt();
            if(menu == 0)
                break;
            int x;
            switch(menu) {
                case 1:
                    System.out.println("data : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch(IntStack.OverFlowIntStackException e) {
                        System.out.println("stack is full");
                    }
                    break;
                case 2:
                    try {
                        x = s.pop();
                        System.out.println("pop data is " + x);
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println("stack is empty");
                    }
                    break;
                case 3:
                    try {
                        x = s.peek();
                        System.out.println("peak data is " + x);
                    } catch(IntStack.EmptyIntStackException e) {
                        System.out.println("stack is empty");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                case 5:
                    System.out.print("find data : ");
                    int data = stdIn.nextInt();
                    x = s.indexOf(data);
                    if(x == -1 ) {
                        System.out.println("not data");
                    } else {
                        System.out.println("index num is " + x);
                    }
                    break;
                case 6:
                    s.clear();
                    break;
                case 7:
                    if(s.isEmpty()) {
                        System.out.println("stack is empty");
                    } else {
                        System.out.println("stack is not empty");
                    }
                    break;
                case 8:
                    if(s.isFull()) {
                        System.out.println("stack is full");
                    } else {
                        System.out.println("stack is not full");
                    }
                    break;
                case 9:
                    break;
                default :
                    break;
            }
        }

    }
}


class IntStack {
    private int max;
    private int ptr;
    private int[] stk;
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    public class OverFlowIntStackException extends RuntimeException {
        public OverFlowIntStackException() {};
    }


    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverFlowIntStackException {
        if(ptr >= max) {
            throw new OverFlowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if(ptr <= 0 )
            throw new EmptyIntStackException();
        return stk[ptr--];
    }

    public int peek() throws EmptyIntStackException {
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr -1];
    }

    public int indexOf(int x) {
        for(int i=ptr-1 ; i>=0 ; i--) {
            if(stk[i] == x)
                return i;
        }
        return -1;
    }
    public void clear() {
        ptr = 0;
    }
    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }
    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr>=max;
    }
    public void dump() {
        if(ptr<=0) {
            System.out.println("stack is empty");
        } else {
            for(int i=0; i<ptr ; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

}


class GenericStack<E> {
    private int max;
    private int ptr;
    private E[] stk;


    @SuppressWarnings("unchecked")
    public GenericStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    public E push(E x) throws OverFlowIntStackException {
        if(ptr >= max) {
            throw new OverFlowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public E pop() throws EmptyStackException {
        if(ptr <= 0 )
            throw new EmptyStackException();
        return stk[--ptr];
    }

    public E peek() throws EmptyStackException {
        if(ptr <= 0)
            throw new EmptyStackException();
        return stk[ptr -1];
    }

    public int indexOf(E x) {
        for(int i=ptr-1 ; i>=0 ; i--) {
            if(x.equals(stk[i]))
                return i;
        }
        return -1;
    }
    public void clear() {
        ptr = 0;
    }
    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }
    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr>=max;
    }
    public void dump() {
        if(ptr<=0) {
            System.out.println("stack is empty");
        } else {
            for(int i=0; i<ptr ; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

}



class EmptyIntStackException extends RuntimeException {
    public EmptyIntStackException() {}
}

class OverFlowIntStackException extends RuntimeException {
    public OverFlowIntStackException() {};
}