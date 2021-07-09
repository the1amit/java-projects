package com.company;

import java.util.Scanner;

public class DragonCave {
    public static void main(String[] args) {
        //using scanner class for input functionality
        Scanner scan=new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "\n" +
                "and will share his treasure with you. The other dragon\n" +
                "\n" +
                "is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");
        int cave=scan.nextInt(); // taking input and storing to the cave variable

        //checking which cave user has selected and printing message accordingly
        if(cave==1){
            System.out.println("You approach the cave...\n" +
                    "\n" +
                    "It is dark and spooky...\n" +
                    "\n" +
                    "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                    "\n" +
                    "Gobbles you down in one bite!");
        }else if(cave==2){
            System.out.println("You approach the cave...\n" +
                    "\n" +
                    "It is dark and spooky...\n"+
                    "\n" +
                    "A large dragon jumps out in front of you! the dragon looks friendly and...\n" +
                    "\n" +
                    "Offering the treasure to you!");
        }else {
            System.out.println("Wrong cave!!!");
        }

    }
}
