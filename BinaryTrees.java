import java.util.Queue;
import java.util.LinkedList;

//TIP -> FOR ANY OPERATION IN TREE FIRST GO FOR LEFT, RIGHT THAN ROOT

public class BinaryTrees {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    

    static class BinaryTree {
        
        //Binary tree construction.(pre-order sequence)
        static int idx = -1;
        public Node buildTree(int[] nodeValues) {

            idx++;
            if(nodeValues[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodeValues[idx]);
            newNode.left = buildTree(nodeValues);
            newNode.right = buildTree(nodeValues);

            return newNode;
        }


        //preorder traversal
        void preorderTraversal(Node root) {

            // -> root
            // -> left 
            // -> right 
            //  TC -> O(n); travesed all the nodes of the tree tc for traversing one node is O(1).

           if(root == null) {
            System.out.print(-1 + " ");
            return;
           }

           System.out.print(root.data + " ");
           preorderTraversal(root.left);
           preorderTraversal(root.right);
        }

        void inorderTraversal(Node root) {

            // -> left
            // -> root
            // -> right
            // TC -> O(n);

            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }

            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }

        void postorderTraversal(Node root) {

            // -> left
            // -> right
            // -> root
            //TC -> O(n);
    
            if(root == null) {
                System.out.print(-1 + " ");
                return;
            }
    
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        void levelorderTraversal(Node root) {
            //Levelorder traversal is BFS traversal for TREES

            if(root == null) {
                System.out.println("Tree is empty!");
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()) {
                Node front = q.remove();
                if(front == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(front.data + " ");
                    if(front.left != null)
                        q.add(front.left);
                    if(front.right != null)
                        q.add(front.right);
                }
            }
        }
        
        //Calculating total number of nodes in the tree left + right + 1 (root)
        //TC -> O(n);
        int countOfNodes(Node root) { 
            if(root == null) {
                return 0;
            }
            int leftCount = countOfNodes(root.left);
            int rightCount = countOfNodes(root.right);
            return leftCount + rightCount + 1;
        }

        int sumOfNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }
    } 

    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameterOfTree(Node root) {
        //TC -> O(n^2); linear time for calculating diameter and linear time calculating height.
        //To optimize calculate the height and diameter at the same time.

        if(root == null) {
            return 0;
        }
        int leftDia = diameterOfTree(root.left);
        int rightDia = diameterOfTree(root.right);
        return Math.max(Math.max(leftDia, rightDia), heightOfTree(root.left) + heightOfTree(root.right) + 1);
    }
    
       public static void main(String[] args) {
        int[] nodeValues = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root= tree.buildTree(nodeValues);
        System.out.println("Root : " + root.data);
        System.out.println("Left child : " + root.left.data);
        System.out.println("Right child : " + root.right.data);

        System.out.println("Pre-order : ");
        tree.preorderTraversal(root);
    
        System.out.println("\nIn-order : ");
        tree.inorderTraversal(root);

        System.out.println("\nPost-order : ");
        tree.postorderTraversal(root);

        System.out.println("\nLevelorder : ");
        tree.levelorderTraversal(root);

        System.out.println("Count : " + tree.countOfNodes(root));

        System.out.println("Sum of Nodes : " + tree.sumOfNodes(root));

        System.out.println("Height of the tree : " + heightOfTree(root));

        System.out.println("Diameter of Tree : " + diameterOfTree(root));


    }
}