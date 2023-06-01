import java.util.InputMismatchException;
import java.util.Scanner;

public class Beck {
    public static void main(String[] args){
        Scanner tec = new Scanner(System.in);

        while (true){
            double speedA = -1, speedB = 1, positionA = -1, positionB = 1, time, position;
            int initialHour, hour, minutes, seconds;

            while (true){
                try {
                    while (positionA < 0 || positionA > 10000){
                        System.out.print("Input A's position (0 - 10000 Km)>> ");
                        positionA = tec.nextDouble();

                        if (positionA < 0 || positionA > 10000){
                            System.out.println("A's positions needs to be between 0 - 10000");
                            System.out.println("Please try again.");
                        }
                    }
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Invalid character. Try again");
                    System.out.println();
                }
                tec.nextLine();
            }

            System.out.println();

            while (true){
                try {
                    while (positionB > 0 || positionB < -10000){
                        System.out.print("Input B's position (0 - -10000 Km)>> ");
                        positionB = tec.nextDouble();

                        if (positionB > 0 || positionB < -10000){
                            System.out.println("B's positions needs to be between 0 - 10000");
                            System.out.println("Please try again.");
                        }
                    }
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Invalid character. Try again");
                    System.out.println();
                }
                tec.nextLine();
            }

            System.out.println();

            while (true){
                try {
                    while (speedA < 0 || speedA > 300){
                        System.out.print("Input A's speed (0 - 300 Km/h)>> ");
                        speedA = tec.nextDouble();

                        if (speedA < 0 || speedA > 300){
                            System.out.println("A's speed needs to be between 0 - 300");
                            System.out.println("Please try again.");
                        }
                    }
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Invalid character. Try again");
                    System.out.println();
                }
                tec.nextLine();
            }

            System.out.println();

            while (true){
                try {
                    while (speedB > 0 || speedB < -300){
                        System.out.print("Input B's speed (0 - 300 Km/h)>> ");
                        speedB = tec.nextDouble();

                        if (speedB > 0 || speedB < -300){
                            System.out.println("B's speed needs to be between 0 - -300");
                            System.out.println("Please try again.");
                        }
                    }
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Invalid character. Try again");
                    System.out.println();
                }
                tec.nextLine();
            }

            time = ((positionA - positionB) / (speedB - speedA));

            int timeSeconds = (int) (time *3600);

            position = positionA + (speedA * time);

            hour = 17; minutes = 0;

            if (time % 60 == 0){
                hour += ((int) time);
            }else {
                hour += ((int) time);
                minutes += timeSeconds / 60;
            }
            
            System.out.println();
            System.out.printf("The train collision will happen in position %.2f and after %d seconds at %d:%d:00", position, timeSeconds, hour, minutes);
            System.out.println();
            try {
                System.out.print("Wanna break? [0]>> ");
                int resp = tec.nextInt();
                if (resp == 0){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid character. Try again");
            }
            tec.nextLine();
            System.out.println();
        }
    }
}