import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

/**
 * PROBLEM 4.3 : List of Depth
 * 
 * Given a binary tree, design an algorithm which creates a linked list 
 * of all the nodes at each depth (e.g. if you have a tree with depth D, you'll have D linked lists).
 */
public class Problem4_3{
    public static void main(String[] args){

        // Init
        Graph graph = buildBinaryTree();
        graph.display();

        // Solve
        Node root = graph.getNode("4");
        ArrayList<LinkedList<Node>> depthLists = getListsByDepth(root);

        // Output
        display(depthLists);
    }

    /**
     * SOLUTION
     * 
     * Runtime Complexity : O(N)
     * 
     * To solve this problem I adapted the BFS algorithm to traverse the binary tree.
     * I used to queues :
     *      - One to keep track of all the nodes of the current depth
     *      - One to keep track of the direct children of each nodes of the current depth
     * When a node at the current depth is explored (children added to the second queue)
     * we remove it from the queue and insert it in the linked list for this depth.
     * When all the nodes of this current depth are explored (first queue is empty), then 
     * we create a new linked list and we transfer the Nodes of the second queue to the first queue.
     * We do this process until both queues are empty because that means that the tree was fully
     * explored.
     * 
     */
    public static ArrayList<LinkedList<Node>> getListsByDepth(Node root){
        // Create the data structures
        ArrayList<LinkedList<Node>> depthLists = new ArrayList<LinkedList<Node>>();
        Queue<Node> currDepth = new LinkedList<Node>();
        Queue<Node> nextDepth = new LinkedList<Node>();

        currDepth.add(root);

        // Used to keep track of the depth level and the linked lists creation
        boolean isNewDepth = true;

        // Loop while the tree is not fully traversed
        while(!currDepth.isEmpty() || !nextDepth.isEmpty()){

            // Create a new linked list for a new depth level
            if(isNewDepth){
                depthLists.add(new LinkedList<Node>());
            }

            isNewDepth = false;
            Node curr = currDepth.poll();

            for(Node n : curr.getNeighbors()){
                nextDepth.add(n);
            }

            depthLists.get(depthLists.size()-1).add(curr);

            // Change depth level if all the nodes of the current depth are explored
            if(currDepth.isEmpty()){
                while(!nextDepth.isEmpty()){
                    currDepth.add(nextDepth.poll());
                }
                isNewDepth = true;
            }
        }

        return depthLists;
    }

    /**
     * Display the depth lists
     * @param listOfLists the output 
     */
    public static void display(ArrayList<LinkedList<Node>> listOfLists){
        int depth = 1;

        System.out.println("The max depth is " + listOfLists.size());
        for(LinkedList<Node> list : listOfLists){
            System.out.print("Depth level " + depth + " : ");

            for(Node node: list){
                System.out.print(node.getName() + " ");
            }
            System.out.println(" ");
            depth++;
        }
    }

    /**
     * Build a Binary tree for testing
     * @return a binary tree
     */
    public static Graph buildBinaryTree(){
        Graph g = new Graph();
        g.addNode("4");
        g.addNode("2");
        g.addNode("5");
        g.addNode("8");
        g.addNode("6");
        g.addNode("7");
        g.addNode("3");

        g.addEdge("4", "2");
        g.addEdge("4", "5");
        g.addEdge("2", "8");
        g.addEdge("5", "6");
        g.addEdge("5", "7");
        g.addEdge("6", "3");

        return g;
    }
}