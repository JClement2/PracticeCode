
/**
 * Birthday Paradox Simulator
 *
 * Written and compiled by Jonathan Clement on 8/22/2023
 * 
 * This Java program simulates the birthday paradox by conducting a series of
 * experiments.
 * The birthday paradox states that the probability of two people sharing a
 * birthday is higher than expected,
 * especially as the number of people in a room increases. The program performs
 * experiments for different numbers
 * of people in a room (n = 5, 10, 15, ..., up to 100) and calculates the
 * probability of at least two people having
 * the same birthday.
 *
 * How It Works:
 * 1. The program runs a specified number of experiments (numExperiments) for
 * each n value (number of people in the room).
 * 2. For each experiment, it generates n random birthdays (represented as
 * integers from 0 to 364) and checks if there's a shared birthday.
 * 3. If a shared birthday is found, the experiment is marked as a success.
 * 4. After all experiments for a specific n value are completed, the program
 * calculates the probability of shared birthdays
 * as the ratio of successful experiments to total experiments and prints the
 * result.
 *
 * Components:
 * - {@code main} method: Controls the flow of the program, runs experiments for
 * different n values, and calculates probabilities.
 * - {@code hasSharedBirthday} method: Generates random birthdays for n people
 * and checks if there's a shared birthday.
 * - {@code numExperiments}: The number of experiments to run for each n value.
 * - {@code maxPeople}: The maximum number of people to consider in the
 * experiments.
 *
 * Usage:
 * 1. Compile the program using a Java compiler.
 * 2. Run the compiled program.
 * 3. Observe how the probability of shared birthdays increases as the number of
 * people in the room (n) increases.
 *
 * Note:
 * - The actual probability will be close to the theoretical value, but due to
 * the random nature of the experiments,
 * slight variations in results may occur.
 */
import java.util.Random;

public class BirthdayParadox {

    private static final int numExperiments = 100000;
    private static final int maxPeople = 100;

    public static void main(String[] args) {
        for (int n = 5; n <= maxPeople; n += 5) {
            int countSuccess = 0;

            for (int experiment = 0; experiment < numExperiments; experiment++) {
                if (hasSharedBirthday(n)) {
                    countSuccess++;
                }
            }

            double probability = (double) countSuccess / numExperiments;
            System.out.println("For " + n + " people, probability of shared birthday: " + probability);
        }
    }

    /**
     * Checks if there is a shared birthday among a group of people.
     *
     * @param n The number of people in the group.
     * @return {@code true} if there is a shared birthday, {@code false} otherwise.
     */
    private static boolean hasSharedBirthday(int n) {
        Random random = new Random();
        boolean[] birthdays = new boolean[365]; // Representing each day of the year

        for (int person = 0; person < n; person++) {
            int birthday = random.nextInt(365); // Assign a random birthday (0 to 364)

            if (birthdays[birthday]) {
                return true; // Found a shared birthday
            }

            birthdays[birthday] = true;
        }

        return false; // No shared birthdays
    }
}