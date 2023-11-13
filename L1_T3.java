//Description: create a program that calculates and displays the average grade of a student. Prompt the user to enter the number of grades to be entered, and then input each grade. Calculate the average and display it to the user.

import java.util.Scanner;
public class L1_T3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of grades:- ");
        int grade=sc.nextInt();

        double sum=0;
        System.out.println("Enter the grades one by one");
        for(int i=0;i<grade;i++){
            double temp=sc.nextDouble();
            sum+=temp;
        }
        
        System.out.println("Average= "+String.format("%.2f", (sum / grade)));
        sc.close();
    }
}
