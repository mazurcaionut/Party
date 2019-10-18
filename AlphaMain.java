/**
 * AlphaMain class tests the printAlphabetical method from the BST class.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class AlphaMain {
    public static void main(String[] args){
        BST tree=new BST();
        tree=FileReader.readProfileSet("input");
        tree.printAlphabetical();
    }
}
