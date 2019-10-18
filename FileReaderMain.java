import java.util.Scanner;

/**
 * BST creates a binary search tree that
 * contains several methods like inserting profile, printing in alphabetical order,
 * finding a certain profile into the BST.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class FileReaderMain {
    public static void main(String[] args){
        BST tree=new BST();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the name of the input file:");
        String input=in.next();
        tree=FileReader.readProfileSet(input);
        tree.printAlphabetical();
        //System.out.println(tree.getRoot().getProfile());
        //System.out.println(tree.getRoot().getL().getProfile());
        //System.out.println(tree.getRoot().getR().getProfile());
        //System.out.println(tree.getRoot().getR().getR().getProfile());
    }
}
