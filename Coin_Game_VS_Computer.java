import java.util.Scanner;

public class Coin_Game_VS_Computer {

    public static int coins;

    public static void main (String [] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("""
                Welcome to Coin Game against me! The rules are as follows:
                    1. There is a specified amount of coins at the start of the game, chosen by you!
                    2. On each turn, a player, starting with you, must take away exactly 1, 2, or 4 coins.
                    3. We will continue taking turns until there are no longer any coins left.
                    4. The player to pick the last coin WINS.""");

        System.out.print("Enter how many coins this game starts with: ");
        coins = console.nextInt();
        System.out.println();

        System.out.println("Let's start!");
        while (coins > 0) {
            System.out.println("The pile currently contains " + coins + " coins. How many coins would you like to remove?");
            int remove = console.nextInt();
            while (!validRemoval(remove)) {
                System.out.println("Your chosen value is invalid. Please choose a different amount of coins to remove.");
                remove = console.nextInt();
            }

            coins -= remove;
            if (coins == 0) {
                System.out.println("You win!");
                System.exit(0);
            }

            computers_turn();
            if (coins == 0) {
                System.out.println("The computer has taken the last coin. You lost.");
            }
        }
        System.out.println();
    }

    public static boolean validRemoval(int number) {
        if (number > coins) {
            return false;
        }
        return number == 1 || number == 2 || number == 4;
    }

    public static void computers_turn() {
        if (coins % 3 == 0) {
            double random = Math.random() * 3;
            if (random > 2 && validRemoval(4)) {
                coins -= 4;
                System.out.println("The computer has taken 4 coins.");
            } else if (random > 1 && validRemoval(2)) {
                coins -= 2;
                System.out.println("The computer has taken 2 coins.");
            } else {
                coins--;
                System.out.println("The computer has taken 1 coin.");
            }
        } else if (coins % 3 == 1) {
            double random = Math.random() * 2;
            if (random > 1 && validRemoval(4)) {
                coins -= 4;
                System.out.println("The computer has taken 4 coins.");
            } else {
                coins--;
                System.out.println("The computer has taken 1 coin.");
            }
        } else {
            coins -= 2;
            System.out.println("The computer has taken 2 coins.");
        }
    }
}
