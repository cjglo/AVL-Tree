
public class TreeNode {

    // TODO: Make generic

    // Constructor
    TreeNode(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
    

    // attributes and methods related to value
    private int value;
    public TreeNode left;
    public TreeNode right;
    private int height;

    
    public int getHeight() {return 0; } // TODO
    public void setHeight(int ht) { this.height = ht; }

    public int getValue() { return value; }
    public void setValue(int val) { this.value = val; }


}