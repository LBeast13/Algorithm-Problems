import java.util.LinkedList;
import java.util.Queue;

/**
 * PROBLEM 4.1 : Route Between Nodes
 * 
 * Given a directed graph, design an algorithm to find out whether 
 * there is a route between two nodes.
 */
public class Problem4_1{
    public static void main(String[] args){

        // Init
        Graph graph = buildGraph();
        graph.display();
        Node from = graph.getNode("A");
        Node target = graph.getNode("D");

        // Solve
        String answer = (searchRoute(from,target)) ? "There is a route between the Nodes" : "There is NO route between the Nodes";
        
        // Output
        System.out.println(answer);
    }

    /**
     * SOLUTION :
     * 
     * Runtime Complexity :
     * Space Complexity : O(N+M) where N are the Nodes and M the edges between them
     * 
     * The idea is to take one of the two nodes as root and the other
     * one as the target. We apply the BFS algorithm from the root
     * and if during the algorithm the current node is the target
     * then we have found a route between the two nodes.
     * If the BFS algorithm reach the end, that means we did not
     * visit the target node and there is no such route.
     * 
     * @param root The root for the BFS start
     * @param target The node we want to reach
     * @return True if the target is reached, false otherwise.
     */
    public static boolean searchRoute(Node root, Node target){
        if(root.equals(target)){
            return true;
        }

        Queue<Node> queue = new LinkedList<Node>();
        root.state = State.VISITING;
        queue.add(root);
        Node n;

        // Loop while all the reachable nodes from the root are not all explored.
        while(!queue.isEmpty()){
            // displayQueue(queue);  // DEBUG
            n = queue.poll();

            if(n != null){
                // System.out.print("Neighbors ("+ n.getNeighbors().size() + ") : ");  // DEBUG

                for(Node node : n.getNeighbors()){
                    // System.out.print(node.getName() + " ");   // DEBUG
                    if(node.state == State.UNVISITED){
                        if(node.equals(target)){
                            return true;
                        }
                        node.state = State.VISITING;
                        queue.add(node);
                    }
                }
                //System.out.println(" "); // DEBUG
                n.state = State.VISITED;
            }   
        }
        return false;
    }

    /**
     * Build a directed Graph
     */
    public static Graph buildGraph(){
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("D", "C");
        graph.addEdge("C", "D");

        return graph;
    }

    /* USED FOR DEBUGGING

    public static void displayQueue(Queue<Node> queue){
        System.out.print("Queue : ");
        for(Node n : queue){
            System.out.print(n.getName() + " ");
        }
        System.out.println(" ");
    }
    */
}