package DataStructure;

/**
 * The implement of Vector.
 */

public class Vector{

    protected Object data[];
    protected int count;
    protected int capacity;

    //Constructor

    public Vector(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        count = 0;
    }

    public Vector() {
        capacity = 10;
        data = new Object[capacity];
        count = 0;
    }

    //Basic operations

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public Object get(int index) {
        return data[index];
    }

    public int getSize() {
        return count;
    }

    public void set(int index, Object obj) {
        data[index] = obj;
    }

    //Because old addFirst() and addLast() have some repetitive code, I extracted them
    //  to a new private method add().
    private void add(int index, Object obj) {
        if (count == data.length)
            extendCapacity();

        for (int i = count-1; i >= index; i--)
            data[i+1] = data[i];
        data[index] = obj;
        count++;
    }

    public Object remove(int index) {
        Object inter = data[index];
        for (int i = index; i < count-1; i++)
            data[i] = data[i+1];
        count--;
        data[count] = null;
        return inter;
    }

    //Advanced operations

    public void addFirst(Object obj) {
        add(0, obj);
    }

    public void addLast(Object obj) {
        add(count, obj);
    }

    public Object removeLast() {
        return remove(count-1);
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object getFirst() {
        return  get(0);
    }

    public int contains(Object obj) {
        for (int i = 0; i < count; i++)
            if (data[i].equals(obj))
                return i;
        return -1;
    }

    private void extendCapacity() {
        capacity *= 2;
        Object newData[] = new Object[capacity];
        for (int i = 0; i < count; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append(" " + data[i]);
        sb.append("\n");
        return sb.toString();
    }

//    public static void main(String[] args) {
//        Vector vector = new Vector();
////        for (int i = 0; i < 10; i++)
////            vector.add(i, -1);
//        System.out.println(vector);
//
//    }

}
