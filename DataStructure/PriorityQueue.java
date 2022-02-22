package DataStructure;

public class PriorityQueue {

    public class PriorityPair implements Comparable {

        public Object element;
        public Object priority;

        public PriorityPair(Object element, Object priority) {
            this.element = element;
            this.priority = priority;
        }

        @Override
        public int compareTo(Object o) {
            PriorityPair p2 = (PriorityPair) o;
            return ((Comparable)priority).compareTo(p2.priority);
        }
    }

    private SortedLinkedList data;

    public PriorityQueue() {
        data = new SortedLinkedList();
    }

    public void push(Object o, int priority) {
        data.addSorted(new PriorityPair(o, priority));
    }

    public Object pop() {
        return  data.getFirst();
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.push(1, 1);
        priorityQueue.push(1, 1);
        priorityQueue.push(1, 2);
        priorityQueue.push(1, 3);
        priorityQueue.push(1, 4);
        priorityQueue.push(1, 5);
        priorityQueue.push(1, 6);
        priorityQueue.push(1, 6);
        priorityQueue.push(1, 6);
        priorityQueue.push(1, 7);
        priorityQueue.push(1, 7);
        System.out.println(priorityQueue.toString());

    }

}
