import java.util.ArrayList;
/**
 * Profile represents a person's profile within the social network, and stores
 * information about that user - such as their name, date of birth, where they're from,
 * and their interests - and connects the profile to other profiles through
 * "friendships", and a list of these friendships are also stored in the Profile
 * object.
 *
 * @author Ioan Mazurca
 * @version 1.0
 * */


public class Profile {
    private String lastName;
    private String firstName;
    private int day;
    private int month;
    private int year;
    private String townOfResidence;
    private String countryOfResidence;
    private String nationality;
    private String emailAddress;
    private String[] interest;
    private ArrayList<Profile> friends=new ArrayList<>();

    /**
     * Creates a user profile
     *
     * @param lastName The user's last name.
     * @param firstName The user's first name.
     * @param day The day of the user's date of birth.
     * @param month The month of the user's date of birth.
     * @param year The year of the user's date of birth.
     * @param townOfResidence  The town the user resides in.
     * @param countryOfResidence The country the user resides in.
     * @param nationality The user nationality.
     * @param emailAddress The email adress of the user.
     * @param interest The user's interests.
     */

    public Profile(String lastName,String firstName, int day, int month, int year, String townOfResidence, String countryOfResidence, String nationality, String emailAddress, String[] interest){
        this.lastName=lastName;
        this.firstName=firstName;
        this.day=day;
        this.month=month;
        this.year=year;
        setTownOfResidence(townOfResidence);
        setCountryOfResidence(countryOfResidence);
        setNationality(nationality);
        setEmailAddress(emailAddress);
        setInterest(interest);
    }


    /**
     * Sets the user town of residence.
     * @param townOfResidence The user town of residence.
     */
    public void setTownOfResidence(String townOfResidence){
        this.townOfResidence=townOfResidence;
    }

    /**
     *
     * @return The user town of residence.
     */
    public String getTownOfResidence(){
        return townOfResidence;
    }

    /**
     * Sets the user country of residence.
     * @param countryOfResidence The user country of residence.
     */
    public void setCountryOfResidence(String countryOfResidence){
        this.countryOfResidence=countryOfResidence;
    }

    /**
     *
     * @return The user country of residence.
     */
    public String getCountryOfResidence(){
        return this.countryOfResidence;
    }

    /**
     * Sets the user nationality.
     * @param nationality The user nationality.
     */
    public void setNationality(String nationality){
        this.nationality=nationality;
    }

    /**
     *
     * @return The user nationality.
     */
    public String getNationality(){
        return nationality;
    }

    /**
     * Sets the user's interests.
     * @param interests The user's interests.
     */
    public void setInterest(String[] interests){
        interest=new String[interests.length];
        int i;
        for(i=0;i<interests.length;i++){
            this.interest[i]=interests[i];
        }
    }

    /**
     * Sets the email adress of the user.
     * @param emailAddress The email adress of the user.
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress=emailAddress;
    }

    /**
     *
     * @return The email adress of the user.
     */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     *
     * @return The user's interests as a string.
     */
    public String getInterest(){
        String allInterests="";
        for(int i=0;i<interest.length;i++){
            allInterests=allInterests+interest[i]+" ";
        }
        return allInterests;
    }

    /**
     *
     * @return The date of birth of the user.
     */
    public String getDateOfBirth(){
        return (this.day+"/"+this.month+"/"+this.year);
    }

    /**
     *
     * @return The full name of the user.
     */
    public String getName(){
        return (firstName+" "+lastName);
    }

    /**
     * Add a profile to the user's friend list.
     * @param p A profile added to the friends list of the user.
     */
    public void addFriend(Profile p){
        this.friends.add(p);
    }

    /**
     *
     * @param i The friend found in position i of the user's friend list.
     * @return The ith friend of the user.
     */
    public Profile getFriend(int i){
        return friends.get(i);
    }

    /**
     *
     * @return The number of friends of the user's friend list.
     */
    public int numOfFriends(){
        return friends.size();
    }

    /**
     *
     * @return The description of the user profile
     */
    public String toString(){
        String fullDescription="Name: ";
        fullDescription+=getName()+"\n";
        fullDescription+="Date of birth: "+getDateOfBirth()+"\n";
        fullDescription+="Town of residence: "+getTownOfResidence()+"\n";
        fullDescription+="Country of residence: "+getCountryOfResidence()+"\n";
        fullDescription+="Nationality: "+getNationality()+"\n";
        fullDescription+="Email adress: "+getEmailAddress()+"\n";
        fullDescription+="User's interests: "+getInterest()+"\n";
        fullDescription+="User's friend list: ";

        for(int i=0;i<numOfFriends();i++){
            fullDescription+=this.getFriend(i).getName()+"; ";
        }

        return fullDescription;
    }

}
