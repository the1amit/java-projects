package com.company;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        Random random=new Random();

        //input name and storing in variable
        System.out.println("Hello! What is your name?");
        String name=scan.next();

        //while loop for next game
        while (true){
            int randomNum=random.nextInt(20)+1; //generating random value

            System.out.println("Well, " +name+" , I am thinking of a number between 1 and 20.");
            int i=1;
            int num=0;

            //looping for 6 times
            while (i<=6){
                System.out.println("Take a guess.");
                num=scan.nextInt();//taking input from user

                if(num==randomNum){//checking condition if user's input matches computer
                    System.out.println("Good job, " +name+"! You guessed my number in "+i+" guesses!");
                    break;
                }else if(num-randomNum <0){
                    System.out.println("Your guess is too low.");
                }else {
                    System.out.println("Your guess is too high.");
                }

                i++;
                if(i>6){// condition if user inputted 6 times
                    System.out.println("Bad job, " +name+"! my number is "+randomNum+" !");
                }
            }
            System.out.println("Would you like to play again? (y or n)");
            char play=scan.next().charAt(0);

            //if user still wants to play the game
            if(play != 'y'){
                break;
            }
        }



    }
}
