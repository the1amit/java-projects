package com.company;

import java.util.*;

public class Tiktoctoe {
    static ArrayList<Integer> playerPositions=new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions=new ArrayList<Integer>();

    public static void main(String[] args) {

        while(true){
            char[][] gameBoard={{' ','|',' ','|',' '},
                    {'-','-','-','-','-'},
                    {' ','|',' ','|',' '},
                    {'-','-','-','-','-'},
                    {' ','|',' ','|',' '}};

            Scanner scan=new Scanner(System.in);
            printBoard(gameBoard);

            System.out.println("Do you want to be X or O?");
            char sym=scan.next().charAt(0);

            while (true){
                System.out.println("What is your next move? (1-9)");
                int playerPos=scan.nextInt();
                while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                    System.out.println("taken! enter new move");
                    playerPos=scan.nextInt();
                }

                placePeice(gameBoard,playerPos,"player",sym);
                String result=checkWinner();
                if(result.length()>0){
                    printBoard(gameBoard);
                    System.out.println(result);
                    break;
                }

                Random rand=new Random();
                int cpuPos=rand.nextInt(9) + 1;
                while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){

                    cpuPos=rand.nextInt(9) + 1;
                }

                placePeice(gameBoard,cpuPos,"cpu",sym);

                printBoard(gameBoard);

                result=checkWinner();
                if(result.length()>0){
                    System.out.println(result);
                    break;
                }

            }
            System.out.println("Do you want to play again? (yes or no)");
            char out=scan.next().charAt(0);
            if(out != 'y'){
                break;
            }else {
                playerPositions.clear();
                cpuPositions.clear();
            }
        }




    }
    public static void printBoard(char[][] gameBoard){
        for(char[] row:gameBoard){
            for (char r:row){
                System.out.print(r);
            }
            System.out.println();
        }
    }
    public static void placePeice(char[][] gameBoard,int pos, String usr,char sym){
        char symbol=' ';
        if(usr.equals("player")){
            if(sym=='O'){
                symbol = 'O';
            }else{
                symbol = 'X';
            }

            playerPositions.add(pos);
        }else if(usr.equals("cpu")) {
            if(sym=='O'){
                symbol = 'X';
            }else {
                symbol = 'O';
            }
            cpuPositions.add(pos);
        }

            switch (pos){
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> winn =new ArrayList<List>();
        winn.add(topRow);
        winn.add(midRow);
        winn.add(botRow);
        winn.add(leftCol);
        winn.add(midCol);
        winn.add(rightCol);
        winn.add(cross1);
        winn.add(cross2);

        for (List l : winn){
            if(playerPositions.containsAll(l)){
               return "You have beaten The Computer! You Won.";
            }else if(cpuPositions.containsAll(l)){
                return "The computer has beaten You! You lose.";
            }else if(playerPositions.size()+cpuPositions.size() ==9){
                return "CAT";
            }
        }



        return "";

    }
}
