package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scientific_Calculator {

    private static final Logger logger = LogManager.getLogger(Scientific_Calculator.class);
    public Scientific_Calculator() {
    }

    public static void main(String[] args) {

        Scientific_Calculator calculator = new Scientific_Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do {
            System.out.println("Scientific Calculator. \n Select operation:");
            System.out.print("1. Factorial\n2. Square root\n3. Power\n4. Logarithm base e\n" +
                    "5. Exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                scanner.close();
                return;
            }

            switch (choice) {
                case 1:
                    logger.info("Selected Choice: Factorial");
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Factorial of "+number1+" is : " + calculator.factorial(number1));
                    System.out.println("\n");
                    break;

                case 2:
                    logger.info("Selected Choice: Sqcaure Root");
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Square root of "+number1+" is : " + calculator.squareRoot(number1));
                    System.out.println("\n");
                    break;

                case 3:
                    logger.info("Selected Choice: Power");
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println(number1+ " raised to power "+number2+" is : " + calculator.power(number1, number2));
                    System.out.println("\n");
                    break;

                case 4:
                    logger.info("Selected Choice: Log base e");
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Natural log of "+number1+" is : " + calculator.naturalLog(number1));
                    System.out.println("\n");
                    break;

                default:
                    logger.info("Selected Choice: Exit");
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
            }
        } while (true);
    }


    public double factorial(double number) {
        logger.info("Input - " + number);
        double result = 1;
        for(int i = 1; i <= number; ++i){ result *= i;   }
        logger.info("Factorial of " + number + " is: "+ result);
        return result;
    }



    public double squareRoot(double number) {
        logger.info("Input - " + number);
        double result = Math.sqrt(number);
        logger.info("Sqaure Root of " + number + " is: "+ result);
        return result;
    }


    public double power(double number1, double number2) {
        logger.info("Input - " + number1 + "," + number2);
        double result = Math.pow(number1,number2);
        logger.info(number1 + " to the power "+number2+ " is: " + result);
        return result;
    }

    public double naturalLog(double number) {
        logger.info("Input - " + number);
        double result = 0;

        if (number <0 ) {
            result = Double.NaN;
            System.out.println("Error: Cannot find log of negative numbers ");
            logger.warn("Cannot find log of negative numbers");
        }
        else {
            result = Math.log(number);
            logger.info("Log base e of " +number+" is: "+ result);
        }
        return result;
    }
}
