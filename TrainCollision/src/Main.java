import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static double testNegative(Scanner scanner) {
        double value = scanner.nextDouble();
        if (value < 0) {
            throw new InputMismatchException();
        }
        return value;
    }

    public static double testSpeed(double speed) {
        if (speed > 300 || speed <= 0) {
            throw new InputMismatchException("Speed value needs to be between 0 - 300 km/h");
        }
        return speed;
    }

    public static double testPosition(double position) {
        if (position > 300 || position < 0) {
            throw new InputMismatchException("Position value needs to be between 0 - 10.000 km");
        }
        return position;
    }

    public static void main(String[] args) {
        while (true) {
            // Declaring variables
            double posA = 0.0, posB = 0.0, speedA = 0.0, speedB = 0.0, timeHour = 0.0;
            int timeSecond, exHour, exMinute;

            // Getting user input and testing it
            boolean posWrong = true, speedWrong = true;

            // Testing position
            while (posWrong) {
                try {
                    System.out.print("Position A (0 - 10.000 km): ");
                    posA = testNegative(scanner);
                    testPosition(posA);

                    System.out.print("Position B (0 - 10.000 km): ");
                    posB = testNegative(scanner);
                    testPosition(posB);
                } catch (java.util.InputMismatchException e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                    continue;
                }
                posWrong = false;
            }
            // Testing speed
            while (speedWrong) {
                try {
                    System.out.print("Speed A (0 - 300 km/h): ");
                    speedA = testNegative(scanner);
                    testSpeed(speedA);

                    System.out.print("Speed B (0 - 300 km/h): ");
                    speedB = testNegative(scanner);
                    testSpeed(speedB);
                    speedWrong = false;
                } catch (java.util.InputMismatchException e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                    scanner.nextLine();
                    continue;
                }
                speedWrong = false;
            }

            // Example values
            exHour = 17;
            exMinute = 0;

            // ΔT = ΔS/Vm
            timeHour = (posA - posB) / (speedA + speedB);
            if (timeHour < 0) {
                timeHour *= -1;
            }
            System.out.println(timeHour);
            timeSecond = (int) (timeHour * 3600);

            // S = S0 + v . t
            speedA = posA > posB ? (speedA * -1) : (speedA);
            double S = posA + speedA * timeHour;
            System.out.println(S); // ok

            exHour += (int) (timeHour);

            if (timeHour % 60 != 0) {
                exMinute += timeSecond / 60;
                while (exMinute >= 60) {
                    exHour++;
                    exMinute -= 60;
                }
            }

            LocalTime time = LocalTime.of(exHour, exMinute, 0);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
            String timeFormated = time.format(format);

            System.out.println(" \n\n--- ANSWER --- \n");
            System.out.println("The trains collision will happen in the kilometer " + S + ", after " + timeSecond
                    + " seconds, at " + timeFormated);

            
            System.out.println();
            System.out.println("Do you want do repeat the program?\n[Y]es [N]o");
            String quit = scanner.next().toLowerCase();
            if (quit == "y") break;
        }

        System.out.println("PROGRAM END");

        // Na situação expecifica q os trens não colidem AVISAR

        scanner.close();
    }
}