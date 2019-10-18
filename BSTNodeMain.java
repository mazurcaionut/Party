/**
 * BSTNodeMain creates a couple of nodes from BSTNode class and
 *tests the setter and getter methods from that class.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class BSTNodeMain {
    public static void main(String[] args){
        String[] interests={"a","b","c"};
        Profile nr1=new Profile("Alex","Mihai", 13, 3, 1999, "Severin", "Romania", "romana", "alex@gmail.com", interests);
        Profile nr2=new Profile("Bogdan","Lupu", 15, 8, 1987, "Pitesti", "Romania", "romana", "bogdan@gmail.com", interests);
        Profile nr3=new Profile("Razvan","Popescu", 4, 1, 1998, "Cluj", "Romania", "romana", "razvan@gmail.com", interests);
        Profile nr4=new Profile("Vlad","George", 3, 11, 1995, "Arad", "Romania", "romana", "vlad@gmail.com", interests);
        BSTNode first=new BSTNode(nr1);
        BSTNode second=new BSTNode(nr2);
        BSTNode third=new BSTNode(nr3);
        BSTNode fourth=new BSTNode(nr4);
        first.setL(second);
        first.setR(third);
        second.setL(fourth);
        System.out.println(first.getL().getProfile());
        System.out.println(first.getR().getProfile());
        System.out.println(second.getL().getProfile());
    }
}
