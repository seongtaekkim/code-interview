package sectioin1;

import java.util.*;

public class Stack {

    public static void main(String[] args) {
        new Stack();
    }
    public Stack() {

        new IntStackTester();
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
    private Map<Integer,Integer> maxList;
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
            maxList = new HashMap<>();
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


