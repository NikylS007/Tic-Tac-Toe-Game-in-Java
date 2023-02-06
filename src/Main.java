import java.util.Scanner;

class test {
    static char XorO = ' ';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res;
        String str = "Play Game";
        while(true) {
            System.out.println("\n1) "+str+"\n2) Exit\n");
            res = sc.nextInt();
            while (res != 1 && res != 2) {
                System.out.print("\nError!!!");
                System.out.println("\n1) "+str+"\n2) Exit\n");
                res = sc.nextInt();
            }
            str = "Play Again";
            if (res == 2) {
                System.out.println("             Welcome Again !!!           ");
                break;
            } else {
                System.out.println();
                Game();
            }
        }
    }


    private static void Game() {
        System.out.println("""
                This game is played on a grid that's 3 squares by 3 squares.
                You are X, your friend is O. Players take turns putting their marks in empty squares.
                The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.
                When all 9 squares are full, the game is over.""");
        System.out.println("\n");
        System.out.println(" 1 : 2 : 3 ");
        System.out.println("...........");
        System.out.println(" 4 : 5 : 6 ");
        System.out.println("...........");
        System.out.println(" 7 : 8 : 9 ");
        Scanner sc = new Scanner(System.in);
        int[]  arr = new int[]{0,0,0,0,0,0,0,0,0};
        char[] ch = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
        System.out.println("\nThis is the format of the grid,by giving the number(1 - 9),X And O will be put in that place.");
        System.out.println("\nGame Starts Now ! ");
        for(int i=0;i<9;i++) {
            System.out.print("\nEnter the number[1-9] : ");
            int put = sc.nextInt();
            while(put>9 || put<1)
            {
                System.out.print("\nError!!!");
                System.out.print("\nEnter the number[1-9] : ");
                put = sc.nextInt();
            }
            while(arr[put-1]!=0)
            {
                System.out.print("\nError!!! Index "+put+" is already filled, Kindly give the empty grid index");
                System.out.print("\nEnter the number[1-9] : ");
                put = sc.nextInt();
                while(put>9 || put<1)
                {
                    System.out.print("\nError!!!");
                    System.out.print("\nEnter the number[1-9] : ");
                    put = sc.nextInt();
                }
            }
            if(i%2==0)
            {
                arr[put-1] = 1;
                ch[put-1] = 'X';
            }
            else
            {
                arr[put-1] = 11;
                ch[put-1] = 'O';
            }
            XOGamePass(ch);
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

    private static boolean check(char[] ch) {
        if((ch[0] == ch[4] && ch[4] == ch[8]) || (ch[2] == ch[4] && ch[4] == ch[6]))
        {
            XorO = ch[0];
            return true;
        }
        for(int x=0;x<7;x=x+3) {
            if (ch[x] == ch[x + 1] && ch[x + 1] == ch[x + 2] && ch[x]!=' ') {
                XorO = ch[x];
                return true;
            }
        }
        for(int x=0;x<3;x++) {
            if (ch[x] == ch[x + 3] && ch[x + 3] == ch[x + 6] && ch[x]!=' ') {
                XorO = ch[x];
                return true;
            }
        }
        return false;
    }

    private static void XOGamePass(char[] ch) {
        System.out.println();
        System.out.println(" " +ch[0]+" . "+ch[1]+" . "+ch[2]);
        System.out.println(".  .   .   . ");
        System.out.println(" " +ch[3]+" . "+ch[4]+" . "+ch[5]);
        System.out.println(".  .   .   . ");
        System.out.println(" " +ch[6]+" . "+ch[7]+" . "+ch[8]);
    }
}