package DataStructure;

/**
 * The implement of LinkedList.
 */

public class LinkedList {

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
            ListElement l2 = (ListElement) o;
            return ((Comparable)value).compareTo(l2.value);
        }
    }

    private ListElement head;

    public LinkedList() {
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

    public void customDelete(int number) {
        if (head == null)
            return;
        if ((int)head.value == number) {
            if (head.next == null)
                head = null;
            if ((int)head.next.value != number)
                head = head.next;
            return;
        }
        if (head.next == null)
            return;
        if ((int)head.next.value == number && head.next.next == null) {
            head.next = null;
            return;
        }
        if (head.next.next == null)
            return;

        ListElement pre = head;
        ListElement cur = head.next;
        ListElement nextEle = head.next.next;
        while (nextEle != null) {
            if ((int)cur.value == number && (int)nextEle.value != number) {
                pre.next = nextEle;
                break;
            }
            pre = cur;
            cur = nextEle;
            nextEle = nextEle.next;
        }
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
        linkedList.customDelete(4);
        System.out.println(linkedList);
    }
}
