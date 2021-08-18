// TODO: Edit so holds key and value pair?  Or just value

public class AVLTree {

    // main attributes
    private TreeNode root;

    // constructors
    AVLTree() {
        this.root = new TreeNode();
        this.root.parent = new TreeNode(); // superroot to prevent null exceptions
        this.root.parent.left = this.root;
        this.root.parent.right = this.root;
    }

    // rebalncing attriutes and methods
    

    private TreeNode restructor(TreeNode x) { 

        System.out.println("RESTRCUTURE TIGGERED");

        // Follows the 4 types of restrucures for AVL Trees (two single rotations and two double rotations)

        TreeNode y = x.parent;
        TreeNode z = y.parent;

        if(z.left == y) {
            // either of the two situations where z ends as furthest right

            if(y.left == x) {
                // single rotation where z is on right

                // move parent of this subtree before roation
                if(z != this.root) {
                    reassignParent(z, y);
                }
                doRotation(x, y, z, x.right, y.right);
                return y; // y is new root so return it
            
            } else {
                // double rotation where z is on right

                // move parent of this subtree before roation
                if(z != this.root) {
                    reassignParent(z, x);
                }
                doRotation(y, x, z, x.left, x.right);
                return x; // x is new root
            }
        
        } else {
            // other two situions where x or y ends up as furthest right

            if(y.right == x) {
                // single rotation where x ends up on right

                // move parent of this subtree before roation
                if(z != this.root) {
                    reassignParent(z, y);
                }
                doRotation(z, y, x, y.left, x.left);
                return y; // y is new root
            } else {
                // double roation where y ends up on right

                // move parent of this subtree before roation
                if(z != this.root) {
                    reassignParent(z, x);
                }
                doRotation(z, x, y, x.left, x.right);
                return x; // x is new root
            }

        }

    } 
    // helper function that does the rotation reassignments
    private void doRotation(TreeNode a, TreeNode b, TreeNode c, TreeNode t1, TreeNode t2) {

        // reassign all the doubly linked connections

        a.parent = b;
        b.left = a;

        c.parent = b;
        b.right = c;

        t1.parent = a;
        a.right = t1;

        t2.parent = c;
        c.left = t2;

        if(a == this.root || c == this.root) {
            this.root = b;
        }

    }
    //helper function that gives subtree root new parent before rotation
    private void reassignParent(TreeNode oldRoot, TreeNode newRoot) {

        if(oldRoot.parent.left == oldRoot) {

            oldRoot.parent.left = newRoot;
            newRoot.parent = oldRoot.parent;
        } else {

            oldRoot.parent.right = newRoot;
            newRoot.parent = oldRoot.parent;
        }

    }


    // public interface methods: 
    public void insert(int val) throws Exception { 

        TreeNode node;
        node = insertRecurse(val, this.root, null);
        node.setHeight();
        rebalance(node);
    }

    private TreeNode insertRecurse(int val, TreeNode node, TreeNode parent) throws Exception {
        
        if(node.isLeaf) {
            node.convertToNonLeaf(val, parent);
            return node;
        } else {

            if(val > node.getValue()) {
                return insertRecurse(val, node.right, node);
            } else {
                return insertRecurse(val, node.left, node);
            }

        }

    } 


    public void remove(int val) throws Exception { 

        removeRecurse(this.root, val);

        // TODO: Add node finding to pass into restructure
    }
    private TreeNode removeRecurse(TreeNode node, int val) throws Exception {

        if(node.getValue() == val) {

            // TODO: Add remove from binary tree algorithm
            return new TreeNode();
        }
        else if(node.getValue() < val) {
            return removeRecurse(node.right, val);
        } else {
            return removeRecurse(node.left, val);
        }

    }


    // private methods:

    public void rebalance(TreeNode node) throws Exception { 
        TreeNode n = node;
        while(!(n == this.root)) {
            n = n.parent;
            n.setHeight();
            if(!n.isBalanced()) {
                TreeNode x = n.tallestGrandchild();
                n = restructor(x);
                n.left.setHeight();
                n.right.setHeight();
                n.setHeight();
            }
        }        
    }

    // Primarily made for testing
    public void printInOrder() throws Exception {

        System.out.println("In Order Traversal: \n");
        printInOrderRecurse(this.root);
        System.out.println("\n End in Order Traversal");

        
    }
    public void printInOrderRecurse(TreeNode node) throws Exception {

        if(node.isLeaf) {
            return;
        }

        printInOrderRecurse(node.left);

        System.out.println(node.getValue() + " (" + node.getHeight() + ")");

        printInOrderRecurse(node.right);

    }
    

}
