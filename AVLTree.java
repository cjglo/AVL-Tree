// TODO: Edit so holds key and value pair?  Or just value

public class AVLTree {

    // main attributes
    private TreeNode root;

    // constructors
    AVLTree() {
        this.root = null;
    }

    // rebalncing attriutes and methods
    

    private TreeNode restructor(TreeNode x) { 

        // Follows the 4 types of restrucures for AVL Trees (two single rotations and two double rotations)

        TreeNode y = x.parent;
        TreeNode z = y.parent;

        if(z.left == y) {
            // either of the two situations where z ends as furthest right

            if(y.left == x) {
                // single rotation where z is on right

                // move parent of this subtree before roation
                if(z != this.root) {
                    z.parent.left = y;
                    y.parent = z.parent;
                }
                doRotation(x, y, z, x.right, y.right);
                return y; // y is new root so return it
            
            } else {
                // double rotation where z is on right

                // move parent of this subtree before roation
                if(z != this.root) {
                    z.parent.left = x;
                    x.parent = z.parent;
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
                    z.parent.right = y;
                    y.parent = z.parent;
                }
                doRotation(z, y, x, y.left, x.left);
                return y; // y is new root
            } else {
                // double roation where y ends up on right

                // move parent of this subtree before roation
                if(z != this.root) {
                    z.parent.right = x;
                    x.parent = z.parent;
                }
                doRotation(z, x, y, x.left, x.right);
                return x; // x is new root
            }

        }

    } 
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
    }


    // public interface methods: 
    public void insert(int val) throws Exception { 

        TreeNode node;
        node = insertRecurse(val, this.root, null);
        rebalance(node);
    }

    private TreeNode insertRecurse(int val, TreeNode node, TreeNode parent) throws Exception {
        
        if(node.isLeaf) {
            node = new TreeNode(val, parent);
            return node;
        } else {

            if(val > node.getValue()) {
                return insertRecurse(val, node.right, node);
            } else {
                return insertRecurse(val, node.left, node);
            }

        }

    } 


    public int remove(int val) { return 0;} // TODO


    // private methods:

    public void rebalance(TreeNode node) throws Exception { //TODO
        TreeNode n = node;
        while(!(n == this.root)) {
            n = n.parent;
            if(!n.isBalanced()) {
                TreeNode x = n.tallestGrandchild();
                n = restructor(x);
            }
        }        
    }
    

}
