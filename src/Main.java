import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         * In order to notice that Prim Algorithm works fine in our Program, we used the below example as a Graph described by Francesco Andreussi in his tutorial:
         * @see "https://www.youtube.com/watch?v=PQWPfarpxKE&feature=youtu.be"
         */

        // this is the first example of non-directional Graph for implementing the Prim Algorithm
        // First we create Nodes:
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");


        // we add connections to each Node as well as the weight of each edge. The Node class has a method called addConnection(Node,int)
        // which stores the node as well as the weight of each edge in the HashedMap, which is described in Node Class.
        nodeA.addConnection(nodeB, 1);
        nodeA.addConnection(nodeF, 3);

        nodeB.addConnection(nodeA, 1);
        nodeB.addConnection(nodeE, 2);
        nodeB.addConnection(nodeD, 6);
        nodeB.addConnection(nodeC, 4);

        nodeC.addConnection(nodeB, 4);
        nodeC.addConnection(nodeD, 1);

        nodeD.addConnection(nodeC, 1);
        nodeD.addConnection(nodeB, 6);
        nodeD.addConnection(nodeE, 5);
        nodeD.addConnection(nodeF, 8);

        nodeE.addConnection(nodeB, 2);
        nodeE.addConnection(nodeD, 5);
        nodeE.addConnection(nodeF, 6);

        nodeF.addConnection(nodeA, 3);
        nodeF.addConnection(nodeE, 6);
        nodeF.addConnection(nodeD, 8);

        // we create a new GraphTemplate object and pass its name and the status of the Graph (IsDirected).
        GraphTemplate graphTemplate1 = new GraphTemplate("GraphTemplate1", false);
        // then we will add our pre-defined Nodes to our Graph using the addNode(Node) method, which is described in the GraphTemplate class.
        graphTemplate1.addNode(nodeF);
        graphTemplate1.addNode(nodeA);
        graphTemplate1.addNode(nodeB);
        graphTemplate1.addNode(nodeC);
        graphTemplate1.addNode(nodeD);
        graphTemplate1.addNode(nodeE);
        // we can use print() method in the GraphTemplate class to see our graph on the terminal
        graphTemplate1.print();
        // implement the Prim algorithm on our Graph and then print the results on the terminal after implementation of the algorithm.
        graphTemplate1.Prim();


        // this is the first example of directional Graph for implementing the BellmanFord Algorithm
        /**
         * In order to notice that BellmanFord Algorithm works fine in our Program, we used the below example as a Graph:
         * @see "https://www.youtube.com/watch?v=FtN3BYH2Zes&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=54&t=673s"
         * at 8:31 minute of this tutorial, you can see the results and check it with our results
         */

        // First we create Nodes:
        Node nodea = new Node("a");
        Node nodeb = new Node("b");
        Node nodec = new Node("c");
        Node noded = new Node("d");
        Node nodee = new Node("e");
        Node nodef = new Node("f");
        Node nodeg = new Node("g");

        // we add connections to each Node as well as the weight of each edge. The Node class has a method called addConnection(Node,int)
        // which stores the node as well as the weight of each edge in the HashedMap, which is described in Node Class.
        // The edge can have negative weight in BellmanFord Algorithm:
        nodea.addConnection(nodeb, 6);
        nodea.addConnection(nodec, 5);
        nodea.addConnection(noded, 5);

        nodeb.addConnection(nodee, -1);

        nodec.addConnection(nodeb, -2);
        nodec.addConnection(nodee, 1);

        noded.addConnection(nodec, -2);
        noded.addConnection(nodef, -1);

        nodee.addConnection(nodeg, 3);

        nodef.addConnection(nodeg, 3);

        // we create a new GraphTemplate object and pass its name and the status of the Graph (IsDirected).
        GraphTemplate graphTemplate2 = new GraphTemplate("GraphTemplate2", true);
        // then we will add our pre-defined Nodes to our Graph using the addNode(Node) method, which is described in the GraphTemplate class.
        graphTemplate2.addNode(nodea);
        graphTemplate2.addNode(nodeb);
        graphTemplate2.addNode(nodec);
        graphTemplate2.addNode(noded);
        graphTemplate2.addNode(nodee);
        graphTemplate2.addNode(nodef);
        graphTemplate2.addNode(nodeg);
        // implement the BellmanFord algorithm on our Graph and then print the results on the terminal after implementation of the algorithm.
        graphTemplate2.BellmanFord();


        // here you can use printGraph() method and pass your Graph as a parameter (only after implementing one of the algorithms on it)
        // to create .gv file in dot notation format. it only works after the implementation of either Prim or BellmanFord Algorithms

        printGraph(graphTemplate1);


        /**
         * the below is the second example of a directed graph, used by Francesco Andreussi in his tutorial:
         * @see "https://www.youtube.com/watch?v=f9Yuoowmxs0&feature=youtu.be"
         * please uncomment it to see the results.
         * implementation of the below example has some bugs. if you change the order of adding nodes to the graph, the result will not be correct.
         */

//-----------------------------------> Please uncomment it to see the result of the second example graph for BellmanFord Algorithm
//        Node nodea = new Node("a");
//        Node nodeb = new Node("b");
//        Node nodec = new Node("c");
//        Node noded = new Node("d");
//        Node nodee = new Node("e");
//        Node nodef = new Node("f");
//
//        nodea.addConnection(nodee, 7);
//        nodea.addConnection(nodef, 5);
//
//        nodeb.addConnection(nodea, 1);
//        nodeb.addConnection(nodec, 3);
//
//        nodec.addConnection(noded, 9);
//
//        noded.addConnection(nodec, 3);
//        noded.addConnection(nodee, 2);
//        noded.addConnection(nodef, 1);
//
//        nodee.addConnection(nodeb, 2);
//        nodee.addConnection(nodec, 4);
//
//        nodef.addConnection(nodee, 2);
//
//        GraphTemplate graphTemplate2 = new GraphTemplate("graphTemplate2",true);
//        graphTemplate2.addNode(nodea);
//        graphTemplate2.addNode(nodee);
//        graphTemplate2.addNode(nodeb);
//        graphTemplate2.addNode(nodef);
//        graphTemplate2.addNode(nodec);
//        graphTemplate2.addNode(noded);
//
//        graphTemplate2.BellmanFord();
//        printBST(graphTemplate2);


    }

    /**
     * This method will create .gv file in dot notation format in your current directory.
     * Note: this method only works after the implementation of either a Prim or BellmanFord Algorithm on your graph.
     * do not use it to create .gv file of your Graph before implementing Prim or BellmanFord Algorithm.
     * if you want to see your graph before the implementation of Prim or BellmanFord Algorithm, use print() method in GraphTemplate class to
     * see it on a terminal.
     *
     * @param graphTemplate --> pass your graph as a parameter to this method
     * we got the overall Idea of how to create .gv file and using the StringBuilder class in Java from the bellow website:
     * @see "https://rafal.io/posts/binary-trees.html#visualizing-a-tree-with-dotgraphviz"
     */
    public static void printGraph(GraphTemplate graphTemplate) {
        // we create a new String variable and call GraphtoString() method to return a String
        String graphDescription = GraphtoString(graphTemplate);
        // we will create a new BufferedWriter object and set it to null
        BufferedWriter writer = null;
        try {
            // we will instantiate the BufferedWriter and call the file graph.gv
            writer = new BufferedWriter(new FileWriter("graph.gv"));
            // add the statements to the file
            writer.write(graphDescription);
            // close the file
            writer.close();
            // if the program cannot do the above operations, it will throw IOException
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("graph.gv file has been created");

    }

    /**
     * this method describes the overall structure of .gv file in dot format notation.
     * this method is private so that the user can not reach it directly.
     *
     * @param graphTemplate --> pass the Graph as a parameter
     * @return String
     */
    private static String GraphtoString(GraphTemplate graphTemplate) {
        // we create a new Stringbuilder object and then use append() method to add our statements to it
        StringBuilder graphStatement = new StringBuilder();
        // we describe the overall view of the .gv file, like the shape of our nodes, font and arrow size, which are constant in dot notation format
        graphStatement.append("digraph G {\n");
        graphStatement.append("graph [ dpi = 200 ]\n");
        graphStatement.append("node [fontname=Arial ];\n");
        graphStatement.append("node [shape=circle];\n");
        graphStatement.append("edge [arrowsize=1];\n");

        // we create a new String builder Object and its value will be set by getGrapgh() method.
        //we will pass a list of Nodes of our GraphTemplate object as a parameter to it
        StringBuilder graphcontent = getGraphContent(new StringBuilder(), graphTemplate.getAListOfNodes());
        // then we will add the contents of our graphcontent which is a string to our graphStatement
        graphStatement.append(graphcontent);
        // we will add "}" to end our .gv file
        graphStatement.append("}");
        // then we will convert GraphStatement to String and return it
        String GraphStatement = graphStatement.toString();

        return GraphStatement;
    }


    /**
     * This method will go through your Graph (after implementation of either Prim or BellmanFord Algorithm)
     * and will create nodes in dot format notation according to the result of the algorithms (their parents)
     *
     * @param graphStatement --> we need it as parameter to then add more statements to it as we are going through the graph
     * @param listOfNodes    --> we need to access the list of nodes of our graph in order to create .gv file
     * @return StringBuilder
     * we came up with the below solution ourselves. we did not use any resources for this.
     */
    private static StringBuilder getGraphContent(StringBuilder graphStatement, List<Node> listOfNodes) {
        // first we go through a list of nodes in our graph
        for (int i = 0; i < listOfNodes.size(); i++) {
            // if the Parent of the Node is not null
            if (listOfNodes.get(i).getParent() != null) {
                //we will get the label of the node and create a new statement in dot format notation and will add it to graphStatement
                graphStatement.append(String.format("node%s [label=\"%s\"];\n", listOfNodes.get(i).getLabel(), listOfNodes.get(i).getLabel()));
                //listOfNodes.get(i).getParent().getLabel() is a parent label of the node, and listOfNodes.get(i).getLabel() is the label of our node
                // we create a new statement in dot language and then we will add to to our graphStatement
                graphStatement.append(String.format("node%s -> node%s;\n", listOfNodes.get(i).getParent().getLabel(), listOfNodes.get(i).getLabel()));
            }
        }
        // Since the parent of our first node is always null, we will add this statement to always add the label of our first node to our graph
        graphStatement.append(String.format("node%s [label=\"%s\"];\n", listOfNodes.get(0).getLabel(), listOfNodes.get(0).getLabel()));

        return graphStatement;
    }
}












