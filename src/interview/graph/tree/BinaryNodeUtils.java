package interview.graph.tree;

public class BinaryNodeUtils {

    public static BinaryNode simpleBinaryTree() {
/**
 *         (1)
 *        /   \
 *      (2)   (3)
 *      / \
 *    (4)  (5)
 *
 **/
        return new BinaryNode(1,
                new BinaryNode(3),
                new BinaryNode(2,
                        new BinaryNode(5), new BinaryNode(4)));

    }
}
