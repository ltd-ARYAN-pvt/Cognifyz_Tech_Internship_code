// Description: Create a program that converts temperatures between Celsius and Fahrenheit. Prompt the user to enter a temperature value and the unit of measurement, and then perform the conversion. Display the converted temperature.
import java.util.Scanner;

public class L1_T1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double returnVal;
        System.out.print("Enter the temperature value:- ");
        double val=sc.nextDouble();
        System.out.println();
        System.out.print("Enter the unit of measurement (1 if Celsius and 2 for Fahrenheit):- ");
        int unit=sc.nextInt();
        sc.close();
        switch (unit) {
            case 1:
                returnVal=(val*9/5)+32;
                System.out.println("Your Entered temperature is "+val+" degrees Celsius");
                System.out.println("Your Converted temperature is "+returnVal+" degrees Fehrenheit");
                break;
            case 2:
                returnVal=(val-32)*5/9;
                System.out.println("Your Entered temperature is "+val+" degrees Fehrenheit");
                System.out.println("Your Converted temperature is "+returnVal+" degrees Celsius");
                break;
        
            default:
                System.out.println("Enter Correct number for unit of measurment");
                break;
        }
    }
}
