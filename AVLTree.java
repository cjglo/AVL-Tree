// TODO: Edit so holds key and value pair?  Or just value

public class AVLTree {

    // attributes
    private TreeNode root;


    // constructors
    AVLTree() {
        this.root = null;
    }

    // rebalncing attriutes and methods
    private boolean isBalanced;
    private void rebalance();


    // methods 
    public int getHeight();

    public void insert(int val);
    public int remove(int val);

    

}