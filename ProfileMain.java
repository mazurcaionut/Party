/**
 * ProfileMain tests all the methods from thhe Profile class.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class ProfileMain {
    public static void main(String[] args){
        String[] interests={"a","b","c"};
        Profile nr1=new Profile("Alex","Mihai", 13, 3, 1999, "Severin", "Romania", "romana", "alex@gmail.com", interests);
        Profile nr2=new Profile("Bogdan","Lupu", 15, 8, 1987, "Pitesti", "Romania", "romana", "bogdan@gmail.com", interests);
        Profile nr3=new Profile("Razvan","Popescu", 4, 1, 1998, "Cluj", "Romania", "romana", "razvan@gmail.com", interests);
        Profile nr4=new Profile("Vlad","George", 3, 11, 1995, "Arad", "Romania", "romana", "vlad@gmail.com", interests);

        System.out.println(nr1.getCountryOfResidence());
        System.out.println("\n");
        System.out.println(nr2.getDateOfBirth());
        System.out.println("\n");
        System.out.println(nr3.getNationality());
        System.out.println("\n");
        System.out.println(nr4.getTownOfResidence());
        System.out.println("\n");
        System.out.println(nr1.getInterest());
        System.out.println("\n");
        nr1.addFriend(nr2);
        nr1.addFriend(nr3);
        nr1.addFriend(nr4);
        System.out.println(nr1.getFriend(2));
        System.out.println(nr1.toString());

    }
}
