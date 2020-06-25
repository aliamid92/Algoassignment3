import java.util.ArrayList;
import java.util.List;


/**
 * we changed the Starter code, which you posted on moodle and extracted the Node class and changed it from private to public.
 * In this Program we did not use MinHeapTemplate and MinHeapNode. we are aware of the fact that it is better for the
 * implementation of algorithms to implement MinHeap first, but we could not use it in this assignment. Hence, we came up
 * with our own solution to get the assignment done. we are aware of the fact that if we had used MinHeap tree, the time complexity of
 * Algorithms would have decreased.
 */
public class GraphTemplate {
    // in contrast to the starter code, we added a string variable called name, which will be the name of our graph
    String name;
    // we create a new ArrayList from List<> interface, because if in the future the programmer decides to change the ArrayList to LinkedList,
    // he or she can change it right here, without changing the entire code. The Idea is derived form Udemy Course in Java by "Tim Buchalka".
    private List<Node> nodes = new ArrayList<>();
    // we did not use MinHeapTemplate anymore in this program, but we did not delete it.
    MinHeapTemplate minPriorityQueue;
    // this attribute will be set in a constructor
    boolean isDirected;

    // Constructor, pass the name and if the Graph is directed
    public GraphTemplate(String name, Boolean isDirected) {
        this.name = name;
        this.isDirected = isDirected;
    }

    /**
     * Getter method for getting an ArrayList variable
     *
     * @return List
     */
    public List<Node> getAListOfNodes() {
        return nodes;
    }

    /**
     * this method will add Nodes to the ArrayList of our graph
     *
     * @param node
     * @return boolean
     */
    public boolean addNode(Node node) {
        // if an ArrayList contains node, do not add it again
        if (nodes.contains(node)) {
            return false;
        } else {
            nodes.add(node);
            return true;
        }
    }

    /**
     * this method will remove Nodes from the ArrayList of our graph
     *
     * @param node
     * @return boolean
     */
    public boolean removeNode(Node node) {
        // if an ArrayList contains node, remove it
        if (nodes.contains(node)) {
            nodes.remove(node);
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method will print our Graph on the terminal
     */
    public void print() {
        System.out.println("Bellow please find your Graph: ");
        // go through each node of our ArrayList
        for (int i = 0; i < nodes.size(); i++) {
            // go to the Hashmap of each node and put the node in a new Set and go through the Set
            // Note: we learned how to go through each key of the hashmap from the Udemy Course by "Tim Buchalka"
            for (Node node : nodes.get(i).getAdjacentNodes().keySet()) {
                // print it on the terminal
                System.out.println(nodes.get(i).getLabel() + " ------> " + node.getLabel());
            }
        }
        // we added this to separate it from the rest of the result on a terminal
        System.out.println("===========================================");
    }

    /**
     * this method performs Prim Algorithm on the graph.
     * first we watched Francesco Andreussi tutorial:
     *
     * @see "https://www.youtube.com/watch?v=PQWPfarpxKE&feature=youtu.be"
     * we watched the tutorial below:
     * @see "https://www.youtube.com/watch?v=agNQb6rme8U&t=318s"
     * we got the idea of having a blooean value of Permanent in the Node class from the above tutorial.
     * we also watched the bellow tutorial:
     * @see "https://www.youtube.com/watch?v=4ZlRH0eK-qQ&t=40s"
     */
    public void Prim() {
        // first, set the key and parent of the first node of our graph to 0 and null.
        nodes.get(0).setKey(0);
        nodes.get(0).setParent(null);
        // then go through the rest of the nodes in our Arraylist from index1 and set the key to infinity and set their parents to null
        for (int i = 1; i < this.nodes.size(); i++) {
            nodes.get(i).setKey(Integer.MAX_VALUE);
            nodes.get(i).setParent(null);
        }
        // go through the ArrayList, and if the current node is not permanent, set it to permanent
        for (int i = 0; i < this.nodes.size(); i++) {
            if (!nodes.get(i).Permanent) {
                nodes.get(i).Permanent = true;
                // get the Hashmap of each node and go through it and put the keys in a new Set and go through the Set
                for (Node node : nodes.get(i).getAdjacentNodes().keySet()) {
                    //if the weight of the edge is less that the key
                    if (nodes.get(i).getAdjacentNodes().get(node) < node.getKey()) {
                        // only if the node is not permanent, go and change the key to the weight of the edge, and set the parent of the node, otherwise do nothing
                        if (!node.Permanent) {
                            node.setKey(nodes.get(i).getAdjacentNodes().get(node));
                            node.setParent((nodes.get(i)));
                        }
                    } else {
                        //do nothing
                    }
                }
            }
        }
        // we are going to print the result on the terminal:
        System.out.println("Below please find the result after implementing the Prim Algorithm on your non-directional Graph:");
        // this variable is the minimum cost of the spanning tree
        int cost = 0;
        for (int i = 0; i < nodes.size(); i++) {
            // the minimum cost of our spanning tree will be the sum of the keys of our nodes
            cost = cost + nodes.get(i).getKey();

            // we will print the parent of each node as well as its child node on the terminal
            if (nodes.get(i).getParent() != null) {
                System.out.println("The Parent of " + nodes.get(i).getLabel() + " is " + nodes.get(i).getParent().getLabel());
            }
        }
        // we will print the minimum cost of the spanning tree
        System.out.println("The Cost of Spanning Tree: " + cost);


        //print the keys of nodes after implementation
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println("Key of " + nodes.get(i).getLabel() + " : " + nodes.get(i).getKey());
        }
        // ending the result of Prim algorithm
        System.out.println("===================================================");

    }


    /**
     * this method performs BellmanFord Algorithm on the graph.
     * first we watched Francesco Andreussi tutorial:
     *
     * @see "https://www.youtube.com/watch?v=f9Yuoowmxs0&feature=youtu.be"
     * we watched the tutorial below, and the code has been written by the explanation in the below tutorial:
     * @see "https://www.youtube.com/watch?v=FtN3BYH2Zes"
     */
    public void BellmanFord() {
        // key in this code is distance
        // first, set the key and parent of the first node of our graph to 0 and null.
        nodes.get(0).setKey(0);
        nodes.get(0).setParent(null);
        // then go through the rest of the nodes in our Arraylist from index1 and set the key to infinity and set their parents to null
        for (int i = 1; i < this.nodes.size(); i++) {
            nodes.get(i).setKey(Integer.MAX_VALUE);
            nodes.get(i).setParent(null);
        }
        // count is: how many times we have to perform the relaxation for our graph. it will be (the number of nodes - 1)
        int count = 1;
        System.out.println("Bellow please find your Graph after implementing the BellmanFord Algorithm: ");
        // as long as the count is less or equal than (the number of nodes -1)
        while (count <= nodes.size() - 1) {
            //begin relaxation for each node
            for (int i = 0; i < this.nodes.size(); i++) {
                // get the Hashmap of each node and go through it and put the keys in a new Set and go through the Set
                for (Node node : nodes.get(i).getAdjacentNodes().keySet()) {
                    // if a distance of node + the weight of the edge is less than a distance of another node
                    if (nodes.get(i).getKey() + nodes.get(i).getAdjacentNodes().get(node) < node.getKey()) {
                        // go and change the distance of node
                        node.setKey(nodes.get(i).getKey() + nodes.get(i).getAdjacentNodes().get(node));
                        // go and set the parent of node
                        node.setParent((nodes.get(i)));
                    } else {
                        //do nothing
                    }
                }

            }

            count++;
        }
        // now we begin to print the result on the terminal:
        // print a distance of each node
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println("Distance of " + nodes.get(i).getLabel() + " : " + nodes.get(i).getKey());
        }

        // print the parent of each node
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getParent() != null) {
                System.out.println("The Parent of " + nodes.get(i).getLabel() + " is " + nodes.get(i).getParent().getLabel());
            }
        }
        System.out.println("==================================================");


    }

    // we did not use MinHeapTemplate and MinHeapNode in our Program. we are aware of the fact that it is better for the
    // implementation of algorithms to implement MinHeap first, but we could not use it in this assignment. Hence, we came up
    // with our own solution to get the assignment done. we are aware of the fact that if we had used MinHeap tree, the time complexity of
    // Algorithms would have decreased.

    private class MinHeapTemplate {
        MinHeapNode root;

        MinHeapTemplate() {
            root = null;
        }
        // TODO: implement method for restructuring the min-priority Queue
        // TODO: implement method for extracting the smaller element from the min-priority Queue
    }

    private class MinHeapNode {
        Node node;
        MinHeapNode parent;
        MinHeapNode left;
        MinHeapNode right;

        MinHeapNode() {
            node = null;
            parent = null;
            left = null;
            right = null;
        }

        // TODO: implement additional constructors
    }
}
