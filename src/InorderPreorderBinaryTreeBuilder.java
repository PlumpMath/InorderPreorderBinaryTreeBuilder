import java.util.ArrayList;
import java.util.List;

/**
 * Create a binary tree from preorder and inorder listings of its nodes
 * Created by bryan on 8/29/2015.
 */
public class InorderPreorderBinaryTreeBuilder
{
    private final int ROOT_NODE = 0;
    private final int ZERO = 0;

    /**
     * Recurse nodes considering a 3 node segment at a time (parent node, left and right child nodes)
     * using inorder and preorder binary tree lists
     * @param inorder inorder listing of nodes of a binary tree
     * @param preorder preorder listing of nodes of a binary tree
     * @return Returns a Node with references to existing child nodes or null for the end of a tree, return of initial call references the full tree
     */
    public Node BuildNode(List<Character> inorder, List<Character> preorder)
    {
        // TODO: investigate error checks for incoming variables
        // Such as initial lists not containing same number of nodes

        //Base Case: Handles bottom of tree
        if ((inorder.size() != preorder.size()) || (inorder.size() == ZERO && preorder.size() == ZERO))
            return null;

        // Set node value
        Character rootChar = preorder.get(ROOT_NODE);
        Node node = new Node(rootChar);

        // Create pruned lists for recursive calls, culling nodes that can ommitted from further processing
        // This is done by logically determining nodes belonging to the left and right hand side of a parent
        List<Character> RightSubTreeInorder = inorder.subList(inorder.indexOf(rootChar) + 1, inorder.size());
        List<Character> LeftSubTreeInorder = inorder.subList(ROOT_NODE, inorder.indexOf(rootChar));
        List<Character> RightSubTreePreOrder = new ArrayList<Character>(preorder);
        List<Character> LeftSubTreePreOrder = new ArrayList<Character>(preorder);
        RightSubTreePreOrder.retainAll(RightSubTreeInorder);
        LeftSubTreePreOrder.retainAll(LeftSubTreeInorder);

        //Recurse on child nodes
        node.setRight(BuildNode(RightSubTreeInorder, RightSubTreePreOrder));
        node.setLeft(BuildNode(LeftSubTreeInorder, LeftSubTreePreOrder));

        return node;
    }
}
