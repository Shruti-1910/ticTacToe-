import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TicTacToe {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] ticTacBoard = {" "," "," "," "," "," "," "," "," "};
        boolean play = true;
        String player1_name = "", player2_name = "";
        game.rules(ticTacBoard);
        System.out.print("Enter the name of Player1 : ");
        player1_name = in.nextLine();
        System.out.print("Enter the name of Player2 : ");
        player2_name = in.nextLine();

        int player1_symbol = 0, player2_symbol = 0;

        System.out.println("");

        // Assign Symbols
        System.out.println("\n"+"1. Choose your symbols OR \n2. Assign Symbols Randomly : ");
        int choice = in.nextInt();
        if(choice == 1){
            System.out.print(player1_name+"'s choice : ");
            player1_symbol = in.nextInt();
            while(player1_symbol != 1 && player1_symbol !=2){
                System.out.println("Wrong Choice. Try Again.");
                player1_symbol = in.nextInt();
            }
        }
        else if (choice == 2){
            Random rand = new Random();
            player1_symbol = rand.nextInt(2);
        }
        else{
            while(choice != 1 && choice !=2){
                System.out.println("Wrong Choice. Try Again.");
                choice = in.nextInt();
            }
        }
        if(player1_symbol == 1) {
            player2_symbol = 2;
            System.out.println(player1_name+"'s Symbol : X\n"+player2_name+"'s Symbol : O");
        }
        else {
            player2_symbol = 1;
            System.out.println(player1_name+"'s Symbol : O\n"+player2_name+"'s Symbol : X");
        }


        int player1_wins = 0, player2_wins = 0;
        while(play){

            String win = game.playGame(ticTacBoard, player1_name, player2_name, player1_symbol, player2_symbol);
            if(win.equals("player1"))
                player1_wins++;
            else if(win.equals("player2"))
                player2_wins++;
            System.out.println("Play Again? (y/n) : ");
            String Choice = in.next();
            if(Choice.equals("n") || Choice.equals("N")) {
                if(player1_wins>player2_wins)
                    System.out.println(player1_name+" Wins");
                else if(player1_wins<player2_wins)
                    System.out.println(player2_name+" Wins");
                else
                    System.out.println("Its a Draw!");
                play = false;
            }
            else if (Choice.equals("y") || Choice.equals("Y")) {
                ticTacBoard = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
                play = true;
            }
            else {
                while(!Choice.equals("n") && !Choice.equals("N") && !Choice.equals("y") && !Choice.equals("Y")){
                    System.out.println("Wrong Choice");
                    Choice = in.next();

                }


            }

        }
    }
}