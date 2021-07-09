package com.company;
import java.util.*;
public class Hangman {

    public static void main(String[] args) {
	// write your code here
        Scanner sc= new Scanner(System.in);
        while (true) {
            Random random = new Random();

            String[] words = {"skin", "absent", "fiber", "sum", "hair", "poem", "books"}; //array of random words
            int ran = random.nextInt(7);//generating random index
            String word = words[ran];//assigning the word from array

            int wordLen = words[ran].length();//finding length of word
            String[] wholeWord = new String[wordLen];


            //printing hangman
            System.out.println("H A N G M A N");
            System.out.println("+---+");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println(" ===");

            //placing _ in so user can guess it after
            for (int j = 0; j < wordLen; j++) {
                wholeWord[j] = "_";
            }

            String notChar = "";

            //looping until the wholeword is filled
            while (Arrays.asList(wholeWord).contains("_")) {
                char charr;
                while (true) {
                    System.out.println("Guess a letter : ");
                    charr = sc.next().charAt(0);//taking input from user

                    //checking condition if user entering unique letter or no
                    if (!notChar.contains(String.valueOf(String.valueOf(charr))) && !Arrays.asList(wholeWord).contains(String.valueOf(charr))) {
                        break;
                    }
                    System.out.println("You have already guessed that letter. Choose again.\n");
                }

                int k = 0;
                boolean flg = true;

                //looping through the word
                for (String c : word.split("")) {
                    if (c.contains(String.valueOf(charr))) { //letter matches in charater then replace _ with the letter
                        wholeWord[k] = c;
                        flg = false;
                    }
                    k++;
                }
                //add letter to notchar variable if the letter doesn't match
                if (flg) {
                    notChar += "" + charr;
                }

                System.out.println("Missed letters: " + notChar); //list of missed letters
                System.out.println(Arrays.toString(wholeWord).replace(",", "")); //word

                //hangman conditions if user misses letters
                if (notChar.length() == 0) {
                    System.out.println("+---+");
                    System.out.println("  |");
                    System.out.println("  |");
                    System.out.println("  |");
                    System.out.println("  |");
                    System.out.println(" ===");
                } else if (notChar.length() == 1) {
                    System.out.println("+---+");
                    System.out.println("o |");
                    System.out.println("  |");
                    System.out.println("  |");
                    System.out.println("  |");
                    System.out.println(" ===");
                } else if (notChar.length() == 2) {
                    System.out.println("+---+");
                    System.out.println("o |");
                    System.out.println("| |");
                    System.out.println("  |");
                    System.out.println("  |");
                    System.out.println(" ===");
                } else if (notChar.length() == 3) {
                    System.out.println("+---+");
                    System.out.println("o |");
                    System.out.println("| |");
                    System.out.println("| |");
                    System.out.println("  |");
                    System.out.println(" ===");
                } else if (notChar.length() == 4) {
                    System.out.println("+---+");
                    System.out.println("o |");
                    System.out.println("| |");
                    System.out.println("| |");
                    System.out.println("| |");
                    System.out.println(" ===");

                    System.out.println("GAME OVER! The word was " + word);
                    break;
                }

            }
            //printing the user won
            if(!Arrays.asList(wholeWord).contains("_")){
                System.out.println("Yes! The secret word is "+ word +"! You have won!");
            }

            //asking the user if they wants to play again
            System.out.println("Do you want to play again? (press y for yes or n for no)");
            if(sc.next().charAt(0)=='n'){//if user says no then breaking out of the game
                sc.close();
                break;
            }
        }

    }

}
