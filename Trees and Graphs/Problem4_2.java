/**
 * PROBLEM 4.2 : Minimal Tree
 * 
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree (BST) with minimal
 * height.
 */
public class Problem4_2{
    public static void main(String[] args){

        //Init
        int [] arr = {0, 1, 2, 3, 4};

        System.out.println(buildMinBST(arr).data);
    }

    /**
     * This is the "black box" function : this call the real solving function.
     * @param arr The sorted array
     * @return The root of the Tree
     */
    public static TreeNode buildMinBST(int[] arr){
        return buildMinBST(arr, 0, arr.length - 1);
    }

    /**
     * SOLUTION
     * 
     * The key point here is that we have a SORTED array and we want a MINIMAL
     * binary search tree (the root has the same number of elements on the left 
     * and on the right).
     * Then, if we take the middle element of the array, this will be the root of
     * the BST.
     * We have now two "sub arrays" (left and right), we can take the middle of each
     * one and then we have the two following nodes en so on.
     * A good solution for this problem is the recursion, indeed we have a big problem
     * that we can separate in several small problems.
     * 
     * @param arr The initial sorted array.
     * @param start The start index for the sub array.
     * @param end The end index for the sub array.
     * @return The root of the sub BST.
     */
    public static TreeNode buildMinBST(int[] arr, int start, int end){
        if(end < start){    // End a recursion (no more elements for a sub array)
            return null;
        }

        int mid = (start + end) / 2;    // The middle of the sub array
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildMinBST(arr, start, mid - 1);
        node.right = buildMinBST(arr, mid + 1, end);
        return node;
    }

    /**
     * The Tree Node Class
     */
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }
}