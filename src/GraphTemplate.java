import java.util.ArrayList;
import java.util.List;

public class GraphTemplate {
    String name;
    private List<Node> nodes = new ArrayList<>();
    MinHeapTemplate minPriorityQueue;
    boolean isDirected;

    public GraphTemplate(String name) {
        this.name = name;
        // By default it will be non-directional
        this.isDirected=false;
    }

    public List<Node> getAListOfNodes() {
        return nodes;
    }

    public boolean addNode(Node node){
        if (nodes.contains(node)){
            return false;
        }else{
            nodes.add(node);
            return true;
        }
    }

    public boolean removeNode(Node node){
        if (nodes.contains(node)){
            nodes.remove(node);
            return true;
        }else {
            return false;
        }
    }

    public void print(){
        for (int i=0; i<nodes.size(); i++){
            for (Node node: nodes.get(i).addConnection().keySet()){
                System.out.println(nodes.get(i).getLabel() + " ------> "+ node.getLabel());
            }
        }
    }

    public void Prim(){
        nodes.get(0).setKey(0);
        nodes.get(0).setParent(null);
        for (int i=1; i<this.nodes.size(); i++){
            nodes.get(i).setKey(Integer.MAX_VALUE);
            nodes.get(i).setParent(null);
        }
        for (int i=0; i<this.nodes.size(); i++){
            if(!nodes.get(i).Permanent){
                nodes.get(i).Permanent = true;
            }
            for (Node node: nodes.get(i).getGetaadjacentNodes().keySet()){
                if(nodes.get(i).getGetaadjacentNodes().get(node)<node.getKey()){
                    if (!node.Permanent) {
                        node.setKey(nodes.get(i).getGetaadjacentNodes().get(node));
                        node.setParent((nodes.get(i)));
                    }
                }else{
                    //do nothing
                }
            }

        }









//        minPriorityQueue = new MinHeapTemplate();
//        //then we have to add the nodes to minPriorityQueue
//        for (int i=0; i<this.nodes.size(); i++){
//            for (Node node: nodes.get(i).addConnection().keySet()){
//                if(nodes.get(i).addConnection().get(node)<node.getKey()){
//                    node.setKey(nodes.get(i).addConnection().get(node));
//                    node.setParent(this.nodes.get(i));
//                }else{
//                    //do nothing
//                }
//            }
//        }
//        int cost = 0;
        for (int i=0; i<nodes.size();i++) {
            if (nodes.get(i).getParent() != null) {
                System.out.println(nodes.get(i).getLabel() + " parent: " + nodes.get(i).getParent().getLabel());
            }
        }
//
//
//            if(nodes.get(i).getParent() != null && nodes.get(i).getGetaadjacentNodes().get(nodes.get(i).getParent().getLabel()) != null){
//
//                cost = cost + nodes.get(i).getGetaadjacentNodes().get(nodes.get(i).getParent().getLabel());
//            }else{
//                //do nothing
//            }
//        }
//        System.out.println("Cost: " + cost);



        //print the keys of nodes after implementation
        for (int i =0; i<nodes.size(); i++){
            System.out.println(nodes.get(i).getLabel() +" : "+ nodes.get(i).getKey());
        }



    }

    private class MinHeapTemplate{
        MinHeapNode root;

        MinHeapTemplate(){
            root = null;
        }
        // TODO: implement method for restructuring the min-priority Queue
        // TODO: implement method for extracting the smaller element from the min-priority Queue
    }

    private class MinHeapNode{
        Node node;
        MinHeapNode parent;
        MinHeapNode left;
        MinHeapNode right;

        MinHeapNode(){
            node = null;
            parent = null;
            left = null;
            right = null;
        }

        // TODO: implement additional constructors
    }
}
