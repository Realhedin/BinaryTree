package com.company.graph;

/**
 * @author dkorolev
 *         Date: 3/31/2019
 *         Time: 1:45 PM
 */
public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 4);
        graph.add(3, 4);
        graph.add(3, 5);
        graph.add(4, 5);
//        Graph graph = new Graph(4);
//        graph.add(0, 1);
//        graph.add(0, 2);
//        graph.add(1, 2);
//        graph.add(2, 0);
//        graph.add(2, 3);
//        graph.add(3, 3);
        graph.printGraph();

        System.out.println("Bandth traversal:");
        graph.bandthTraversal(0);

        System.out.println("\nDepth traversal:");
        graph.depthTraversal(0);
    }
}