// TODO: Edit so holds key and value pair?  Or just value

public class AVLTree {

    // main attributes
    private TreeNode root;

    // constructors
    AVLTree() {
        this.root = null;
    }

    // rebalncing attriutes and methods
    


    private void rebalance() { } // TODO
    private TreeNode restructor(TreeNode x) { return new TreeNode(); } // TODO


    // public interface methods: 
    public void insert(int val) { } // TODO
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
