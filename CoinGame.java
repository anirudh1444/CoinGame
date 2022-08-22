import java.util.Scanner;

public class CoinGame {

    public static int count = 0;

    public static void main (String [] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter player 1's name: ");
        String name1 = console.next();

        System.out.print("Enter player 2's name: ");
        String name2 = console.next();

        System.out.print("Enter how many coins this game starts with: ");
        int coins = console.nextInt();
        System.out.println();

        perfectGames(coins);
        System.out.println("There are " + count + " possible perfect games.");

        System.out.print("The winner is: ");
        if (coins % 3 != 0) {
            System.out.println(name1);
        } else {
            System.out.println(name2);
        }


    }

    public static void perfectGames (int coins) {
        if (coins == 0) {
            count++;
        } else {
            if ((coins - 1) % 3 == 0) {
                perfectGames(coins - 1);
                perfectGames(coins - 4);
            } else if ((coins - 2) % 3 == 0) {
                perfectGames(coins - 2);
            } else {
                if (coins >= 1) {
                    perfectGames(coins - 1);
                }
                if (coins >= 2) {
                    perfectGames(coins - 2);
                }
                if (coins >= 4) {
                    perfectGames(coins - 4);
                }
            }
        }
    }
}
