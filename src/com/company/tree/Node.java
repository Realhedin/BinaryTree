package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dkorolev
 *         Date: 1/17/2019
 *         Time: 3:03 PM
 */
public class Node<T1 extends Comparable<T1>, T2 extends Comparable<T2>>  {

    T1 key;
    T2 value;
    Node<T1, T2> left;
    Node<T1, T2> right;

    public Node(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }




    public T2 get(T1 key, Node root) {
        Node<T1, T2> x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x.value;
            } else {
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        return null;
    }


    public void add(T1 key, T2 value, Node root) {
        Node<T1,T2> y = null; //parent for x
        Node<T1, T2> x = root; //iterative element
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                x.value = value;
                return;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }

        Node<T1, T2> newNode = new Node<T1, T2>(key, value);
        if (y == null) {
            root = newNode;
        } else {
            int cmp = key.compareTo(y.key);
            if (cmp < 0) {
                y.left = newNode;
            } else {
                y.right = newNode;
            }
        }
    }



    public void delete(T1 key, Node root) {
        Node<T1,T2> x = root;
        Node<T1,T2> y = null;
        //finding right node through the tree
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                break;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        if (x == null) {
            return;
        }
        //check if it's case without right leaf = case 1
        //then we set parent node left leaf of deleting node
        if (x.right == null) {
            if (x == y.left) {
                y.left = x.left;
            } else {
                y.right = x.left;
            }
            //if not - then case 2
            //we have to iterate to right branch to find leftmost leaf
        } else {
            Node<T1, T2> leftMost = x.right;
            y = null;
            while (leftMost.left != null) {
                y = leftMost;
                leftMost = leftMost.left;
            }
            if (y != null) {
                y.left = leftMost.right;
            } else {
                x.right = leftMost.right;
            }
            x.key = leftMost.key;
            x.value = leftMost.value;
        }
    }


    //horizontal check all nodes
    public void horizontalWalkThrough(Node top) {
        Queue<Node> queue = new LinkedList<>();
        do {
            if (!queue.isEmpty()) {
                top = queue.poll();
            }
            System.out.println("key:" + top.key + " value:"+top.value);
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
        } while (!queue.isEmpty());
    }


    //vertical (direct)
    public void verticalDirectWalk(Node top) {
        System.out.println("key:" + top.key + " value:"+top.value);
        if (top.left != null) {
            verticalDirectWalk(top.left);
        }
        if (top.right != null) {
            verticalDirectWalk(top.right);
        }
    }

    //vertical(indirect)
    public void verticalIndirectWalk(Node top) {
        if (top.left != null) {
            verticalIndirectWalk(top.left);
        }
        System.out.println("key:" + top.key + " value:"+top.value);
        if (top.right != null) {
            verticalIndirectWalk(top.right);
        }
    }

    //vertical(fromEnd)
    public void verticalFromEndWalk(Node top) {
        if (top.left != null) {
            verticalFromEndWalk(top.left);
        }
        if (top.right != null) {
            verticalFromEndWalk(top.right);
        }
        System.out.println("key:" + top.key + " value:"+top.value);

    }
}