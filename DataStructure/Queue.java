package DataStructure;

/**
 * The implement of Queue.
 */

public class Queue {

    private Vector data;

    public Queue() {
        data = new Vector();
    }

    public void push(Object o) {
        data.addLast(o);
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
//        Queue queue = new Queue();
//        System.out.println(queue.isEmpty());
//        for (int i = 0; i < 3; i++)
//            queue.push(i);
//        System.out.println(queue.top());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//    }
}
