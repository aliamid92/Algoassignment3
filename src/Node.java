import java.util.HashMap;
import java.util.Map;

public class Node{
    private String label;
    private int key; // in Bellman-Ford we know this parameter as distance
    private Node parent;
    boolean Permanent = false;
    private Map<Node,Integer> adjacentNodes = new HashMap<>();


    public Node(String label) {
        this.label = label;
    }

    public boolean addConnection(Node node, int weight){
        if (adjacentNodes.containsKey(node)){
            return false;
        }else{
            adjacentNodes.put(node,weight);
            return true;
        }

    }

    public boolean removeConnection(Node node){
        if (adjacentNodes.containsKey(node)){
            adjacentNodes.remove(node);
            return true;

        }else{
            return false;
        }
    }

    public String getLabel() {
        return label;
    }

    public int getKey() {
        return key;
    }

    public Node getParent() {
        return parent;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public Map<Node, Integer> addConnection() {
        return adjacentNodes;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }


}
