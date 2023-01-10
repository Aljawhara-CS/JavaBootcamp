import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // author by Aljawhara

        Scanner obj = new Scanner(System.in);
        int Entered_num1 = 0;
        int sum_even = 0;
        int sum_odd = 0;
        int count_pos = 0;
        int count_neg = 0;
        int count_zeros = 0;
        int power = 1;
        int Entered_num2 = 0;
        int  count = 0;

        String input = "The quick brown fox";
        String output = "";
        String Space = "";


        System.out.println("1.Write a program that prints the numbers from 1 to 100 such that:\n" +
                "If the number is a multiple of 3, you need to print \"Fizz\" instead of that number.\n" +
                "If the number is a multiple of 5, you need to print \"Buzz\" instead of that number.\n" +
                "If the number is a multiple of both 3 and 5, you need to print \"FizzBuzz\" instead of that number.");

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else if ((i % 3 == 0) && (i % 5 == 0))
                System.out.println("FizzBuzz");
        }

        System.out.println("-------------------------------");


        System.out.println(" 2.Write a Java program to reverse a string.\n" +
                "Test Data: Input a string: The quick brown fox Expected Output: Reverse string: xof nworb kciuq ehT");

        for (int i = input.length() - 1; i > 0; i--) {
            output = output + input.charAt(i);
        }
        System.out.println(" the output is:" + output);


        System.out.println("-------------------------------");
        System.out.println("3.Write a program that prompts the user to input a positive integer. It should then print the multiplication table of that number.\n");

        System.out.println("Kindly, Enter number:");
        Entered_num1 = obj.nextInt();

        if (Entered_num1 > 0) {
            System.out.println("******" + Entered_num1 + "******");

            for (int i = 1; i <= 10; i++) {
                int result = Entered_num1 * i;

                System.out.println("" + Entered_num1 + "*" + i + "=" + result);

            }
        } else System.out.println("Kindly, Try again  you have to Enter Positive Number!");

        System.out.println("------------------------------- ");
        System.out.println("4.Write a program to find the factorial value of any number entered through the keyboard.\n ");

        System.out.println("Kindly, Enter number:");
        Entered_num1 = obj.nextInt();

        int fact = 1;
        for (int i = 1; i <= Entered_num1; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + Entered_num1 + " is: " + fact);


        System.out.println("-------------------------------");
        System.out.println("5.Two numbers are entered through the keyboard. Write a program to find the value of one number raised to the power of another. (Do not use Java built-in method)");

        System.out.println("Kindly, Enter  First number :");
        Entered_num1 = obj.nextInt();

        System.out.println("Kindly, Enter power number :");
        Entered_num2 = obj.nextInt();

        if (Entered_num2 >= 1) {
            for (int i = 1; i <= Entered_num2; i++) {

                power = power * Entered_num1;

            }

            System.out.println("The output:"+ power);

        }



        System.out.println("-------------------------------");
        System.out.println("6.Write a program that reads a set of integers, and then prints the sum of the even and odd integers");


        for (int i = 0; i >= 0; i++) {

            System.out.println("Kindly, Enter number that is not negative:");
            Entered_num1 = obj.nextInt();

            if (Entered_num1 > 0) {
                if (Entered_num1 % 2 == 0) {
                    sum_even = sum_even + Entered_num1;
                } else sum_odd = sum_odd + Entered_num1;
            } else break;
        }
        System.out.println(" The sum Even is:" + sum_even);
        System.out.println(" The sum Odd is:" + sum_odd);


        System.out.println("-------------------------------");
        System.out.println("7.Write a program that prompts the user to input a positive integer." +
                " It should then output a message indicating whether the number is a prime number.");

    /*    System.out.println("Kindly, Enter  input a positive integer");
        Entered_num1 = obj.nextInt();

        if (Entered_num1 <=1)
                System.out.println(Entered_num1 + " is not a prime number.");

        for (int i = 2; i <= Entered_num1 / 2; ++i) {

            if (Entered_num1 % i == 0) {
                System.out.println(Entered_num1 + " is a prime number.");
            }
            else System.out.println(Entered_num1 + " is not a prime number.");
        }*/

       // { /*// if (Entered_num1 <=1)
       //     System.out.println(Entered_num1 + " is not a prime number.");

     /*   for (int i = 2; i <= Entered_num1 / 2; ++i)
        {

            if (Entered_num1 % i == 0 || Entered_num1<=1) {
                System.out.println(Entered_num1 + " is not a prime number.");
              //  System.out.println(Entered_num1 + " is a prime number.");
            } else { System.out.println(Entered_num1 + " is a prime number.");
                break;   }

        }*/


        {

            System.out.print("Enter a Number: ");
            Entered_num1 = obj.nextInt();

            for ( int i = 2; i < Entered_num1; i++) {
                if (Entered_num1 % i == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0)
                System.out.println("\nIt is a Prime Number.");
            else
                System.out.println("\nIt is not a Prime Number.");

        }

            System.out.println("-------------------------------");
            System.out.println("8.Write a program to enter the numbers till the user wants" +
                    " and at the end it should display the count of positive, negative and zeros entered.");

            System.out.println("How many number do you want to enter");
            Entered_num2=obj.nextInt();
            for (int i = 1; i <= Entered_num2; i++) {
                System.out.println("Kindly, Enter number");
                Entered_num1 = obj.nextInt();
                if (Entered_num1 > 0) {
                    count_pos++;
                } else if (Entered_num1 < 0)
                    count_neg++;
                else count_zeros++;
            }
            System.out.println(" The count positive is:" + count_pos);
            System.out.println(" The count negative is:" + count_neg);
            System.out.println(" The count zeros is:" + count_zeros);


            System.out.println("-------------------------------");
            System.out.println("9.Use a for loop to print headings for four weeks (Weeks 1 - 4). " +
                    " Then use another for loop to print the days (Days 1 -7) for each week. ");
            for (int i = 1; i <= 4; i++) {
                System.out.println("Week" + i);
                for (int j = 1; j <= 7; j++)
                    System.out.println("Day" + j);
            }
            System.out.println("-------------------------------");
            System.out.println("10.Write a program that checks if the word is a palindrome or not. " +
                    " hint: A string is said to be a palindrome if it is the same if we start reading it " +
                    "from left to right or right to left.\n");


            System.out.println("Enter palindrome words");
            input = obj.nextLine();
            output = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                output = output + input.charAt(i);

            }

            if (input.equals(output))
                System.out.println(" it is palindrome Word" + output);
            else System.out.println(" it is  NOT palindrome Word" + output);


        }


    }








