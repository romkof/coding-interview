package interview.graph.tree;

public class BinaryNode {
    private BinaryNode left;
    private BinaryNode right;
    private int value;

    public BinaryNode(int value, BinaryNode right, BinaryNode left) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public BinaryNode(int value) {
        this.value = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

}
