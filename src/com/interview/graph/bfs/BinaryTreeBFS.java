package com.interview.graph.bfs;

import com.interview.graph.BinaryNode;
import com.interview.graph.BinaryNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

import static com.interview.graph.Utils.assertEquals;

public class BinaryTreeBFS {

    public static void traversal(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode node = queue.remove();
            traversalFun.accept(node.getValue());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BinaryNode node = BinaryNodeUtils.simpleBinaryTree();
        List<Integer> traversal = new LinkedList<>();
        traversal(node, traversal::add);
        List<Integer> expectedTraversal = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(traversal, expectedTraversal);
    }
}
