
public class TreeTester {


    public static void main(String[] arg ) {

        // temporary Test suite

        AVLTree tree = new AVLTree();

        try {
            tree.insert(6);

            tree.insert(10);

            tree.insert(9);

            tree.insert(11);

            tree.insert(12);

            tree.insert(3);

            tree.insert(2);

            tree.insert(4);

            tree.insert(23);

            tree.insert(14);

            tree.insert(0);

            tree.insert(21);

            tree.insert(17);

            // tree.insert(-17);

            tree.insert(19);

            tree.insert(8);

            tree.insert(1);

            tree.insert(25);

            tree.insert(28);

            // tree.insert(18);

            tree.remove(14);

            tree.remove(25);

            tree.remove(21);

            tree.remove(12);

            tree.remove(9);

            tree.remove(2);

            tree.remove(11);

            tree.remove(19);

            tree.printInOrder();


            System.out.println("PASSED");



        } catch(Exception e) {
            System.out.println("FAILED");
            System.out.println(e);
        }



        // TODO: Implement J-Unit testing
        
    }

}