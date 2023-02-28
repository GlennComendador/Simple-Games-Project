import java.util.Random;
import java.util.Scanner;

public class SimpleRocksPapersScissors {

    private static final int MAX_NUMBERS = 3;
    public static void main(String[] args) {

        //VARIABLE INITIALIZATION
        int user_choice;
        int systemNumber;
        int quit = 0;

        //SCANNER INITIALIZATION
        Scanner user_input = new Scanner(System.in);

        do {

            System.out.println("1. Rocks \n2. Papers \n3. Scissors \n4. Quit");
            user_choice = user_input.nextInt();

            Random randomNumbers = new Random();
            systemNumber = randomNumbers.nextInt(MAX_NUMBERS) + 1;
            System.out.println(systemNumber);
            
            switch (user_choice) {
                case 1 -> {
                    if (systemNumber == 1) {

                        System.out.println("Tie");
                    } else if (systemNumber == 2) {
                        System.out.println("Lose");
                    } else if (systemNumber == 3) {
                        System.out.println("Win");
                    }
                }
                case 2 -> {
                    if (systemNumber == 2) {
                        System.out.println("Tie");
                    } else if (systemNumber == 3) {
                        System.out.println("Lose");
                    } else if (systemNumber == 1) {
                        System.out.println("Win");
                    }
                }
                case 3 -> {
                    if (systemNumber == 3) {
                        System.out.println("Tie");
                    } else if (systemNumber == 1) {
                        System.out.println("Lose");
                    } else if (systemNumber == 2) {
                        System.out.println("Win");
                    }
                }
                case 4 -> quit = 1;

                default -> System.out.println("1 to 3 Only");
            }

        } while (quit != 1);

    }
}
