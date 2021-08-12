public class TreeNode {

    // TODO: Make generic

    // attributes and methods related to value
    private int value;

    public getValue() { return value; }
    public setValue(int val) { this.value = val; }

    // Constructors
    TreeNode() {
        this.value = null;
    }

    TreeNode(int val) {
        this.value = val;
    }

}