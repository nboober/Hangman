import java.util.Scanner;
import java.util.Arrays;

public class Hangman {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Array of words
        String[] words = {"tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream"};
        //wrong guess index
        int wrong = 0;

        //Boolean to mark if the guess was found
        boolean found = false;

        System.out.println("Welcome, let's play hangman!");

        //Selected random word from array of words
        String word = words[(int) (Math.random() * words.length)];
        //***For testing purposes. Delete later***
//        System.out.println(word);

        //Splits the selected word into an array of characters
        String[] breakDown = word.split("");

        //An Empty array to hold underscores
        String[] dashes = new String[word.length()];


        System.out.print("Here is the word I am thinking of: ");

        //Loops through array of characters and assigns a number of underscores
        //equal to the length of the array of characters
        for(int i = 0; i < breakDown.length; i++){
            dashes[i] = " _ ";
            System.out.print(dashes[i]);

        }

        //Loops through guesses until the wrong guess index equals 5
        do{
            System.out.println();
            System.out.println("Enter your guess letter: ");

            //The next thing entered is saved as a guess
            String guess = scanner.next();

            //Loops through array of characters and compares the array of characters to the guess
            //If they match then the index in the array of underscores is changed from an
            //underscore to the matched letter
            for(int i = 0; i < breakDown.length; i++){
                if(guess.equalsIgnoreCase(breakDown[i])){

                    System.out.print("\nYou guessed right! \n");
                    dashes[i] = guess;

                    found = true;

                    for(int x = 0; x < dashes.length; x++) {
                        System.out.print(dashes[x]);

                    }

                }

            }
            //Wrong index counter
            if(found == true){
                found = false;
            }else{
                wrong++;
                System.out.println("You guessed wrong. You have " + (5-wrong) + " more incorrect tries until the game ends.");
                if(wrong == 5){
                    System.out.println("Sorry, the word was \"" + word + "\". Better luck next time!");
                }
            }
            System.out.println();

            //Compares the dash string to the breakdown string.
            //If they are equal then you win.
            if(Arrays.toString(dashes).equalsIgnoreCase(Arrays.toString(breakDown))){
                System.out.println("\nYou guessed the word! You Win!");
                break;
            }

        }while(wrong != 5);



    }
}
