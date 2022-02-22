package DataStructure;

/**
 * The implement of Graph.
 *
 * Here, I didn't use a class to implement edge, I just used a Vector
 *  to implement it, it provides a light code and is easier to use.
 */

public class Graph {

    public class Node implements Comparable {

        private Comparable value;
        private Vector edge;

        public Node(Comparable value) {
            this.value = value;
            edge = new Vector();
        }

        public void addEdge(Node node) {
            edge.addLast(node);
        }

        public Comparable getValue() {
            return value;
        }

        public Vector getEdge() {
            return edge;
        }

        @Override
        public int compareTo(Object o) {
            //When 2 nodes have same label, they are equal
            Node n = (Node) o;
            return n.value.compareTo(value);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Vector nodes;

    public Graph() {
        nodes = new Vector();
    }

    public void addNode(Comparable value) {
        nodes.addLast(new Node(value));
    }

    public Node findNode(Comparable nodeLabel) {
        Node res = null;
        for (int i = 0; i < nodes.getSize(); i++) {
            Node n = (Node) nodes.get(i);
            if (n.getValue() == nodeLabel) {
                res = n;
                break;
            }
        }
        return res;
    }

    public Node getNode(int index) {
        return (Node) nodes.get(index);
    }

    public int getIndex(Comparable value) {
        for (int i = 0; i < nodes.getSize(); i++) {
            Node n = (Node) nodes.get(i);
            if (n.getValue() == value)
                return i;
        }
        return -1;
    }

    public int getSize() {
        return nodes.getSize();
    }

    public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2) {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        n1.addEdge(n2);
        n2.addEdge(n1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.getSize(); i++) {
            Node node = (Node) nodes.get(i);
            sb.append(node + ": ");
            Vector edge = node.getEdge();
            sb.append(edge);
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        Graph graph = new Graph();
//        graph.addNode("0");
//        graph.addNode("1");
//        graph.addNode("2");
//        graph.addNode("3");
//        graph.addEdge("0", "1");
//        graph.addEdge("0", "2");
//        graph.addEdge("1", "2");
//        graph.addEdge("2", "3");
//        System.out.println(graph);
//    }

}
