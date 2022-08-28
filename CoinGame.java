/*
This code produces the winner and total possible optimally-played scenarios for the popular Coin Game. This variation
has the following rules:
    1. There is a specified amount of coins at the start of the game, inputted by the user.
    2. On each turn, a player, starting with Player 1, must take away exactly 1, 2, or 4 coins.
    3. The two players will continue taking turns until there are no longer any coins left.
    4. The player to pick the last coin WINS.
 */

import java.util.Scanner;

public class CoinGame {

    public static int count = 0; //total best-played scenarios

    public static void main (String [] args) {
        //obtaining players' names
        Scanner console = new Scanner(System.in);
        System.out.print("Enter player 1's name: ");
        String name1 = console.next();

        System.out.print("Enter player 2's name: ");
        String name2 = console.next();

        //obtaining total coins
        System.out.print("Enter how many coins this game starts with: ");
        int coins = console.nextInt();
        System.out.println();

        //function to find the number of perfectly-played scenarios
        perfectGames(coins);
        System.out.println("There are " + count + " possible perfect games.");

        System.out.print("The winner is: ");
        if (coins % 3 != 0) {
            System.out.println(name1);
        } else {
            System.out.println(name2);
        } //If the starting coin count is divisible by 3, Player 2 will win. Otherwise, the winner will be Player 1.


    }

    public static void perfectGames (int coins) {
        /*
        This method finds the number of scenarios where a player can win with optimal play on both sides.

        @param coins This represents the number of coins present before each person makes their turn
         */
        if (coins == 0) {
            count++;
        } else {
            if ((coins - 1) % 3 == 0) {
                /*
                When there is one greater than a multiple of 3 coins, a player can remove 1 or 4 coins, leaving
                their opponent with a multiple of 3 coins.
                 */
                perfectGames(coins - 1);
                perfectGames(coins - 4);
            } else if ((coins - 2) % 3 == 0) {
                /*
                When there are two greater than a multiple of 3 coins, a player must remove 2 coins to
                leave their opponent with a multiple of 3 coins.
                 */
                perfectGames(coins - 2);
            } else {
                /*
                If a player is given a coin count which is a multiple of 3, the player has already lost regardless
                of how many coins they take away. As a result, any option is still considered optimal play as
                they will all end in a loss.
                 */
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
    /* A good start to tackling this problem is a classic strategy: using smaller numbers. With a single coin, Player 1
    wins by taking the coin. Similarly, Player 1 wins with 2 coins. However, when there are 3 coins, Player 2 wins
    regardless of how many Player 1 takes. Player 1 wins when there are 4 coins because they can simply take all of
    them. From a logical perspective, whenever there are 1, 2, or 4 coins, the player selecting first wins.
    With 3 coins present, the second player to pick wins. Essentially, the goal of any player is to leave the other
    player with exactly 3 coins. Therefore, if there are 4, 5, or 7 coins available, Player 1 can force Player 2 to
    have exactly 3 coins, guaranteeing their victory. When there are 6 however, Player 1 always loses because they
    will leave Player 2 with 5, 4, or 2 coins, all resulting in a loss. Thus, the first player to take coins when
    there are 6 coins will automatically lose. This pattern continues onwards with both players committing to the
    same winning strategy: force the opponent to have a multiple of 3 coins on their turn.

     */
}
