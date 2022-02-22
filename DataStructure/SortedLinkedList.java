package DataStructure;

/**
 * The implement of LinkedList.
 */

public class SortedLinkedList {

    private class ListElement implements Comparable {

        private Object value;
        private ListElement next;

        public ListElement(Object el, ListElement nextElement) {
            value = el;
            next = nextElement;
        }

        public ListElement(Object el) {
            this(el, null);
        }

        public Object getValue() {
            return value;
        }

        public ListElement getNext() {
            return next;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setNext(ListElement nextElement) {
            this.next = nextElement;
        }

        @Override
        public int compareTo(Object o) {
            PriorityQueue.PriorityPair l2 = (PriorityQueue.PriorityPair) o;
            PriorityQueue.PriorityPair l1 = (PriorityQueue.PriorityPair) value;
            return ((PriorityQueue.PriorityPair)l1.priority).compareTo(l2.priority);
        }
    }

    private ListElement head;

    public SortedLinkedList() {
        head = null;
    }

    public void addFirst(Object o) {
        head = new ListElement(o, head);
    }

    public void addLast(Object o) {
        if (head == null)
            addFirst(o);
        else {
            ListElement d = head;
            while (d.getNext() != null)
                d = d.getNext();
            ListElement newLast = new ListElement(o);
            d.setNext(newLast);
        }
    }

    public void addSorted(Object o) {
        if (head == null)
            head = new ListElement(o, null);
        else if (head.compareTo(o) > 0)
            head = new ListElement(o, head);
        else {
            ListElement d =head;
            while (d.next != null && d.next.compareTo(o) < 0)
                d = d.next;
            ListElement rest = d.next;
            d.setNext((new ListElement(o, rest)));
        }
    }

    public Object getFirst() {
        return  head.getValue();
    }

    public Object get(int n) {
        ListElement d = head;
        while (n > 0) {
            d = d.getNext();
            n--;
        }
        return d.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListElement d = head;
        while (d != null) {
            sb.append(" -> " + d.getValue());
            d = d.getNext();
        }
        sb.append("\n");
        return sb.toString();
    }




    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
//        linkedList.addLast(1);
//        linkedList.addLast(1);
//        linkedList.addLast(1);
//        linkedList.addLast(7);
//        linkedList.addLast(4);
//        linkedList.addLast(4);
//        linkedList.addLast(4);
//        linkedList.addLast(9);
//        linkedList.addLast(3);
        System.out.println(linkedList);

        System.out.println(linkedList);
    }
}
