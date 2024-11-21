import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class game {

    public static void rules(String[] ticTacBoard){
        System.out.println("\nAbout the Game : \n\nTic-Tac-Toe is a two-player game where players take turns marking spaces in a 3x3 grid.\nThe objective is to align three of your marks (either horizontally, vertically, or diagonally) before your opponent does.\n");
        displayBoard(ticTacBoard);
        System.out.println();
        System.out.println("\n"+"Game Setup\n" +
                "\n" +
                "1. The game is played on a 3x3 grid.\n" +
                "2. One player uses X, and the other player uses O.\n");
        System.out.println("Rules of Play\n" +
                "\n" +
                "Turns:\n" +
                "1. Players take turns, placing their symbol (X or O) in an empty space on the grid.\n" +
                "2. Only one mark can occupy a space.\n" +
                "\n");
        System.out.println("Winning:\n" +
                "The first player to get three of their marks in a row (horizontally, vertically, or diagonally) wins.\n" +
                "\nExamples of winning combinations:\n" +
                "* Horizontal: Top row (1, 2, 3), middle row (4, 5, 6), bottom row (7, 8, 9).\n" +
                "* Vertical: Left column (1, 4, 7), middle column (2, 5, 8), right column (3, 6, 9).\n" +
                "* Diagonal: Top-left to bottom-right (1, 5, 9) or top-right to bottom-left (3, 5, 7).\n");
        System.out.println(" 1 |  2  | 3 ");
        System.out.println("--------------");
        System.out.println(" 4 |  5  | 6 ");
        System.out.println("--------------");
        System.out.println(" 7 |  8  | 9 ");
        System.out.println("\n" +
                "Tie (Draw):\n" +
                "If all spaces are filled and no player has aligned three marks, the game ends in a tie.\n" +
                "\n" +
                "Invalid Moves:\n" +
                "1. A player cannot place their mark on an already occupied space.\n" +
                "2. A player cannot take multiple turns in a row.\n" +
                "\n" +
                "Ending the Game:\n" +
                "   The game ends immediately when a player wins or the grid is completely filled.\n\n");

    }

    // To Update Board According to Players Choice
    public static void updateBoard(String[] ticTacBoard, int move, int player){
        if(player == 1){
            ticTacBoard[move-1] = "X";
        }
        else{
            ticTacBoard[move-1] = "O";
        }
    }

    // Check for Win
    public static boolean checkBoard(String[] ticTacBoard){
        if(Objects.equals(ticTacBoard[0], ticTacBoard[1]) && Objects.equals(ticTacBoard[1], ticTacBoard[2]) && !(Objects.equals(ticTacBoard[1], " "))){
            return true;
        }
        else if(Objects.equals(ticTacBoard[3], ticTacBoard[4]) && Objects.equals(ticTacBoard[4], ticTacBoard[5]) && !(Objects.equals(ticTacBoard[3], " "))){
            return true;
        }
        else if(Objects.equals(ticTacBoard[6], ticTacBoard[7]) && Objects.equals(ticTacBoard[7], ticTacBoard[8]) && !(Objects.equals(ticTacBoard[6], " "))){
            return true;
        }
        else if(Objects.equals(ticTacBoard[0], ticTacBoard[4]) && Objects.equals(ticTacBoard[4], ticTacBoard[8]) && !(Objects.equals(ticTacBoard[0], " "))){
            return true;
        }
        else if(Objects.equals(ticTacBoard[2], ticTacBoard[4]) && Objects.equals(ticTacBoard[4], ticTacBoard[6]) && !(Objects.equals(ticTacBoard[2], " "))){
            return true;
        }
        else if(Objects.equals(ticTacBoard[0], ticTacBoard[3]) && Objects.equals(ticTacBoard[3], ticTacBoard[6]) && !(Objects.equals(ticTacBoard[0], " "))){
            return true;
        }
        else if(Objects.equals(ticTacBoard[1], ticTacBoard[4]) && Objects.equals(ticTacBoard[4], ticTacBoard[7]) && !(Objects.equals(ticTacBoard[1], " "))){
            return true;
        }
        else if(Objects.equals(ticTacBoard[2], ticTacBoard[5]) && Objects.equals(ticTacBoard[5], ticTacBoard[8]) && !(Objects.equals(ticTacBoard[2], " "))){
            return true;
        }
        return false;
    }

    // Display Board After Each Move
    public static void displayBoard(String[] ticTacBoard){
        for(int i = 0; i < 8; i++){

            if((i+1) % 3 == 0) {
                System.out.print("  "+ticTacBoard[i]+" ");
                System.out.println();
                System.out.println("--------------");
            }
            else{
                System.out.print(" "+ticTacBoard[i]+"  |");
            }
        }
        System.out.print(" "+ticTacBoard[8]+"  ");
    }


    // Play Tic-Tac Game
    public static String playGame(String[] ticTacBoard, String player1_name, String player2_name, int player1_symbol, int player2_symbol){
        Scanner in = new Scanner(System.in);

        System.out.println("\nLet's Begin the match : ");
        for(int i = 0; i < 9; i++){
            int player1_move, player2_move;
            if(i % 2 == 0){
                System.out.print(player1_name+"'s turn : ");
                System.out.println();
                player1_move = in.nextInt();
                while(!(player1_move>=1 && player1_move<=9)){
                    System.out.println("Oops! Out of Range.\nEnter your choice between 1-9");
                    player1_move = in.nextInt();
                    System.out.println();
                }
                while(ticTacBoard[player1_move-1].equals("X")  || ticTacBoard[player1_move-1].equals("O")){
                    System.out.print("It is already taken! Choose another option : ");
                    player1_move = in.nextInt();
                    System.out.println();

                }
                game.updateBoard(ticTacBoard,player1_move,player1_symbol);
                game.displayBoard(ticTacBoard);
                if(i >= 2)
                {
                    boolean checkForWin = checkBoard(ticTacBoard);
                    if (checkForWin) {
                        System.out.println("\nCongratulation! " + player1_name + " Wins.");
                        return "player1";
                    }
                }

            }
            else{
                System.out.print(player2_name+"'s turn : ");
                System.out.println();
                player2_move = in.nextInt();
                while(!(player2_move>=1 && player2_move<=9)){
                    System.out.println("Oops! Out of Range.\nEnter your choice between 1-9");
                    player2_move = in.nextInt();
                    System.out.println();
                }
                while(ticTacBoard[player2_move-1].equals("X")  || ticTacBoard[player2_move-1].equals("O")){
                    System.out.print("It is already taken! Choose another option : ");
                    player2_move = in.nextInt();
                    System.out.println();

                }
                game.updateBoard(ticTacBoard,player2_move,player2_symbol);
                game.displayBoard(ticTacBoard);
                if(i >= 2)
                {
                    boolean checkForWin = checkBoard(ticTacBoard);
                    if (checkForWin) {
                        System.out.println("\nCongratulation! " + player2_name + " Wins.");
                        return "player2";
                    }
                }
            }
            System.out.println();

        }
        System.out.println("Its a Draw!");
        return "draw";
    }
}
