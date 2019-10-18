/**
 * BSTNode represents one of the nodes from the BST class.
 * It stores the profile data, as well as the left and right nodes that
 * descend from it.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class BSTNode {
    private Profile data;
    private BSTNode l;
    private BSTNode r;


    /**
     * Creates a node.
     * @param data The profile data found in the node
     */
    public BSTNode(Profile data){
        this.data=data;
    }

    /**
     *
     * @return The profile data found in the node.
     */
    public Profile getProfile(){
        return data;
    }

    /**
     *
     * @param l The left node that descends from the actual node.
     */
    public void setL(BSTNode l){
        this.l=l;
    }

    /**
     *
     * @param r The right node that descends from the actual node.
     */
    public void setR(BSTNode r){
        this.r=r;
    }

    /**
     *
     * @return The left node that descends from the actual node.
     */
    public BSTNode getL(){
        return l;
    }

    /**
     *
     * @return The right node that descends from the actual node.
     */
    public BSTNode getR(){
        return r;
    }

}
