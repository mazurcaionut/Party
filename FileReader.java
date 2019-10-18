import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FileReader class creates user profiles by reading each line of an input file,
 * and adds the profiles to a binary search tree.
 * @author Ioan Mazurca
 * @version 1.0
 */

public class FileReader {

    /**
     * Reads the attributes of a profile from an input file line and creates a profile.
     * @param in The first scanner used to read the contents of a profile
     * @return The profile with attributes from the input file line.
     */
    private static Profile readContents(Scanner in){
        String lastName=in.next();
        String firstName=in.next();
        int day=in.nextInt();
        int month=in.nextInt();
        int year=in.nextInt();
        String town=in.next();
        String country=in.next();
        String nationality=in.next();
        String emailAdress=in.next();

        in.skip(",");

        String allInterests=in.nextLine();

        Scanner inters=new Scanner(allInterests);
        inters.useDelimiter(";");

        Profile profile=new Profile(lastName,firstName,day,month,year,town,country,nationality,emailAdress, readInterests(inters));

        return profile;
    }

    /**
     * Reads the interests of a user.
     * @param inters The second scanner used to read the user's interests.
     * @return The user's interests array.
     */
    private static String[] readInterests(Scanner inters){
        int n=0;
        ArrayList<String> list=new ArrayList<>();
        while(inters.hasNext()){
            String interest=inters.next();
            list.add(interest);
        }
        String[] interests=new String[list.size()];
        interests=list.toArray(interests);
        return interests;
    }

    /**
     * Reads the profiles and populates the BST.
     * @param in The main scanner that reads all the lines of the input file.
     * @return The BST populated with the Profiles from the input file.
     */
    private static BST readProfileSet(Scanner in){
        BST tree=new BST();

        while(in.hasNextLine()){
            String currentLine=in.nextLine();
            Scanner line=new Scanner(currentLine);
            line.useDelimiter(",");

            tree.insertProfile(readContents(line));

            line.close();
        }

        return tree;
    }

    /**
     * Creates a scanner used to read tokens from an input file.
     * @param filename The name of the input file.
     * @return The method that reads and inserts the profiles into the BST.
     */
    public static BST readProfileSet(String filename){

        File inputFile=new File(filename);
        Scanner in=null;

        try{
            in=new Scanner(inputFile);
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot open"+filename);
            System.exit(0);
        }

        return FileReader.readProfileSet(in);
    }
}
