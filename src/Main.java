import java.util.Scanner;

// Main class to play the X and O game
class Main {
    // class variable to keep track of the current player, X or O
    static char XorO = ' ';

    public static void main(String[] args) {
        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);
        int res;
        // String variable to display the options to the user
        String str = "Play Game";

        // loop to keep the game running until the user decides to exit
        while(true) {
            // displaying the options to the user, either play the game or exit
            System.out.println("\n1) "+str+"\n2) Exit\n");
            res = sc.nextInt();
            // loop to handle the invalid inputs
            while (res != 1 && res != 2) {
                System.out.print("\nError!!!");
                System.out.println("\n1) "+str+"\n2) Exit\n");
                res = sc.nextInt();
            }
            str = "Play Again";
            // if the user wants to exit, break the loop
            if (res == 2) {
                System.out.println("             Welcome Again !!!           ");
                break;
            }
            // if the user wants to play the game, call the Game method
            else {
                System.out.println();
                Game();
            }
        }
    }


    // This method implements the tic-tac-toe game logic.
    private static void Game() {
        // Prints game introduction and grid format
        System.out.println("This game is played on a grid that's 3 squares by 3 squares." +
                "You are X, your friend is O. Players take turns putting their marks in empty squares." +
                "The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner." +
                "When all 9 squares are full, the game is over.");
        System.out.println();
        System.out.println(" 1 : 2 : 3 ");
        System.out.println("...........");
        System.out.println(" 4 : 5 : 6 ");
        System.out.println("...........");
        System.out.println(" 7 : 8 : 9 ");

        // Initialize a scanner for user input
        Scanner sc = new Scanner(System.in);

        // Initialize the grid state arrays
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0};
        char[] ch = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};

        // Prints game instructions
        System.out.println("This is the format of the grid, by giving the number(1 - 9), X And O will be put in that place.");
        System.out.println("Game Starts Now!");

        // Loop for 9 turns of the game
        for (int i = 0; i < 9; i++) {
            // Ask the user for the grid index to place the mark
            System.out.print("Enter the number[1-9]: ");
            int put = sc.nextInt();

            // Check if the input is within the grid range
            while (put > 9 || put < 1) {
                System.out.println("Error!!!");
                System.out.print("Enter the number[1-9]: ");
                put = sc.nextInt();
            }

            // Check if the grid index has already been filled
            while (arr[put-1] != 0) {
                System.out.println("Error!!! Index " + put + " is already filled, Kindly give the empty grid index");
                System.out.print("Enter the number[1-9]: ");
                put = sc.nextInt();

                // Check if the input is within the grid range
                while (put > 9 || put < 1) {
                    System.out.println("Error!!!");
                    System.out.print("Enter the number[1-9]: ");
                    put = sc.nextInt();
                }
            }

            // Place the X or O mark on the grid
            if (i % 2 == 0) {
                arr[put-1] = 1;
                ch[put-1] = 'X';
            } else {
                arr[put-1] = 11;
                ch[put-1] = 'O';
            }

            // Print the updated grid
            XOGamePass(ch);

            // Check for a win after 5 turns
            if(i>3)
            {
                if(check(ch))
                {
                    System.out.println("Hooray!!! "+XorO+" is the Winner...");
                    break;
                }
            }

        }
        System.out.println("\nGame Draw");
    }

    // This function checks if there is a winner in the game, by checking if any of the winning conditions are met
    private static boolean check(char[] ch) {
        // Check for diagonal win
        if((ch[0] == ch[4] && ch[4] == ch[8]) || (ch[2] == ch[4] && ch[4] == ch[6]))
        {
            XorO = ch[0];
            return true;
        }
        // Check for horizontal win
        for(int x=0;x<7;x=x+3) {
            if (ch[x] == ch[x + 1] && ch[x + 1] == ch[x + 2] && ch[x]!=' ') {
                XorO = ch[x];
                return true;
            }
        }
        // Check for vertical win
        for(int x=0;x<3;x++) {
            if (ch[x] == ch[x + 3] && ch[x + 3] == ch[x + 6] && ch[x]!=' ') {
                XorO = ch[x];
                return true;
            }
        }
        return false;
    }

    // This function prints the current status of the tic-tac-toe game grid
    private static void XOGamePass(char[] ch) {
        System.out.println();
        System.out.println(" " +ch[0]+" . "+ch[1]+" . "+ch[2]);
        System.out.println(".  .   .   . ");
        System.out.println(" " +ch[3]+" . "+ch[4]+" . "+ch[5]);
        System.out.println(".  .   .   . ");
        System.out.println(" " +ch[6]+" . "+ch[7]+" . "+ch[8]);
    }
}