package DataStructure;

/**
 * The implement of Stack.
 */

public class Stack {

    private Vector data;

    public Stack() {
        data = new Vector();
    }

    public void push(Object o) {
        data.addFirst(o);
    }

    public Object pop() {
        return data.removeFirst();
    }

    public Object top() {
        return data.getFirst();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

//    public static void main(String[] args) {
//        Stack stack = new Stack();
//        System.out.println(stack.isEmpty());
//        for (int i = 0; i < 3; i++)
//            stack.push(i);
//        System.out.println(stack.top());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//    }
}
