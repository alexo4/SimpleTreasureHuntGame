
package treasurehunt;

import java.util.Random;
import java.util.Scanner;

public class TreasureHunt {

    static String [][] board;
    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);
    static int lives = 10;
    static int found = 0;
    static int total = 0;
    
    public static void setUpBoard(){//this sets up the bigging board with empty spaces
        for (int i = 0; i < 10; i++){
                for (int j = 0; j< 8; j++){
                    board[i][j] = "[ ]";
                    System.out.print(board[i][j]);
                }
                System.out.println(""); 
            }
}
    public static void setUpCoins(){//this adds randoms coins onto the empty spaces
        for (int i = 0; i<10;i++){
            int position1 = rand.nextInt(10);
            int position2 = rand.nextInt(8);
            int coins = rand.nextInt((9-1)+1)+1; 
            board[position1][position2] = "["+ Integer.toString(coins) + "]";
        }
    }
    public static void play(){
        lives = 10;
        total = 0;
        found = 0;
        while (lives >0){
            try{//makes sure no errors occur
                System.out.println("You have "+lives+" lives left");

                System.out.print("Guess the column the treasure is in(max 8): ");//asks for their guess in the column
                int columnGuess = Integer.parseInt(input.nextLine());

                System.out.print("Guess the row the treasure is in(max 10): ");//asks for their guess in the row
                int rowGuess = Integer.parseInt(input.nextLine());

                if (board[rowGuess-1][columnGuess-1].equals("[ ]")){//checks if where they have guessed is empty
                    System.out.println("Wrong");
                    lives = lives -1;
                }else{
                    System.out.println("You are right!");
                    total = total + Integer.parseInt(String.valueOf(board[rowGuess-1][columnGuess-1].charAt(1)));//adds the coins from the square to the total
                    System.out.println("Your total so far is: "+total);
                    found = found + 1;
                    if (found == 10){//if they find all the coins it automically ends game as a win
                        System.out.println("You have won!");
                        break;           
                    }
                }
            }catch(Exception e){
                System.out.println("Please input a number within range");
            }
        }
    }
    
    public static void board(){//print the board with coins on
        for (int i = 0; i < 10; i++){
            for (int j = 0; j< 8; j++){
                
                System.out.print(board[i][j]);
            }
            System.out.println(""); 
        }
    }
    
    public static void main(String[] args) {
  
        board = new String [10][8];
        boolean playAgain = true;
        while(playAgain == true){//loop so it can be played multiple times
            setUpBoard();
            setUpCoins();
            play();
            
            if (found != 10){
                System.out.println("You have lost!");
            }
            System.out.println("Your total coins were: £"+total);
            System.out.println("This is the answer:");
            board();
            System.out.println("Would you like to play again?: ");
            String choice = input.next();//asks ser if they want to play again
            if (choice.equalsIgnoreCase("no")){
                 System.out.println("Thank you for playing");
                break;
            }
            else if(choice.equalsIgnoreCase("yes")){
                System.out.println("Thank you for playing again");
            }
        }
        
    }

    
}