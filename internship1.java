import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class NumberGame {
    int Computer;

    public NumberGame() {
        Random random = new Random();
        Computer = random.nextInt(100);
        System.out.println("Guess the number between 1 to 100: ");
        System.out.println("Rule 1: You have only 20 attempts to guess the number");
        System.out.println(
                "Rule 2: Guess it within 5 attempts you are a pro, guess it within 10 attempts you are a mediocre player, if you took more than 10 attempts you are a noob player");
        System.out.println("Let's Start");
    }

    public int ComputerNo() {
        return Computer;
    }
}

public class internship1 {
    static int TakeUserInput() {
        int user;
        System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        user = sc.nextInt();
        return user;
    }

    static void isCorrectNumber(int a, int b) {
        if (a == b) {
            System.out.println("Congratulations");
        } else if (a > b) {
            System.out.println("Oops! Your number is greater than the computer's number");
        } else {
            System.out.println("Oops! Your number is smaller than the computer's Number");
        }
    }

    public static void main(String args[]) {

        List<Integer> scores = new ArrayList<>();

        boolean playAgain = true;
        Scanner playAgainScanner = new Scanner(System.in);

        while (playAgain) {
            NumberGame g = new NumberGame();

            int attempts = 0, user = 0, computer = 0;

            do {
                user = TakeUserInput();
                computer = g.ComputerNo();
                isCorrectNumber(user, computer);
                attempts++;
            } while (user != computer && attempts <= 20);

            System.out.println("You have guessed the correct number in " + attempts + " attempts.");
            if (attempts <= 5) {
                System.out.println("You are a pro player!");
            } else if (attempts > 5 && attempts < 10) {
                System.out.println("You are a mediocre player");
            } else {
                System.out.println("You are a noob");
            }

            scores.add(attempts);
            System.out.println("Previous Round Scores:");
            for (int i = 0; i < scores.size(); i++) {
                System.out.println("Round " + (i + 1) + ": " + scores.get(i) + " attempts");
            }

            playAgainScanner.nextLine();
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainInput = playAgainScanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
            System.out.println("thanks for playing");

        }

    }
}