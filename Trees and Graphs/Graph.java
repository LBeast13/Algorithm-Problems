import java.util.ArrayList;

/**
 * The Graph class
 */
public class Graph{
    private ArrayList<Node> nodes;

    public Graph(){
        this.nodes = new ArrayList();
    }

    /**
     * Create and add a new node to the Graph
     * @param name the new node's name
     */
    public void addNode(String name){
        this.nodes.add(new Node(name));
    }

    /**
     * Add an edge from the fromName named node to the toName named node.
     * @param fromName The name of the first node
     * @param toName The name of the target node
     */
    public void addEdge(String fromName, String toName){
        if(this.nodes.isEmpty()){
            return;
        }

        for(Node from : this.nodes){
            if(from.getName().equals(fromName)){
                for(Node to : this.nodes){
                    if(to.getName().equals(toName)){
                        from.addNeighbor(to);
                        return;
                    }
                }
                break; // Error the target Node does not exist
            }
        }
    }

    /**
     * Get the node with the specified name
     * @param name The node name
     * @return The node with the given name, return null if the search failed
     */
    public Node getNode(String name){
        for(Node n : this.nodes){
            if(n.getName().equals(name)){
                return n;
            }
        }
        return null;
    }

    /**
     * Display in the console the full graph as an Adjacency List.
     */
    public void display(){
        for(Node n : this.nodes){
            System.out.print(n.getName() + " ("+ n.getNeighbors().size() +") --> ");
            for(Node neighbor : n.getNeighbors()){
                System.out.print(neighbor.getName() + " ");
            }
            System.out.println(" ");
        }
    }

    // Getters

    public ArrayList<Node> getNodes(){
        return this.nodes;
    }
}