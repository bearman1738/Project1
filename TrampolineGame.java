import java.util.Scanner;
import java.util.Random;

public class TrampolineGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Death Trampoline!");
        System.out.println("You are about to jump on death. Try to perform tricks and gain points!");
        System.out.println("Be careful, if you jump too many times, you might fall (and die)!");
        System.out.println(" ");
        int totalScore = 0;
        int jumps = 0;
        boolean gameOver = false;
        int doubleJumpChances = 3;

        while (!gameOver) {
            System.out.println("Choose your next move:");
            System.out.println("1. Regular Jump (Low risk - 10 points)");
            System.out.println("2. Backflip (Medium risk - 20 points)");
            System.out.println("3. Frontflip (Medium risk - 15 points)");
            System.out.println("4. Double Jump (High risk - 100 points, Cost: 50 points) - Chances remaining: " + doubleJumpChances);
            System.out.println("5. Cry to your mummi");

            int choice = scanner.nextInt();
            jumps++;

            if (choice == 5) {
                gameOver = true;
            } else {
                int score = 0;
                int chanceOfFall = 0;

                switch (choice) {
                    case 1:
                        score = 10;
                        chanceOfFall = 20; // Low risk
                        break;
                    case 2:
                        score = 20;
                        chanceOfFall = 40; // Medium risk
                        break;
                    case 3:
                        score = 15;
                        chanceOfFall = 35; // Medium risk
                        break;
                    case 4:
                        if (totalScore >= 50 && doubleJumpChances > 0) {
                            score = 100;
                            totalScore -= 50;
                            doubleJumpChances--;
                            chanceOfFall = 60; // High risk
                        } else {
                            System.out.println("Not enough points or no more double jump chances!");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                        continue;
                }

                System.out.println("You scored " + score + " points!");

                
                int fallChance = random.nextInt(100);
                if (fallChance < chanceOfFall) {
                    gameOver = true;
                    System.out.println("Oh no! You fell off the trampoline!");
                } else {
                    totalScore += score;
                    System.out.println("Total points: " + totalScore);

                    if (jumps >= 10) {
                        int chanceOfFallAfter10Jumps = random.nextInt(100);
                        if (chanceOfFallAfter10Jumps < 30) { // 30% chance of falling if more than 10 jumps
                            gameOver = true;
                            System.out.println("Oh no! You jumped too many times and died! Oh well!");
                        }
                    }
                }
            }
        }

        System.out.println("Game over! Your total score is: " + totalScore);
        scanner.close();
    }
}
