import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Creates a graph whose nodes are taken from a BST and the edges are taken
 * from an input file.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class Graph {

    private BST nodes;

    /**
     * Creates a graph with nodes from a BST and edges from an input file.
     * @param filename The input file for the friendships.
     * @param nodes The nodes from the BST.
     */
    public Graph(String filename, BST nodes){
        this.nodes=nodes;
        readFile(filename);
    }

    /**
     * Creates a scanner that reads tokens from an input file.
     * @param filename The name of the input file.
     */
    private void readFile(String filename){
        File inputFile=new File(filename);
        Scanner in=null;
        try{
            in=new Scanner(inputFile);
        }catch (FileNotFoundException e){
            System.out.println("Cannot open: "+filename);
            System.exit(0);
        }
        readLine(in);
    }

    /**
     * Reads every line of the input file and calls the readFriendships
     * method that reads the friendships between the profiles.
     * @param in The input file scanner.
     */
    private void readLine(Scanner in){
        while(in.hasNextLine()){
            String curLine=in.nextLine();
            Scanner line=new Scanner(curLine);
            readFriendships(line);
        }
    }

    /**
     * Reads the friendships between the profiles.
     * @param in The input file scanner.
     */
    private void readFriendships(Scanner in){
        in.useDelimiter(",");
        String one=in.next();
        String two=in.next();
        Profile profileOne=nodes.searchProfile(one);
        Profile profileTwo=nodes.searchProfile(two);


        makeFriendship(profileOne,profileTwo);
    }

    /**
     * Makes a friendship between two profiles.
     * @param profileOne The first profile of the friendship.
     * @param profileTwo The second profile of the friendship.
     */
    public void makeFriendship(Profile profileOne, Profile profileTwo){
        addFriend(checkFriends(profileOne,profileTwo),profileOne,profileTwo);
        addFriend(checkFriends(profileTwo,profileOne),profileTwo,profileOne);
    }

    /**
     * Checks if two users are already friends.
     * @param profileOne The first profile to be checked.
     * @param profileTwo The second profile to be checked.
     * @return True if the users are already friends, and false otherwise.
     */
    private boolean checkFriends(Profile profileOne,Profile profileTwo){
        int numFriends=profileOne.numOfFriends();
        boolean alreadyFriends=false;
        if(numFriends>0){
            for(int i=0;i<numFriends;i++){
                if(profileOne.getFriend(i).equals(profileTwo)){
                    alreadyFriends=true;
                }
            }
        }
        if(!alreadyFriends){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Adds the second profile to the first profile friends list.
     * @param alreadyFriends Boolean variable that tells if the two profiles already
     *                       are on each other friends list.
     * @param profileOne The first profile.
     * @param profileTwo The second profile.
     */
    private void addFriend(boolean alreadyFriends, Profile profileOne, Profile profileTwo){
        if(!alreadyFriends){
            profileOne.addFriend(profileTwo);
        }
    }


    /**
     * Creates friend recommendations BST for every user in the array.
     * @param users The array which contains the students that need to be recommended friends.
     * @return A friend recommendations BST array for every profile user.
     */
    public BST[] friendRecommendations(Profile[] users){
        BST[] recommendations=new BST[users.length];
        for(int i=0;i<recommendations.length;i++){
            recommendations[i]=new BST();
        }
        for(int i=0;i<users.length;i++){
            for(int j=0;j<users[i].numOfFriends();j++){
                for(int l=0;l<users[i].getFriend(j).numOfFriends();l++){
                    if(!checkFriends(users[i],users[i].getFriend(j).getFriend(l)) && !users[i].equals(users[i].getFriend(j).getFriend(l))){
                        recommendations[i].insertProfile(users[i].getFriend(j).getFriend(l));
                    }
                }
            }
        }
        return recommendations;
    }
}
