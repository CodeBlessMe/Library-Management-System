package DataStructure;

/**
 * This separate class is dedicated to implementing the shortest path algorithm.
 *
 * The main idea of this implementation is to first search all nodes on the graph
 *  through breadth-first search. Then search back from the end node to the start node
 *  to get the shortest path.
 */

public class ShortestPath {

    private Graph graph;
    private String startSection;
    private String endSection;
    private Graph.Node startNode;
    private Graph.Node endNode;
    private boolean[] visited; //check whether nodes are visited
    private Vector preNode; //store pre node for every node

    public ShortestPath(Graph graph, String startSection, String endSection) {
        this.graph = graph;
        this.startSection = startSection;
        this.endSection = endSection;
        startNode = getNode(startSection);
        endNode = getNode(endSection);
        visited = new boolean[graph.getSize()];
        preNode = new Vector(graph.getSize());
        for (int i = 0; i < graph.getSize(); i++)
            preNode.addLast(0);
        breadthFirsttSearch();
        System.out.println(findShortestPath());
    }

    //breadth-first search
    public void breadthFirsttSearch() {
        Queue queue = new Queue();
        queue.push(startNode);
        visited[getIndex(startSection)] = true;
        preNode.set(getIndex(startSection), startNode);
        while (!queue.isEmpty()) {
            Graph.Node node = (Graph.Node) queue.pop();
            Vector edge = node.getEdge();
            for (int i = 0; i < edge.getSize(); i++) {
                Graph.Node nodeOfEdge = (Graph.Node) edge.get(i);
                if (!visited[getIndex((String) nodeOfEdge.getValue())]) {
                    queue.push(nodeOfEdge);
                    visited[getIndex((String) nodeOfEdge.getValue())] = true;
                    preNode.set(getIndex((String) nodeOfEdge.getValue()),
                            getNode((String) node.getValue()));
                }
            }

        }
    }

    public Graph.Node getNode(String value) {
        return graph.findNode(value);
    }

    public int getIndex(String value) {
        return graph.getIndex(value);
    }

    //Get the shortest path by the information of pre nodes.
    public Vector findShortestPath() {
        Vector path = new Vector();
        Graph.Node currentNode = endNode;
        while (currentNode.compareTo(startNode) != 0) {
            path.addFirst(currentNode);
            currentNode = (Graph.Node) preNode.get(getIndex((String) currentNode.getValue()));
        }
        path.addFirst(startNode);
        return path;
    }

//    public static void main(String[] args) {
//        Graph graph = new Graph();
//        graph.addNode("0");
//        graph.addNode("1");
//        graph.addNode("2");
//        graph.addNode("3");
//        graph.addNode("4");
//        graph.addNode("5");
//        graph.addNode("6");
//        graph.addNode("7");
//        graph.addEdge("0", "1");
//        graph.addEdge("0", "2");
//        graph.addEdge("1", "2");
//        graph.addEdge("2", "3");
//        graph.addEdge("0", "4");
//        graph.addEdge("0", "7");
//        graph.addEdge("4", "5");
//        graph.addEdge("5", "6");
//        graph.addEdge("7", "6");
//        ShortestPath shortestPath = new ShortestPath(graph, "3", "6");
//    }
}
