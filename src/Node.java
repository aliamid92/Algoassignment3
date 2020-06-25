import java.util.HashMap;
import java.util.Map;

/**
 * we changed the Starter code, which you posted on moodle and changed the Node class from private to public.
 * we decided to make the Node class Public so that the user can access it from the main class and create new Nodes.
 * we also made the attributes private and added Setter and Getter methods to access and manipulate the attributes.
 * we also changed the HashedMap class to Map Interface, because if the user decides to change the HashMap class to LinkedHashMap class in the future,
 * he can do it without changing the code.
 * in order to implement Prim Algorithm, we also added a boolean value of Permanent as an attribute, whose idea is derived from the below Tutorial:
 * @see "https://www.youtube.com/watch?v=agNQb6rme8U&t=318s"
 * Note: just the idea of adding a boolean value is derived from the above link, all other implementations in this class are based on programmer's ideas and thoughts.
 * We learned how to use Hashmap from Udemy Course by "Tim Buchalka"
 */
public class Node {
    private String label;
    private int key; // in Bellman-Ford we know this parameter as distance
    private Node parent;
    // this attribute is used only in Prim Algorithm
    boolean Permanent = false;
    // this attribute will store the adjacentNodes as well as their respective weights
    // Note that we used Map<>Interface, and from the Interface we have created a new Hashmap object, just in case in the future the
    // programmer wants to change it to LinkedHashmap. The Idea is derived from Udemy Course in Java by "Tim Buchala"
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    // as a constructor, we only set the label
    public Node(String label) {
        this.label = label;
    }


    /**
     * this method will add Node as well as its weight to the HashMap. If it contains the Node, it will not add it.
     * @param node
     * @param weight
     * @return boolean
     */
    public boolean addConnection(Node node, int weight) {
        // if the HashMap contains the Node, do not add it
        if (adjacentNodes.containsKey(node)) {
            return false;
        } else {
            // add "node:weight" to the Hashmap
            adjacentNodes.put(node, weight);
            return true;
        }

    }

    /**
     * this method will remove the Node as well as its weight from the HashMap only if it contains the Node
     * @param node
     * @return boolean
     */

    public boolean removeConnection(Node node) {
        if (adjacentNodes.containsKey(node)) {
            adjacentNodes.remove(node);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Getter method for getting a label
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Getter method for getting key
     * @return key
     */
    public int getKey() {
        return key;
    }

    /**
     * Getter method for getting parent
     * @return parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Getter method for getAdjacentNodes Hashmap
     * @return adjacentNodes Hashmap
     */
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    /**
     * Setter method for setting Key value
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Setter method for setting a parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }


}
