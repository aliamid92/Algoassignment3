import java.util.HashMap;
import java.util.Map;

public class Node {
    private String label;
    private int key; //distance
    private Node parent;
    boolean Permanent = false;
    private Map<Node,Integer> getaadjacentNodes = new HashMap<>();


    public Node(String label) {
        this.label = label;
    }

    public boolean addConnection(Node node, int weight){
        if (getaadjacentNodes.containsKey(node)){
            return false;
        }else{
            getaadjacentNodes.put(node,weight);
            return true;
        }

    }

    public boolean removeConnection(Node node){
        if (getaadjacentNodes.containsKey(node)){
            getaadjacentNodes.remove(node);
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

    public Map<Node, Integer> getGetaadjacentNodes() {
        return getaadjacentNodes;
    }

    public Map<Node, Integer> addConnection() {
        return getaadjacentNodes;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
