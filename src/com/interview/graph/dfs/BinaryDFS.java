package com.interview.graph.dfs;

import com.interview.graph.BinaryNode;
import com.interview.graph.BinaryNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import static com.interview.graph.Utils.isQuals;

public class BinaryDFS {

    //Left-Root-Right
    public static void preOrderTraversalRecursive(BinaryNode node, Consumer<Integer> traversalFun ) {
        if (node == null)
            return;
        traversalFun.accept(node.getValue());
        preOrderTraversalRecursive(node.getLeft(), traversalFun);
        preOrderTraversalRecursive(node.getRight(), traversalFun);
    }

    //Root-Left-Right
    public static void inOrderTraversalRecursive(BinaryNode node, Consumer<Integer> traversalFun ) {
        if (node == null)
            return;
        inOrderTraversalRecursive(node.getLeft(), traversalFun);
        traversalFun.accept(node.getValue());
        inOrderTraversalRecursive(node.getRight(), traversalFun);
    }

    //Left-Right-Root
    public static void postOrderTraversalRecursive(BinaryNode node, Consumer<Integer> traversalFun ) {
        if (node == null)
            return;
        postOrderTraversalRecursive(node.getLeft(), traversalFun);
        postOrderTraversalRecursive(node.getRight(), traversalFun);
        traversalFun.accept(node.getValue());
    }

    public static void main(String[] args) {
        BinaryNode node = BinaryNodeUtils.simpleBinaryTree();
        preOrderTraversalRecursive(node, System.out::println);
        inOrderTraversalRecursive(node, System.out::println);
        postOrderTraversalRecursive(node, System.out::println);

        List<Integer> preOrderTraversal = new LinkedList<>();
        preOrderTraversalRecursive(node, i -> preOrderTraversal.add(i));

        List<Integer> inOrderTraversal = new LinkedList<>();
        inOrderTraversalRecursive(node, i -> inOrderTraversal.add(i));

        List<Integer> postOrderTraversal = new LinkedList<>();
        postOrderTraversalRecursive(node, i -> postOrderTraversal.add(i));

        List expectedPreOrderTraversal = Arrays.asList(1, 2, 4, 5, 3);
        List expectedInOrderTraversal = Arrays.asList(4, 2, 5, 1, 3);
        List expectedPostOrderTraversal = Arrays.asList(4, 5, 2, 3, 1);

        isQuals(preOrderTraversal, expectedPreOrderTraversal);
        isQuals(inOrderTraversal, expectedInOrderTraversal);
        isQuals(postOrderTraversal, expectedPostOrderTraversal);
    }
}
