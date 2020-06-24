public class Main {

    public static void main(String[] args) {
//        Node nodea = new Node("a");
//        Node nodeb = new Node("b");
//        Node nodec = new Node("c");
//        Node noded = new Node("d");
//        Node nodee = new Node("e");
//        Node nodef = new Node("f");
//
//        nodea.addConnection(nodeb,1);
//        nodea.addConnection(nodef,3);
//
//        nodeb.addConnection(nodea,1);
//        nodeb.addConnection(nodee,2);
//        nodeb.addConnection(noded,6);
//        nodeb.addConnection(nodec,4);
//
//        nodec.addConnection(nodeb,4);
//        nodec.addConnection(noded,1);
//
//        noded.addConnection(nodec,1);
//        noded.addConnection(nodeb,6);
//        noded.addConnection(nodee,5);
//        noded.addConnection(nodef,8);
//
//        nodee.addConnection(nodeb,2);
//        nodee.addConnection(noded,5);
//        nodee.addConnection(nodef,6);
//
//        nodef.addConnection(nodea,3);
//        nodef.addConnection(nodee,6);
//        nodef.addConnection(noded,8);
//
//        GraphTemplate graphTemplate = new GraphTemplate("GraphTemplate",false);
//        graphTemplate.addNode(nodef);
//        graphTemplate.addNode(nodea);
//        graphTemplate.addNode(nodeb);
//        graphTemplate.addNode(nodec);
//        graphTemplate.addNode(noded);
//        graphTemplate.addNode(nodee);
//        graphTemplate.print();
//        System.out.println("=====================");
//        graphTemplate.Prim();



        Node nodea = new Node("a");
        Node nodeb = new Node("b");
        Node nodec = new Node("c");
        Node noded = new Node("d");
        Node nodee = new Node("e");
        Node nodef = new Node("f");
        Node nodeg = new Node("g");

        nodea.addConnection(nodeb,6);
        nodea.addConnection(nodec,5);
        nodea.addConnection(noded,5);

        nodeb.addConnection(nodee,-1);

        nodec.addConnection(nodeb,-2);
        nodec.addConnection(nodee,1);

        noded.addConnection(nodec,-2);
        noded.addConnection(nodef,-1);

        nodee.addConnection(nodeg,3);

        nodef.addConnection(nodeg,3);
        GraphTemplate graphTemplate = new GraphTemplate("GraphTemplate",true);
        graphTemplate.addNode(nodea);
        graphTemplate.addNode(nodeb);
        graphTemplate.addNode(nodec);
        graphTemplate.addNode(noded);
        graphTemplate.addNode(nodee);
        graphTemplate.addNode(nodef);
        graphTemplate.addNode(nodeg);
        graphTemplate.BellmanFord();





























//        Node node1 = new Node("A");
//        Node node2 = new Node("B");
//        Node node6 = new Node("C");
//        Node node7 = new Node("D");
//        Node node5 = new Node("E");
//        Node node4 = new Node("F");
//
//        node1.adjacentNodes.put(node6,10);
//        node1.adjacentNodes.put(node2,28);
//
//        node2.adjacentNodes.put(node7,14);
//        node2.adjacentNodes.put(node4,12);
//
//        node6.adjacentNodes.put(node5,25);
//
//        node7.adjacentNodes.put(node5,24);
//        node7.adjacentNodes.put(node4,18);
//
//        node5.adjacentNodes.put(node4,22);
//
//        GraphTemplate graphTemplate = new GraphTemplate("grapghTemplate");
//        graphTemplate.nodes.add(node1);
//        graphTemplate.nodes.add(node2);
//        graphTemplate.nodes.add(node6);
//        graphTemplate.nodes.add(node7);
//        graphTemplate.nodes.add(node5);
//        graphTemplate.nodes.add(node4);
//
//        graphTemplate.print();








    }
}
