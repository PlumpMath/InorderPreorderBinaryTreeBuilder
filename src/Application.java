import java.util.Arrays;
import java.util.List;

public class Application
{
    public static void main(String[] args)
    {
        //List<Character> inorder = Arrays.asList('D', 'B', 'E', 'A', 'F', 'C');
        //List<Character> preorder = Arrays.asList('A', 'B', 'D', 'E', 'C', 'F');

        List<Character> inorder = Arrays.asList('W', 'R', 'Z', 'C', 'P', 'Q', 'T', 'F', 'L', 'A', 'X');
        List<Character> preorder = Arrays.asList('Q', 'R', 'W', 'C', 'Z', 'P', 'X', 'L', 'F', 'T', 'A');

        InorderPreorderBinaryTreeBuilder builder = new InorderPreorderBinaryTreeBuilder();
        Node tree = builder.BuildNode(inorder, preorder);
    }
}