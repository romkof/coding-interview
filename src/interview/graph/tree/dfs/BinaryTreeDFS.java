package interview.graph.tree.dfs;

import interview.graph.tree.BinaryNode;
import interview.graph.tree.BinaryNodeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

import static interview.graph.Utils.assertEquals;
public class BinaryTreeDFS {

    /**
      PreOrder Traversal Root-Left-Right

             (1)
            /   \
          (2)   (3)
          / \
       (4)  (5)

      (1) -> (2) -> (4) -> (5) -> (3)

     **/
    public static void preOrderRecursive(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        traversalFun.accept(root.getValue());
        preOrderRecursive(root.getLeft(), traversalFun);
        preOrderRecursive(root.getRight(), traversalFun);
    }

    public static void preOrderIterative(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            traversalFun.accept(node.getValue());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    /**
      InOrder Traversal Left-Root-Right

             (1)
            /   \
          (2)   (3)
          / \
       (4)  (5)

       (4) -> (2) -> (5) -> (1) -> (3)

     **/
    public static void inOrderRecursive(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        inOrderRecursive(root.getLeft(), traversalFun);
        traversalFun.accept(root.getValue());
        inOrderRecursive(root.getRight(), traversalFun);
    }


    public static void inOrderIterative(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            traversalFun.accept(node.getValue());
            node = node.getRight();
        }
    }

    /**
       PostOrder Traversal Left-Right-Root

             (1)
            /   \
          (2)   (3)
          / \
       (4)  (5)

       (4) -> (5) -> (2) -> (3) -> (1)

     **/
    public static void postOrderRecursive(BinaryNode node, Consumer<Integer> traversalFun) {
        if (node == null)
            return;
        postOrderRecursive(node.getLeft(), traversalFun);
        postOrderRecursive(node.getRight(), traversalFun);
        traversalFun.accept(node.getValue());
    }
    
    /**
     *
     *
     *    +------------+--------+---------+---------+---------+---------+--------+
     *    |Iteration   |1       |1        |2        |3        |4        |5       |
     *    +------------+--------+---------+---------+---------+---------+--------+
     *    |Memory      | s1  s2 | s1  s2  | s1  s2  | s1  s2  | s1  s2  | s1  s2 |
     *    |            | [1] [] | [3] [1] | [2] [3] | [5] [2] | [4] [5] | [] [4] | 
     *    |            |        | [2]     |     [1] | [4] [3] |     [2] |    [5] |   
     *    |            |        |         |         |     [1] |     [3] |    [2] |    
     *    |            |        |         |         |         |     [1] |    [3] |   
     *    |            |        |         |         |         |         |    [1] |
     *    +------------+--------+---------+---------+---------+---------+--------+
     *    |Output      |        |         |         |         |         |        |
     *    |            |        |         |         |         |         |        |
     *    +------------+--------+---------+---------+---------+---------+--------+
     *    
     *    +------------+---------+---------+---------+---------+--------+
     *    |Iteration   |6        |7        |8        |9        |10      |
     *    +------------+---------+---------+---------+---------+--------+
     *    |Memory      | s1  s2  | s1  s2  | s1  s2  | s1  s2  | s1  s2 |
     *    |            | []  [5] | []  [2] | []  [3] | []  [1] | [] []  | 
     *    |            |     [2] |     [3] |     [1] |         |        |   
     *    |            |     [3] |     [1] |         |         |        |    
     *    |            |     [1] |         |         |         |        |   
     *    |            |         |         |         |         |        |
     *    +------------+---------+---------+---------+---------+--------+
     *    |Output      |         |         |         |         |        |
     *    |            |   (4)   |   (5)   |    (2)  |    (3)  |   (1)  |
     *    +------------+---------+---------+---------+---------+--------+
     *
     **/
    public static void postOrderIterative(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        Stack<BinaryNode> firstStack = new Stack<>();
        Stack<BinaryNode> secondStack = new Stack<>();
        firstStack.push(root);

        while (!firstStack.isEmpty()) {
            BinaryNode node = firstStack.pop();
            secondStack.push(node);
            if (node.getLeft() != null)
                firstStack.push(node.getLeft());
            if (node.getRight() != null)
                firstStack.push(node.getRight());
        }

        while (!secondStack.isEmpty()) {
            BinaryNode node = secondStack.pop();
            traversalFun.accept(node.getValue());
        }
    }

    /**
      PostOrder Traversal Left-Right-Root

            (1)
            / \
         (2)  (3)
         / \
       (4)  (5)

      (4) -> (5) -> (2) -> (3) -> (1)

     ╔═══════════╤═════════════════╤══════════════╤══════════════╤══════════════╤══════════════╤══════════════╗
     ║ Iteration │        0        │      1       │      2       │      3       │      4       │      5       ║
     ╠═══════════╪═════════════════╪══════════════╪══════════════╪══════════════╪══════════════╪══════════════╣
     ║ Memory    │ previous = null │ previous = 1 │ previous = 2 │ previous = 4 │ previous = 2 │ previous = 5 ║
     ║           ├─────────────────┼──────────────┼──────────────┼──────────────┼──────────────┼──────────────╢
     ║           │ current         │ current =1   │ current =2   │ current =4   │ current =2   │ current =5   ║
     ║           ├─────────────────┼──────────────┼──────────────┼──────────────┼──────────────┼──────────────╢
     ║           │        s        │      s       │      s       │      s       │      s       │      s       ║
     ║           │       [1]       │     [2]      │     [4]      │     [2]      │     [5]      │     [2]      ║
     ║           │                 │     [1]      │     [2]      │     [1]      │     [2]      │     [1]      ║
     ║           │                 │              │     [1]      │              │     [1]      │              ║
     ╟───────────┼─────────────────┼──────────────┼──────────────┼──────────────┼──────────────┼──────────────╢
     ║ Output    │                 │              │              │     (4)      │              │     (5)      ║
     ╚═══════════╧═════════════════╧══════════════╧══════════════╧══════════════╧══════════════╧══════════════╝
     ╔═══════════╤══════════════╤══════════════╤══════════════╤══════════════╗
     ║ Iteration │      6       │      7       │      8       │      9       ║
     ╠═══════════╪══════════════╪══════════════╪══════════════╪══════════════╣
     ║ Memory    │ previous = 2 │ previous = 1 │ previous = 3 │ previous = 1 ║
     ║           ├──────────────┼──────────────┼──────────────┼──────────────╢
     ║           │ current =2   │ current =1   │ current =3   │ current =1   ║
     ║           ├──────────────┼──────────────┼──────────────┼──────────────╢
     ║           │      s       │      s       │      s       │      s       ║
     ║           │     [1]      │     [3]      │     [1]      │      []      ║
     ║           │              │     [1]      │              │              ║
     ╟───────────┼──────────────┼──────────────┼──────────────┼──────────────╢
     ║ Output    │     (2)      │              │     (3)      │     (1)      ║
     ╚═══════════╧══════════════╧══════════════╧══════════════╧══════════════╝


     */
    public static void postOrderIterativeSecond(BinaryNode root, Consumer<Integer> traversalFun) {
        if (root == null)
            return;
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        BinaryNode previous = null;
        while (!stack.isEmpty()) {
            BinaryNode current = stack.peek();
            if (previous == null || previous.getLeft() == current ||
                    previous.getRight() == current) {
                if (current.getLeft() != null)
                    stack.push(current.getLeft());
                else if (current.getRight() != null)
                    stack.push(current.getRight());
                else {
                    stack.pop();
                    traversalFun.accept(current.getValue());
                }
            } else if (current.getLeft() == previous) {
                if (current.getRight() != null)
                    stack.push(current.getRight());
                else {
                    stack.pop();
                    traversalFun.accept(current.getValue());
                }
            } else if (current.getRight() == previous) {
                stack.pop();
                traversalFun.accept(current.getValue());
            }
            previous = current;
        }
    }

    public static void main(String[] args) {
        BinaryNode node = BinaryNodeUtils.simpleBinaryTree();

        List<Integer> preOrder = new LinkedList<>();
        List<Integer> preOrderIterative = new LinkedList<>();
        preOrderRecursive(node, preOrder::add);
        preOrderIterative(node, preOrderIterative::add);

        List<Integer> inOrder = new LinkedList<>();
        List<Integer> inOrderIterative = new LinkedList<>();
        inOrderRecursive(node, inOrder::add);
        inOrderIterative(node, inOrderIterative::add);

        List<Integer> postOrder = new LinkedList<>();
        List<Integer> postOrderIterative = new LinkedList<>();
        List<Integer> postOrderIterativeSecond = new LinkedList<>();
        postOrderRecursive(node, postOrder::add);
        postOrderIterative(node, postOrderIterative::add);
        postOrderIterativeSecond(node, postOrderIterativeSecond::add);

        List<Integer> expectedPreOrder = Arrays.asList(1, 2, 4, 5, 3);
        List<Integer> expectedInOrder = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> expectedPostOrder = Arrays.asList(4, 5, 2, 3, 1);

        assertEquals(preOrder, expectedPreOrder);
        assertEquals(preOrderIterative, expectedPreOrder);

        assertEquals(inOrder, expectedInOrder);
        assertEquals(inOrderIterative, expectedInOrder);

        assertEquals(postOrder, expectedPostOrder);
        assertEquals(postOrderIterative, expectedPostOrder);
        assertEquals(postOrderIterativeSecond, expectedPostOrder);
    }
}
