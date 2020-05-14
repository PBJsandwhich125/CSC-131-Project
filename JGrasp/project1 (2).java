import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

class project1 {
   static boolean mainCheckFlag = false;
   public static void main (String args[]) {
                //Get correct movie names from txt file
        //This all needs to be placed at the start of the program  
        String[] arrayS = { "a", "b", "c"};
        int counterS = 0;         
        try{

         File myObj = new File("movie_info.txt");
      		Scanner myReader = new Scanner(myObj);
      		while (myReader.hasNextLine()) {
        		String data = myReader.nextLine();
            arrayS[counterS] = data;
            counterS ++;
        		
      		}
      		myReader.close();
         
         }catch(FileNotFoundException e){
         		System.out.println("File open Error");
         }
         
         String movieNamesnp = arrayS[1];
         // made array for movie names and array for votes
         String[] movieNames = movieNamesnp.split("\\s+");
         int[] arrayofVotes = new int[9]; 
         for(int i = 0; i < arrayofVotes.length; i++){
            arrayofVotes[i]  = 0;
         }
   // call your specific function in this main to test for runtime errors or uncomment your general method to run it
      //static boolean mainCheckFlag = false;
      int choice = 1;
      while ( choice != 0){
      System.out.println("Welcome to the Oscar Movies App! Please pick an option:");
      System.out.println("(1) Accounts");
      System.out.println("(2) Movies");
      System.out.println("(3) Reviews");
      System.out.println("(4) Voting (Must be logged in)");
      System.out.println("(0) quit");
      //MovieAccounts();
      //Reviews();
      Scanner in = new Scanner(System.in);
      choice = in.nextInt();
         switch ( choice ){
           case 1:
            MovieAccounts();
            break;
         case 2:
            PrintTitle();
            break;
         case 3:
            Start();
            break;
         case 4:
            VotingFunction(movieNames, arrayofVotes);
            break;
         case 0:{
            System.out.println("You are now leaving the Oscar App");
            System.exit(0);
            }
         }
      }
      System.out.println("Back to main");
	}


//Start of Ely code------------------------------------------------------------
//CSC131 Project
//Create Account, Login Verification, Terminate Program
//Eleazar Alvarez




public static LinkedList<String> Usernames = new LinkedList<String>();//Use a linkedlist to store usernames
public static LinkedList<String> Passwords = new LinkedList<String>();//Use a linkedlist to store passwords
public static String FILE_NAME = "accounts.txt"; //This will create a text file called accounts.txt in the directory


public static void MovieAccounts() {

Scanner input = null;// Scanner for user input

try {
   input = new Scanner(System.in);// User Input Scanner to give user a choice

//Loop to give the user ability to choose options

while (true) {
   System.out.println("To login type 1; to create an account type 2; to quit type 3"); //The options to choose
   int choice = input.nextInt();// Getting input for the user choice


//if the user chooses option 2
if (choice == 2) {

   System.out.println("Let's create a new account!");
   System.out.println("Please enter a username:");
   String username = input.next();// Grab input to create username
   System.out.println("Please enter a password:");
   String password = input.next();// Grab input to create password
   WriteToFile (username,password);//Writing account info into file
   System.out.println("Succesfully Created Account");

//if the user doesn't choose option 2 but choose option 1
} else if (choice == 1) {

   System.out.println("Please enter your username and password to login");
   ReadFile();//Reading account information from file and update linklist

   System.out.println("First, enter your Username:");
   String username = input.next();// Grab input to checkusername

//checking if username is not blank and if it exists
if (username!= null && !username.equalsIgnoreCase("") && CheckUsername(username)) {
   System.out.println("Username found!");
   System.out.println("Enter Password:");
   String password = input.next();// Getting input for user password to check

//checking if password is not blank and if it matches
if (password!= null && !password.equalsIgnoreCase("") && CheckPassword(password)) {
   System.out.println("Succesfully Logged In.");
} else {
   System.out.println("Password does not match account.");
}
} else {
   System.out.println("That account does not exist.");
   }


   //if the user doesn't choose option 1,2 but choose option 3. 
   //throw exception if user tries anything other than 1,2,3
   } else if (choice == 3) {
      System.out.println("Exiting Program");
      main(null);
   }
}
   } catch (Exception e) {
      e.printStackTrace();
   } finally {
   try {
      if (input!= null) {
         input.close();//Close Scanner
      }
   } catch (Exception e) {
      e.printStackTrace();
   }
   }
}


//Method to check is username is in List
public static boolean CheckUsername(String username) {
   boolean CheckFlag = false; //username exits flag, if the username exits set as true otherwise false
   if (Usernames!= null) {
   //iterates username LinkedList
      for (int i=0;i<Usernames.size();i++) {
   //Check to see if username matches user input
         if (Usernames.get(i).equals(username)) {
            CheckFlag = true;//If it is matched flag set as true
            break;//exit since it matches
         }
      }
   }
   return CheckFlag; //returning flag
}


//Method to check is password is in List
public static boolean CheckPassword(String password) {
   boolean CheckFlag2 = false;//password exits flag, if the username exits set as true otherwise false
   if (Passwords!= null) {
   //iterates password LinkedList
      for (int i=0;i<Passwords.size();i++) {
   //Check to see if password matches user input
         if (Passwords.get(i).equals(password)) {
         CheckFlag2 = true;//If it is matched flag set as true
         mainCheckFlag = true;
         break;//terminating the loop as already matched
         }
      }
   }
   
   return CheckFlag2; //returning flag
}


//Method to readfile and update LinkList
public static void ReadFile() {

   Scanner stream = null;

   try {
      Usernames.clear();//Clear the LinkList for username
      Passwords.clear();//Clear the LinkList for password
      File fileInput = new File(FILE_NAME); //Create a new file
      stream = new Scanner(fileInput); //Creating new Scanner for stream

   // Iterating each line of file
   while (stream.hasNext()) {
      String line = stream.nextLine();//get new line from text file
      String[] lineArray = line.trim().split("\\s+");//Split each line by space to get string array
      String username = lineArray[0];//Grab username from first index of string array
      Usernames.add(username);//Add username into LinkedList
      String password = lineArray[1];//Grab password from second index of string array
      Passwords.add(password);//Add password into LinkedList in same index
   }
   } catch (FileNotFoundException e) {
      e.printStackTrace();
   } catch (Exception e) {
      e.printStackTrace();
   } finally {
      try {
         if (stream != null) {
         stream.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}


//Method to add username and password to list
public static void WriteToFile(String username, String password) {

   FileWriter fw = null;
   BufferedWriter bw = null;


   try {
      File file = new File(FILE_NAME);//Grab file object based on file name

      //if it doesn't exist make a new file
      if (!file.exists()) {
         file.createNewFile();//creating new file
      }
   fw = new FileWriter(FILE_NAME,true);// create File Writer to write and append text file, true means append new line
   bw = new BufferedWriter(fw);// creating Buffered Writer to write text file
   bw.write(username+" "+password);//adding new line of user name and password separated by space
   bw.newLine();//going to next line
   bw.flush();// Flushing Buffered Writer
   fw.flush();// Flushing File Writer
   } catch (IOException ioe) {
   ioe.printStackTrace();
   } catch (Exception e) {
   e.printStackTrace();
   } finally {
      try {
         if (fw != null) {
            fw.close();// closing File Writer
         }
         if (bw != null) {
            bw.close();// closing Buffered Writer
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

//End of Ely code----------------------------------------------------------------

//Start of BIG BIRD code---------------------------------------------------------
public static void Movies() {
   
   // movie list can be expanded for more movies 
     LinkedList<String> movie0 = new LinkedList<String>();//Use a linkedlist to store parasite
     LinkedList<String> movie1 = new LinkedList<String>();//Use a linkedlist to store 1917
     LinkedList<String> movie2 = new LinkedList<String>();
     LinkedList<String> movie3 = new LinkedList<String>();
     LinkedList<String> movie4 = new LinkedList<String>();
     LinkedList<String> movie5 = new LinkedList<String>();
     LinkedList<String> movie6 = new LinkedList<String>();
     LinkedList<String> movie7 = new LinkedList<String>();
     LinkedList<String> movie8 = new LinkedList<String>();
     LinkedList<String> movie9 = new LinkedList<String>();
     String FILE_NAME1 = "movie_info.txt"; //This will create a text file in the directory
   
     int movieNum = 9; // just hold how many time to loop for movies, can be increased
     }

    
   public static void PrintMovie(int x) { //method to load info from text file into linkedlist then print,      
   
      
   // movie list can be expanded for more movies 
     LinkedList<String> movie0 = new LinkedList<String>();//Use a linkedlist to store parasite
     LinkedList<String> movie1 = new LinkedList<String>();//Use a linkedlist to store 1917
     LinkedList<String> movie2 = new LinkedList<String>();
     LinkedList<String> movie3 = new LinkedList<String>();
     LinkedList<String> movie4 = new LinkedList<String>();
     LinkedList<String> movie5 = new LinkedList<String>();
     LinkedList<String> movie6 = new LinkedList<String>();
     LinkedList<String> movie7 = new LinkedList<String>();
     LinkedList<String> movie8 = new LinkedList<String>();
     LinkedList<String> movie9 = new LinkedList<String>();
     String FILE_NAME1 = "movie_info.txt"; //This will create a text file in the directory
   
     int movieNum = 9; // just hold how many time to loop for movies, can be increased

   // must change to fufil review info just testing moive deatils
      Scanner stream = null;
      
      try {
         movie0.clear();//Clear the LinkList for movie0
         movie1.clear();
         movie2.clear();
         movie3.clear();
         movie4.clear();
         movie5.clear();
         movie6.clear();
         movie7.clear();
         movie8.clear();         
         movie9.clear();
                  
         File fileInput = new File(FILE_NAME1); //Create a new file
         stream = new Scanner(fileInput); //Creating new Scanner for stream
         
         // Iterating each line of file
         while (stream.hasNext()) {
            String line = stream.nextLine();//get new line from text file
            String[] lineArray = line.trim().split("\\s+");//Split each line by space to get string array
            
            String row0 = lineArray[0];//Grab info from first index of string array
            movie0.add(row0);//Add movie0 infor into LinkedList
            
            String row1 = lineArray[1];//Grab info from second index of string array
            movie1.add(row1);//Add movie1 into LinkedList in same index
            
            String row2 = lineArray[2];
            movie2.add(row2);
            
            String row3 = lineArray[3];
            movie3.add(row3);
            
            String row4 = lineArray[4];
            movie4.add(row4);
            
            String row5 = lineArray[5];
            movie5.add(row5);
            
            String row6 = lineArray[6];
            movie6.add(row6);
            
            String row7 = lineArray[7];
            movie7.add(row7);
         
            String row8 = lineArray[8];
            movie8.add(row8);
            
         }
         int movie = x;
         String title;
         String website;
         switch (movie) { //printing problem for cases, can be increased
               case 1: title = movie0.get(1);
                       website = movie0.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 2: title = movie1.get(1);
                       website = movie1.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 3: title = movie2.get(1);
                       website = movie2.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 4: title = movie3.get(1);
                       website = movie3.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 5: title = movie4.get(1);
                       website = movie4.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 6: title = movie5.get(1);
                       website = movie5.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 7: title = movie6.get(1);
                       website = movie6.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 8: title = movie7.get(1);
                       website = movie7.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;
               case 9: title = movie8.get(1);
                       website = movie8.get(2);
                       System.out.printf("Title: %s\n", title);
                       System.out.printf("Movie Website: %s\n", website);
                       break;                                           
               default: break;
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
    
   static void PrintTitle(){ //method to print first two lines of textfile aka id and title
         
   // movie list can be expanded for more movies 
     LinkedList<String> movie0 = new LinkedList<String>();//Use a linkedlist to store parasite
     LinkedList<String> movie1 = new LinkedList<String>();//Use a linkedlist to store 1917
     LinkedList<String> movie2 = new LinkedList<String>();
     LinkedList<String> movie3 = new LinkedList<String>();
     LinkedList<String> movie4 = new LinkedList<String>();
     LinkedList<String> movie5 = new LinkedList<String>();
     LinkedList<String> movie6 = new LinkedList<String>();
     LinkedList<String> movie7 = new LinkedList<String>();
     LinkedList<String> movie8 = new LinkedList<String>();
     LinkedList<String> movie9 = new LinkedList<String>();
     String FILE_NAME1 = "movie_info.txt"; //This will create a text file in the directory
   
     int movieNum = 9; // just hold how many time to loop for movies, can be increased

      Scanner stream = null;
      
      try {
      movie0.clear();
      movie1.clear();
      File fileInput = new File(FILE_NAME1); 
      stream = new Scanner(fileInput); 
      
     
      for(int x = 0; x < 2; x++) {
         String line = stream.nextLine();
         String[] lineArray = line.trim().split("\\s+");
         
         String row0 = lineArray[0];
         movie0.add(row0);
         
         String row1 = lineArray[1];
         movie1.add(row1);
         
         String row2 = lineArray[2];
         movie2.add(row2);
         
         String row3 = lineArray[3];
         movie3.add(row3);
         
         String row4 = lineArray[4];
         movie4.add(row4);
         
         String row5 = lineArray[5];
         movie5.add(row5);
         
         String row6 = lineArray[6];
         movie6.add(row6);
         
         String row7 = lineArray[7];
         movie7.add(row7);
         
         String row8 = lineArray[8];
         movie8.add(row8);
      }
      System.out.println(movie0);
      System.out.println(movie1);
      System.out.println(movie2);
      System.out.println(movie3);
      System.out.println(movie4);
      System.out.println(movie5);
      System.out.println(movie6);
      System.out.println(movie7);
      System.out.println(movie8);
     
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      return; 
   }
   
   public static void Start(){
      Scanner input2 = null;
      input2 = new Scanner(System.in);// User Input Scanner to give user a choice
      
      //Loop to give the user ability to choose options
      System.out.println("To exit press 0. To show movie information press the desired movie ID."); //The options to choose
      PrintTitle(); // prints title so they can choose
      int decision = 1;
      while (decision != 0) {
          decision = input2.nextInt(); 
         switch (decision) { //case statement to print movie detail depending on choice, can be expanded for more movies
            case 1: PrintMovie(decision);
                    break;
            case 2: PrintMovie(decision);
                    break;
            case 3: PrintMovie(decision);
                    break;
            case 4: PrintMovie(decision);
                    break;
            case 5: PrintMovie(decision);
                    break;
            case 6: PrintMovie(decision);
                    break;
            case 7: PrintMovie(decision);
                    break;
            case 8: PrintMovie(decision);
                    break;
            case 9: PrintMovie(decision);
                    break;
                    
            default: break;
         }
         System.out.println("To exit press 0. Or press another movie ID");
      }
     

   }
   

//End of BID BIRD code------------------------------------------------------------


// Start of Mike code-------------------------------------------------------------
static void VotingFunction(String[] movieNames, int[] arrayofVotes){ 
         if(mainCheckFlag == false){  //if CheckFlag2 (boolean varible in Ely code) is true, then they are logged in
            System.out.println("Please Login in to access this function");
            return;
         }
                  
         for(int i =0; i < movieNames.length; i++){
            System.out.print(movieNames[i] + " ");
         }
         System.out.println(" ");
         System.out.println("Please type a movie to vote for:" );  
         Boolean movieSelected = false;
         Scanner sc = new Scanner(System.in);
         while(movieSelected != true){
         String userMovie = sc.nextLine();
         //userMovie = movieNames[1];
         for(int i =0; i < movieNames.length; i++){
            if(movieNames[i].equals(userMovie)){
               movieSelected = true;
               arrayofVotes[i] = arrayofVotes[i] + 1;
               
               System.out.println("Your vote has been added thank you");
            }
         }
         if(movieSelected == false){
            System.out.println("Wrong movie, please try again");
         }
         
          
         }
         
         return;
        
      
      
      }
      

//end of mike code----------------------------------------------------------------
}
