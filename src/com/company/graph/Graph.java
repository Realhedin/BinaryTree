package com.company.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 3/31/2019
 *         Time: 1:38 PM
 */
public class Graph {

    int numOfVerteces;
    List<LinkedList<Integer>> adjList;

    public Graph(int numOfVerteces) {
        this.numOfVerteces = numOfVerteces;
        adjList = new ArrayList<>(numOfVerteces);
        for (int i = 0; i < numOfVerteces; i++) {
            adjList.add(new LinkedList<>());
        }
    }


    public void add(int src, int dest) {
        LinkedList<Integer> integers = adjList.get(src);
        if (!integers.contains(dest)) {
            integers.add(dest);
        }
        LinkedList<Integer> integers1 = adjList.get(dest);
        if (!integers1.contains(src)) {
            integers1.add(src);
        }
    }


    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (Integer integer : adjList.get(i)) {
                System.out.print(" -> " + integer);
            }
            System.out.println("\n");
        }
    }


    public void bandthTraversal(int vertice) {
        boolean[] alreadySeenArray = new boolean[numOfVerteces];
        LinkedList<Integer> queue = new LinkedList<>();

        //put current vertice as used
        alreadySeenArray[vertice] = true;
        queue.add(vertice);

        while (!queue.isEmpty()) {
            Integer vert = queue.poll();
            System.out.print(vert + " ");
            LinkedList<Integer> listOfEdges = adjList.get(vert);
            for (Integer edge : listOfEdges) {
                if (!alreadySeenArray[edge]) {
                    queue.add(edge);
                    alreadySeenArray[edge] = true;
                }
            }
        }

    }


    public void depthTraversal(int vertice) {
        boolean[] alreadySeen = new boolean[numOfVerteces];

        dtr(alreadySeen, vertice);
    }

    private void dtr(boolean[] alreadySeen, int vertice) {
        alreadySeen[vertice] = true;
        System.out.print(vertice + " ");
        for (Integer integer : adjList.get(vertice)) {
            if (!alreadySeen[integer]) {
                dtr(alreadySeen,integer);
            }
        }
    }
}