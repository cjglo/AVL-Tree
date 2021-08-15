
public class TreeNode {

    // TODO: Make generic

    // Constructor
    TreeNode() {
        this.left = null;
        this.right = null;
        this.isLeaf = true;
        this.parent = null;
    }

    TreeNode(int val, TreeNode par) {
        this.value = val;
        this.left = null;
        this.right = null;
        this.isLeaf = false;
        this.parent = par;
    }
    

    // attributes and methods related to value
    private int value;
    public TreeNode left;
    public TreeNode right;
    private int height;
    public boolean isLeaf;
    public TreeNode parent;


    public int getHeight() {
        if(isLeaf) {
            return 0;
        } else {
            
            int leftHeight = left.getHeight() + 1;
            int rightHeight = right.getHeight() + 1;

            return (leftHeight >= rightHeight) ? leftHeight : rightHeight;
        }
    }
    public void setHeight(int ht) { this.height = ht; }

    public int getValue() throws Exception { 
        if(isLeaf) {
            throw new Exception("Node is a leaf!");
        } 
        return value; 
    }


    public void setValue(int val) { this.value = val; }

    public boolean isBalanced() {
        if(this.isLeaf) {
            return true;
        } else {
            int bal = this.left.getHeight() - this.right.getHeight();
            return ((-1 <= bal) && (bal >= 1)); 
        }
    }

    public TreeNode tallestGrandchild() throws Exception { //TODO: change to have no paramter (take self)

        if(this.left.isLeaf && this.right.isLeaf) {
            throw new Exception("No Grandchild Node, Tree is too small!"); // TODO: Not sure if this is correct erorr handling
        }

        if(this.left.getHeight() >= this.right.getHeight()) {

            if(this.left.left.getHeight() >= this.left.right.getHeight()) {
                return this.left.left;
            } else {
                return this.left.right;
            }

        } else {

            if(this.right.left.getHeight() >= this.right.right.getHeight()) {
                return this.right.left;
            } else {
                return this.right.right;
            }

        }
    }

    


}