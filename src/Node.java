public class Node
{
    private Character value;
    private Node left;
    private Node right;

    public Node(final Character value)
    {
        this.value = value;
    }
    public void setLeft(final Node left)
    {
        this.left = left;
    }
    public void setRight(final Node right)
    {
        this.right = right;
    }
}