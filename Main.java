package me.kiteab;

import java.util.Scanner;

public class Main {

  static int genRandomNum (int min, int max) {
    return (int) (min + Math.random() * (max - min + min));
  }

  public static void main (String[] args) {
    final String errExitMsg = """
              Usage: java -jar GuessNumber.jar <minValue> <maxValue>
              <minValue> must less than <maxValue>, arguments must bigger than -1""";
    final int exitCode = 114;
    /* Argument detect */
    if (args.length != 2) {
      System.out.println(errExitMsg);
      System.exit(exitCode);
    }

    int[] numRange = {Integer.parseInt(args[0]), Integer.parseInt(args[1])};
    if (numRange[0] > numRange[1] | numRange[0] < 0 | numRange[1] < 0) {
      System.out.println(errExitMsg);
      System.exit(exitCode);
    }

    System.out.println("Welcome to the GuessNumber game!\n");
    int randomNum = genRandomNum(numRange[0], numRange[1]);
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("Please input a number that you guess: ");
      int userInput = sc.nextInt();
      if (userInput > randomNum) {
        System.out.println("Guess is more than the number. Try again!\n");
        continue;
      } else if (userInput < randomNum) {
        System.out.println("Guess is less than the number. Try again!\n");
        continue;
      } else {
        System.out.println("Correct, Congratulation!");
        break;
      }
    }
  }
}
