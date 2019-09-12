import java.util.ArrayList;

/**
 * The Node class (for a graph)
 */
public class Node{
    private String name;
    private ArrayList<Node> neighbors;
    public State state;

    public Node(String name){
        this.name = name;
        this.neighbors = new ArrayList<Node>();
        this.state = State.UNVISITED;
    }

    /**
     * Add a neighbor to the current Node's neighbors list.
     * @param neighbor The new neighbor Node
     */
    public void addNeighbor(Node neighbor){
        this.neighbors.add(neighbor);
    }

    @Override
    public boolean equals(Object node){
        return this.name.equals(((Node) node).getName());
    }

    // Getters

    public String getName(){
        return this.name;
    }

    public ArrayList<Node> getNeighbors(){
        return this.neighbors;
    }
}