package com.interview.graph.tree.bfs;

import com.interview.graph.tree.BinaryNode;
import com.interview.graph.tree.BinaryNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

import static com.interview.graph.Utils.assertEquals;

public class BinaryTreeBFS {

    /**
     * Traversal
     *
     *        (1)
     *       /   \
     *     (2)   (3)
     *     / \
     *  (4)  (5)
     *
     *  (1) -> (2) -> (3) -> (4) -> (5)
     **/

    public static void traversal(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode node = queue.poll();
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
