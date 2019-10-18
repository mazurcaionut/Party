/**
 * GraphMain class tests the methods from the Graph class, such as:
 * makeFriendship who makes a friendship between two profiles
 * and also the friendRecommendations method which returns a BST
 * for every user in the array , containing friend recommendations.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class GraphMain {
    public static void main(String[] args){
        Profile nr1=new Profile("Alex","Gheorghe",17,7,1999,"Severin","Romania","romana","ab@gmail.com", new String[]{"a","b","c","d","e","f","g","h"});
        Profile nr2=new Profile("Robert","Baluta",13,9,1995,"Craiova","Anglia","englez","cd@gmail.com", new String[]{"q","w","e","r","t","y","u"});
        Profile nr3=new Profile("Mihai","Stefan",12,11,1998,"Zalau","Kenya","african","gh@gmail.com", new String[]{"a","s","d","f","g","h","j","k"});
        Profile nr4=new Profile("Catalin","Todd",9,3,1993,"Swansea","Wales","welsh","ui@gmail.com", new String[]{"z","x","c","v","b","n","m"});
        Profile nr5=new Profile("Razvan","Tanase",3,3,1994,"Constanta","Romania","romana","rt@gmail.com", new String[]{"e","d","c","r","f","v","t"});
        Profile nr6=new Profile("George","Andrei",1,1,1996,"Cardiff","Wales","welsh","ga@gmail.com", new String[]{"z","x","c","v","b","n","m"});
        Profile nr7=new Profile("Laurentiu","Sergiu",5,5,1989,"London","England","english","lg@gmail.com", new String[]{"y","h","n","u","j","m","i"});

        Profile[] users=new Profile[]{nr1,nr2,nr3,nr4,nr5,nr6,nr7};

        BST tree=new BST();
        tree=FileReader.readProfileSet("input");
        Graph friendships=new Graph("friends",tree);


        friendships.makeFriendship(users[0],users[1]);
        friendships.makeFriendship(users[0],users[2]);
        friendships.makeFriendship(users[1],users[2]);
        friendships.makeFriendship(users[1],users[4]);
        friendships.makeFriendship(users[2],users[5]);
        friendships.makeFriendship(users[3],users[6]);
        friendships.makeFriendship(users[5],users[6]);


        //users[0].addFriend(users[1]);
        //users[1].addFriend(users[0]);


        //users[0].addFriend(users[2]);
        //users[2].addFriend(users[0]);

        //users[0].addFriend(users[3]);
        //users[3].addFriend(users[0]);

        //users[1].addFriend(users[2]);
        //users[2].addFriend(users[1]);

        //users[1].addFriend(users[4]);
        //users[4].addFriend(users[1]);

        //users[2].addFriend(users[5]);
        //users[5].addFriend(users[2]);

        //users[3].addFriend(users[6]);
        //users[6].addFriend(users[3]);

        //users[5].addFriend(users[6]);
        //users[6].addFriend(users[5]);


        //tree.printFriends();

        BST[] output=friendships.friendRecommendations(users);
        for(int i=0;i<output.length;i++){
            try{
                System.out.println(users[i].getName()+" friend recommendation are: ");
                output[i].printAlphabetical();
            }catch (NullPointerException e){
                System.out.print(users[i].getName()+" can't be recommended any friend.");
            }
            System.out.println("\n");
        }
    }
}
