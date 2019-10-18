/**
 * BSTMain tests the methods from the BST class.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class BSTMain {
    public static void main(String[] args){
        String[] interests={"a","b","c"};
        Profile nr1=new Profile("A","A", 13, 3, 1999, "Severin", "Romania", "romana", "alex@gmail.com", interests);
        Profile nr2=new Profile("B","B", 15, 8, 1987, "Pitesti", "Romania", "romana", "bogdan@gmail.com", interests);
        Profile nr3=new Profile("C","C", 4, 1, 1998, "Cluj", "Romania", "romana", "razvan@gmail.com", interests);
        Profile nr4=new Profile("D","D", 3, 11, 1995, "Arad", "Romania", "romana", "vlad@gmail.com", interests);
        Profile nr5=new Profile("E","E", 3, 11, 1995, "Arad", "Romania", "romana", "vlad@gmail.com", interests);
        Profile nr6=new Profile("F","F", 3, 11, 1995, "Arad", "Romania", "romana", "vlad@gmail.com", interests);
        Profile nr7=new Profile("G","G", 3, 11, 1995, "Arad", "Romania", "romana", "vlad@gmail.com", interests);



        BST tree=new BST();
        /* BINARY TREE
        * a getRoot() method was used while testing the methods in the BST class.
        tree.insertProfile(nr4);
        tree.insertProfile(nr2);
        tree.insertProfile(nr6);
        tree.insertProfile(nr1);
        tree.insertProfile(nr3);
        tree.insertProfile(nr5);
        tree.insertProfile(nr7);

        System.out.println(tree.getRoot().getProfile().getName());
        System.out.println(tree.getRoot().getL().getProfile().getName());
        System.out.println(tree.getRoot().getR().getProfile().getName());
        System.out.println(tree.getRoot().getL().getL().getProfile().getName());
        System.out.println(tree.getRoot().getL().getR().getProfile().getName());
        System.out.println(tree.getRoot().getR().getL().getProfile().getName());
        System.out.println(tree.getRoot().getR().getR().getProfile().getName());
        */

        /*  EXTREME RIGHT TREE
        tree.insertProfile(nr1);
        tree.insertProfile(nr2);
        tree.insertProfile(nr3);
        tree.insertProfile(nr4);
        tree.insertProfile(nr5);
        tree.insertProfile(nr6);
        tree.insertProfile(nr7);

        System.out.println(tree.getRoot().getProfile().getName());
        System.out.println(tree.getRoot().getR().getProfile().getName());
        System.out.println(tree.getRoot().getR().getR().getProfile().getName());
        System.out.println(tree.getRoot().getR().getR().getR().getProfile().getName());
        System.out.println(tree.getRoot().getR().getR().getR().getR().getProfile().getName());
        System.out.println(tree.getRoot().getR().getR().getR().getR().getR().getProfile().getName());
        System.out.println(tree.getRoot().getR().getR().getR().getR().getR().getR().getProfile().getName());
        */
    }
}
