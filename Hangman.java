import java.io.*;
import java.util.*;

//class name Hangman
public class Hangman {
   // main method
	public static void main(String[] args) {
      String[] x = {};//create String array
      game(x);//call the game method
   }
      // create void method strnig type
      public static void game(String[] guesses){
      
      guesses = loadWords();
      //Scanner package 
      Scanner scanner = new Scanner(System.in);
      // create Random Constructors
      Random random = new Random();
      
      boolean weareplaying = true;
       
      while(weareplaying){
      
         System.out.println("Welcome to the game, Hangman!");
         // choose random word from word.txt by use loadWords method
         char[] randomwordguess = guesses[random.nextInt(guesses.length)].toCharArray();
         //random word length
         int len = randomwordguess.length;
         
         System.out.println("I am thinking of a word that is "+len+" letters long");
         // create char for playerguess 
         char[] playerguess = new char[len];
         //print '_' instead of word letters
         for(int i=0; i<playerguess.length; i++){
            playerguess[i] = '_';
         }
         //user is allowed 5 guesses
         int life = 5;
         boolean wordisguessed = false;
         int tries = 0;
         
         while(!wordisguessed && tries != life){
            System.out.println("-----------------------");
            
            System.out.println("You have "+(life - tries)+" guesses left." );

            System.out.print("Please guess a letter: ");
            //user input 
            char input = scanner.next().charAt(0);
            //convert a char array to a string
            String str = new String(playerguess);
            //convert a char to a string
            String s=String.valueOf(input);
             
            tries++;
            
            boolean temp = false;
            
            if(input != '_'){
               
               for(int i=0; i<len; i++){
                
                  if(randomwordguess[i] == input){
                     playerguess[i] = input;
                     temp = true; 
                  }
               }
               
               if(temp){
                  if(str.contains(s)){
                     System.out.print("Oops! You’ve already guessed that letter ");
                  }
                  else{                                                                
                     System.out.print("Good guess: ");
                  }
                  
                  life++;
               }
               else{
                  System.out.print("Oops! That letter is not in my word ");
               }
               //print playerguess output
               printArray(playerguess);
               
               if(isthewordguessed(playerguess)){
                  wordisguessed = true;
                  System.out.println("congratulation you win");
               }
            }
         }
         if(!wordisguessed){
            System.out.println("---------------");
            System.out.print("Sorry, you ran out of guesses. The word was ");
            printArray(randomwordguess);
            break;
         }
         else{
            break;
         }
         
      }
      System.out.println("!!!!!!!!game over!!!!!!!!");
   }
   
   //create void method char type looping in the random word
   public static void printArray(char[] array){
      for(int i=0; i<array.length; i++){
         System.out.print(array[i]+" ");
      }
      System.out.println();
   }
   
   //create boolean method retrun boolean 
   public static boolean isthewordguessed(char[] array){
      for(int i=0; i<array.length; i++){
         if(array[i] == '_') 
         return false;
      }
      return true;
   }
   
   
   	/* Helper Code -----------------------------------------------
   	* You do not have to understand the provided helper methods
   	* But you will have to know how/when to call these methods
   	* Make sure to read the instructions
   	* DO NOT make any changes to the methods below UNLESS specified
   	* by the directions.
   	*/
      
   	public static String[] loadWords()
   	{
    	   /*
   		* Returns a String array of valid words.
   		* Also prints out the total number of words (Strings) in the array.
   		*/
   
      	ArrayList<String> wordList = new ArrayList<String>();
      	File f = new File("words.txt");
      	String[] wordsArr = new String[wordList.size()];
      	try
      	{
         	Scanner in = new Scanner(f);
         	while(in.hasNext())
         	{
            	String word = in.next();
            	wordList.add(word);
         	}
         	in.close(); 
         	System.out.println("Loading words from the file......");
         	System.out.println(wordList.size()+" words loaded.");
         	//System.out.println("-------------");
         	wordsArr = (String[])wordList.toArray(wordsArr);
      	} catch (FileNotFoundException ex) {
         	System.out.println("File not found.");
      	}
      	return wordsArr;
   	}
      
      
      
      public static char[] stringToChar(String secretWord)
   	{
   		/**
   		* takes a string which is a secretWord
   		* Returns a char array of secretWord
   		* You can use printArray method to test the output
   		*/
      	char[] secretArr = new char[secretWord.length()];    
      	for (int i = 0; i < secretArr.length; i++)
      	{
         	secretArr[i] = secretWord.charAt(i);
      	}
      	return secretArr; 
   	}
}