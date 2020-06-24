import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
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
        nodeA.addConnection(nodeB,1);
        nodeA.addConnection(nodeF,3);

        nodeB.addConnection(nodeA,1);
        nodeB.addConnection(nodeE,2);
        nodeB.addConnection(nodeD,6);
        nodeB.addConnection(nodeC,4);

        nodeC.addConnection(nodeB,4);
        nodeC.addConnection(nodeD,1);

        nodeD.addConnection(nodeC,1);
        nodeD.addConnection(nodeB,6);
        nodeD.addConnection(nodeE,5);
        nodeD.addConnection(nodeF,8);

        nodeE.addConnection(nodeB,2);
        nodeE.addConnection(nodeD,5);
        nodeE.addConnection(nodeF,6);

        nodeF.addConnection(nodeA,3);
        nodeF.addConnection(nodeE,6);
        nodeF.addConnection(nodeD,8);

        // we create a new GraphTemplate object and pass its name and the status of the Graph (IsDirected).
        GraphTemplate graphTemplate1 = new GraphTemplate("GraphTemplate1",false);
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
         * In order to notice that BellmanFord Algorithm works fine in our Program, we used the below example as a Graph in this part:
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

        printBST(graphTemplate1);








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


    // this method will go through the BinaryTree and will create tree.gv file in the directory
    public static void printBST(GraphTemplate graphTemplate) {
        String graphDescription = GraphtoString(graphTemplate);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("graph.gv"));
            writer.write(graphDescription);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("graph.gv file has been created");

    }


    // this method will write .dot language and describe the overall structure of .gv file
    private static String GraphtoString(GraphTemplate graphTemplate) {
        StringBuilder graphStatement = new StringBuilder();
        graphStatement.append("digraph G {\n");
        graphStatement.append("graph [ dpi = 200 ]\n");
        graphStatement.append("node [fontname=Arial ];\n");
        graphStatement.append("node [shape=circle];\n");
        graphStatement.append("edge [arrowsize=1];\n");

        StringBuilder graphcontent = getGraphContent(new StringBuilder(), graphTemplate.getAListOfNodes());
        graphStatement.append(graphcontent);

        graphStatement.append("}");
        String GraphStatement = graphStatement.toString();

        return GraphStatement;
    }


    // this method will go through the BinaryTree and add Nodes in .dot language to the.gv file
    private static StringBuilder getGraphContent(StringBuilder graphStatement, List<Node> listOfNodes) {
        for (int i = 0; i < listOfNodes.size(); i++) {
            if (listOfNodes.get(i).getParent() != null) {
                graphStatement.append(String.format("node%s [label=\"%s\"];\n", listOfNodes.get(i).getLabel(), listOfNodes.get(i).getLabel()));
                graphStatement.append(String.format("node%s -> node%s;\n", listOfNodes.get(i).getParent().getLabel(), listOfNodes.get(i).getLabel()));
            }
        }
        graphStatement.append(String.format("node%s [label=\"%s\"];\n", listOfNodes.get(0).getLabel(), listOfNodes.get(0).getLabel()));

        return graphStatement;
    }
}












