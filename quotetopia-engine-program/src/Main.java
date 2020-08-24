import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *NOTE: Below is a list of notes to remember when programming the database:
 * 1) Every quote MUST have an author. If the quote does not have an author, put "Unknown" after the hyphen
 * 2) Every quote begins and ends with quotation marks. EX. "This is a quote."
 * 3) Every iteration of a quote starting has a hyphen (-) to distinguish that after is the authors name
 * 4) Every "quote.txt" added to the database folder, the program must be able to generate a master list and know what quotes belong to what topic.
 * 5) The database must be able to call and spit out a random quote from the selected topic
 **/
public class Main {

    static Hashtable[] hashArrayQuotes; //hashTable of Arrays of Quotes
    static Hashtable[] hashArrayAuthors; //hashTable of Arrays of Authors
    static int hopper = 0; //Globally keeps track of how many categories of topics there are.
    static int selection;

    public static void generateQuotefromTopic(int topic) {
        char next = 'y';
        int size = 10;

        ArrayList < Integer > list = new ArrayList < Integer > (size);
        for (int i = 1; i <= size; i++)
            list.add(i);

        Random rn = new Random();
        while (next != 'n') {
            while (list.size() > 0) {
                int index = rn.nextInt(list.size());
                int temp = list.remove(index);
                System.out.println(hashArrayQuotes[topic - 1].get(temp));
                System.out.println(hashArrayAuthors[topic - 1].get(temp));

                //ask user if they want to continue
                System.out.println("Next? (y/n)");
                Scanner c = new Scanner(System.in);
                next = c.nextLine().charAt(0);

                //breaks the list random size
                if (next == 'n')
                    break;
            }
            if (list.size() <= 0)
                break;
        }
    }

    //This function helps read and store quotes and authors from files to hashTables
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File("C:\\Users\\Christian\\Desktop\\Quotetopia\\quotes-database\\" + fileName);
        Scanner sc = new Scanner(file);

        Hashtable < Integer, String > quotes = new Hashtable();
        Hashtable < Integer, String > authors = new Hashtable();

        int qtKey = 1; //quote key (HARDCODED at 1 to match the topic selection function)
        int atKey = 1; //author key (HARDCODED at 1 to match the topic selection function) Might use hashTable[0] to store other info.

        //What does the line start: with a Quote( " ) or a hyphen( - )
        while (sc.hasNextLine()) { //displays all file info
            String quote_author = sc.nextLine();

            if (quote_author.charAt(0) == '"') { //Determines a Quote line in file
                //System.out.println(quote_author); //TEST CASE: What is the Quote that passed if statement
                quotes.put(qtKey, quote_author); //store quote
                qtKey += 1;
            } else if (quote_author.charAt(0) == '-') { //Determines an Author line in file
                //System.out.println(quote_author); //TEST CASE: What is the Author that passed if statement
                authors.put(atKey, quote_author); //store author
                atKey += 1;
            }
        }
        hashArrayQuotes[hopper] = quotes;
        hashArrayAuthors[hopper] = authors;
        hopper += 1; //move to next bucket

        /*
         * while (sc.hasNextLine()) //displays all file info
         * System.out.println(sc.nextLine());
         * */
    }

    //Setups up a hashTable of quotes by reading the files inside of the folder.
    //Creates a Quotes HashTable and an Authors HashTable
    //Quote and Author are in the same key as the the other
    //Ex. hashArrayQuote[1] was said by hasshAuthors[1].
    public static void readDatabaseFolder() throws FileNotFoundException {
        File folder = new File("C:\\Users\\Christian\\Desktop\\Quotetopia\\quotes-database"); // This needs to be changed to the database location of the user's Folder location.
        File[] listOfFiles = folder.listFiles();

        int numFiles = folder.listFiles().length; //counts how many file.txt are in the folder
        String[] fileNames = new String[numFiles]; //sets size of fileName array

        int i = 0; //counts how many files till end
        for (File file: listOfFiles) {
            if (file.isFile()) {
                //System.out.println(file.getName()); //TEST CASE: Shows what files are in this folder
                fileNames[i] = file.getName();
                i++;
            }
        }

        hashArrayQuotes = new Hashtable[i];
        hashArrayAuthors = new Hashtable[i];

        //This loop sends the file from the folder database to be dissected and organized inside a hashTable
        for (int n = 0; n < i; ++n) {
            //System.out.println("Filename[" + n + "] = " + fileNames[n]); //TEST CASE: Shows what files were stored in
            readFile(fileNames[n]);
        }

    }

    //Displays Main Menu
    public static void displayMenu() {
        System.out.println("Quotetopia - Select a category: ");
        System.out.println("1. Fitness");
        System.out.println("2. Inspirational");
        System.out.println("3. Motivational");
        System.out.println("4. Books");
        System.out.println("5. Authors");
        System.out.println("6. Entrepreneurs");
        System.out.println("0. Exit");
    }

    //Returns user's selection of topic (HARDCODED INPUT)
    public static int selectTopic() {
        Scanner in = new Scanner(System.in);
        int topic = in .nextInt();
        return topic;
    }


    public static void main(String[] args) throws FileNotFoundException {
        //Generate database in hash tables
        readDatabaseFolder();

        while (true) {
            displayMenu();
            selection = selectTopic();
            if (selection == 0) break;
            generateQuotefromTopic(selection);
        }
        System.out.println("Goodbye User!");
    }
}