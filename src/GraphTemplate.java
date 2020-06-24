import java.util.ArrayList;
import java.util.List;

public class GraphTemplate {
    String name;
    private List<Node> nodes = new ArrayList<>();
    MinHeapTemplate minPriorityQueue;
    boolean isDirected;

    public GraphTemplate(String name, Boolean isDirected) {
        this.name = name;
        // By default it will be non-directional
        this.isDirected = isDirected;
    }

    public List<Node> getAListOfNodes() {
        return nodes;
    }

    public boolean addNode(Node node) {
        if (nodes.contains(node)) {
            return false;
        } else {
            nodes.add(node);
            return true;
        }
    }

    public boolean removeNode(Node node) {
        if (nodes.contains(node)) {
            nodes.remove(node);
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println("Bellow please find your Graph: ");
        for (int i = 0; i < nodes.size(); i++) {
            for (Node node : nodes.get(i).addConnection().keySet()) {
                System.out.println(nodes.get(i).getLabel() + " ------> " + node.getLabel());
            }
        }
        System.out.println("===========================================");
    }

    public void Prim() {
        nodes.get(0).setKey(0);
        nodes.get(0).setParent(null);
        for (int i = 1; i < this.nodes.size(); i++) {
            nodes.get(i).setKey(Integer.MAX_VALUE);
            nodes.get(i).setParent(null);
        }
        for (int i = 0; i < this.nodes.size(); i++) {
            if (!nodes.get(i).Permanent) {
                nodes.get(i).Permanent = true;
                for (Node node : nodes.get(i).getAdjacentNodes().keySet()) {
                    if (nodes.get(i).getAdjacentNodes().get(node) < node.getKey()) {
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
        System.out.println("Below please find the result after implementing the Prim Algorithm on your non-directional Graph:");
        int cost = 0;
        for (int i = 0; i < nodes.size(); i++) {
            cost = cost + nodes.get(i).getKey();

            if (nodes.get(i).getParent() != null) {
                System.out.println("The Parent of " + nodes.get(i).getLabel() + " is " + nodes.get(i).getParent().getLabel());
            }
        }
        System.out.println("The Cost of Spanning Tree: " + cost);


        //print the keys of nodes after implementation
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println("Key of " +nodes.get(i).getLabel() + " : " + nodes.get(i).getKey());
        }
        System.out.println("===================================================");


    }

    public void BellmanFord(){
        // key in this code is distance
        nodes.get(0).setKey(0);
        nodes.get(0).setParent(null);
        for (int i = 1; i < this.nodes.size(); i++) {
            nodes.get(i).setKey(Integer.MAX_VALUE);
            nodes.get(i).setParent(null);
        }
        int count = 1;
        System.out.println("Bellow please find your Graph after implementing the BellmanFord Algorithm: ");
        while (count<=nodes.size()-1){
            //begin relaxation
            for (int i = 0; i < this.nodes.size(); i++) {
                for (Node node : nodes.get(i).getAdjacentNodes().keySet()) {
                    if(nodes.get(i).getKey()+nodes.get(i).getAdjacentNodes().get(node)<node.getKey()){
                        node.setKey(nodes.get(i).getKey()+nodes.get(i).getAdjacentNodes().get(node));
                        node.setParent((nodes.get(i)));
                    }else{
                        //do nothing
                    }
                }

            }


            count++;
        }
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println("Distance of " +nodes.get(i).getLabel() + " : " + nodes.get(i).getKey());
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getParent() != null) {
                System.out.println("The Parent of " + nodes.get(i).getLabel() + " is " + nodes.get(i).getParent().getLabel());
            }
        }
        System.out.println("==================================================");




    }

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
