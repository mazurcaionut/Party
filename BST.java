import java.util.NoSuchElementException;

/**
 * BST creates a binary search tree that
 * contains several methods like inserting profile, printing in alphabetical order,
 * finding a certain profile into the BST.
 * @author Ioan Mazurca
 * @version 1.0
 * */

public class BST {
    private BSTNode root;

    /**
     * Creates a BST (Binary search tree)
     */
    public BST(){
        root=null;
    }

    /**
     * Inserts a profile into the BST.
     * @param p The profile to be inserted into the BST.
     */
    public void insertProfile(Profile p){
        BSTNode profile=new BSTNode(p);
        /*In case the root is null, the profile to be inserted becomes the root.*/
        if(root==null){
            root=profile;
        }
        /*If the root is not null, a recursive method is called that introduces the profile
        * into the right place.*/
        else{
            insertion(root,profile);
        }
    }

    /**
     * @param current The current node in the recursive method.
     * @param toBeInserted The node that has to be inserted.
     */
    private void insertion(BSTNode current, BSTNode toBeInserted){
        /*If the name of the profile to be inserted comes after the current profile,
        * the getR method is being called.*/
        if(toBeInserted.getProfile().getName().compareTo(current.getProfile().getName())>0){
            /*If the getR method of the current node returns null, the profile
            * that has to be inserted comes in here.*/
            if(current.getR()==null){
                current.setR(toBeInserted);
            }
            /*Otherwise, the recursive method is called once again
            * and the current node is obtained using getR method.*/
            else{
                insertion(current.getR(),toBeInserted);
            }
        }
        /*If the name of the profile to be inserted comes before the current profile,
         * the getL method is being called.*/
        else{
            /*If the getL method of the current node returns null, the profile
             * that has to be inserted comes in here.*/
            if(current.getL()==null){
                current.setL(toBeInserted);
            }
            /*Otherwise, the recursive method is called once again
             * and the current node is obtained using getL method.*/
            else{
                insertion(current.getL(), toBeInserted);
            }
        }
    }

    /**
     * Prints the BST in alphabetical order.
     */
    public void printAlphabetical() throws NullPointerException{
        printAlphabetical(root);
    }

    /**
     * Recursive method that prints the names in alphabetical order
     * from the current node
     * @param n The current node.
     */
    private void printAlphabetical(BSTNode n){
        if(n.getL()!=null){
            printAlphabetical(n.getL());
        }
        System.out.println(n.getProfile().getName());
        if(n.getR()!=null){
            printAlphabetical(n.getR());
        }
    }

    /**
     *
     * @param name The profile name that is searched in the BST.
     * @return A recursive method that verifies if the name exists in the BST.
     */
    public Profile searchProfile(String name){
        return BSTProfileSearch(this.root,name);
    }

    /**
     *
     * @param n The node from which the recursive method is performed.
     * @param name The name of the profile that has to be found in the BST.
     * @return The profile in the BST, or the exception if the profile cannot be found.
     * @throws NoSuchElementException if the profile cannot be find in the BST.
     */
    private Profile BSTProfileSearch(BSTNode n, String name)
        throws NoSuchElementException {
        String nodeName=n.getProfile().getName();
        Profile returnProfile=n.getProfile();

        /*if the searched name equals the initial node name,
        * then the return profile becomes the profile found in the initial node.*/
        if(name.equals(nodeName)){
            returnProfile=n.getProfile();
        }
        else{
            /*If the name of the profile to be found comes before the current profile,
             * the getL method is being called.*/
            if(name.compareTo(nodeName)<0){
                /*If the getL method of the current node returns null,
                * an exceptin is being thrown.*/
                if(n.getL()==null){
                    throw new NoSuchElementException("Cannot find profile: "+
                            name);
                }
                /*Otherwise, the recursive method is called once again
                 * and the current node is obtained using getL method.*/
                else{
                    returnProfile=BSTProfileSearch(n.getL(),name);
                }
            }
            /*If the name of the profile to be inserted comes after the current profile,
             * the getR method is being called.*/
            else if(name.compareTo(nodeName)>0){
                /*If the getR method of the current node returns null,
                 * an exceptin is being thrown.*/
                if(n.getR()==null){
                    throw new NoSuchElementException(("Cannot find profile: "+
                            name));
                }
                /*Otherwise, the recursive method is called once again
                 * and the current node is obtained using getR method.*/
                else{
                    returnProfile=BSTProfileSearch(n.getR(), name);
                }
            }
        }
        return returnProfile;
    }

    /* THESE 2 METHODS WERE USED TO TEST IF THE FRIENDSHIP FILE IS READ CORRECTLY.
    public void printFriends(){
        printFriends(root);
    }

    private void printFriends(BSTNode n){
        if(n.getL()!=null){
            printFriends(n.getL());
        }
        System.out.println(n.getProfile().getName()+" friends are: ");
        for(int i=0;i<n.getProfile().numOfFriends();i++){
            System.out.println(n.getProfile().getFriend(i).getName());
        }
        System.out.println("\n");
        if(n.getR()!=null){
            printFriends(n.getR());
        }
    }
    */
}
