//Description: Create a program that encrypts or decrypts the contents of a text file using a simple encryption algorithm. Prompt the user to choose between encryption or decryption, and input the file name or path. Encrypt or decrypt the file accordingly and save the result to a new file.

import java.io.*;
import java.util.Scanner;

//Caesar cipher Algorithm

public class L2_T3 {
    private static int encript(String text,String ofname){
        StringBuilder result = new StringBuilder();
        for(char c : text.toCharArray()){
            if(Character.isLetter(c)){
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char)((c - base + 3) % 26 + base));
            } 
            else{
                result.append(c);
            }
        }
        try{
            FileWriter f=new FileWriter(ofname);
            f.write(result.toString());
            f.close();
            System.out.println("\n Check The created file "+ofname);
            return 1;
        }
        catch(IOException e){
            System.out.println("Unable to create new file");
            return 0;
        }
    }
    private static int decript(String text,String ofname){
        StringBuilder result = new StringBuilder();
        for(char c : text.toCharArray()){
            if(Character.isLetter(c)){
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char)((c - base - 3 + 26) % 26 + base));
            } 
            else{
                result.append(c);
            }
        }
        try{
            FileWriter f=new FileWriter(ofname);
            f.write(result.toString());
            f.close();
            System.out.println("\n Check The created file "+ofname);
            return 2;
        }
        catch(IOException e){
            System.out.println("Unable to create new file");
            return 0;
        }
    }
    public static void main(String[] args) {
        int flag=0;
        Scanner sc=new Scanner(System.in);

        do{
            System.out.print("Enter the input file_name.txt or path: ");
            String ifname=sc.next();
            System.out.print("Enter the output file_name.txt or path: ");
            String ofname=sc.next();
            
            System.out.println();
            System.out.print("Enter 0 for Encrypting the file else 1 for decrypting: ");
            int dec=sc.nextInt();

            switch (dec) {
                case 0:
                    File f=new File(ifname);
                    try{
                        String line="";
                        Scanner sf=new Scanner(f);
                        while(sf.hasNextLine()){
                            line=line+sf.nextLine()+"\n";    
                        }
                        sf.close();
                        System.out.println("Before Encrption:- ");
                        System.out.println(line);
                        flag=encript(line,ofname);
                    } catch(FileNotFoundException e){
                        System.out.println("File name or path is incorrect.!!! Write again");
                        flag=0;
                    }
                    
                    break;
                case 1:
                    File f2=new File(ifname);
                    try{
                        String line="";
                        Scanner sf=new Scanner(f2);
                        while(sf.hasNextLine()){
                            line=line+sf.nextLine()+"\n";    
                        }
                        sf.close();
                        System.out.println("Before Decrption:- ");
                        System.out.println(line);
                        flag=decript(line,ofname);                       
                    } catch(FileNotFoundException e){
                        System.out.println("File name or path is incorrect.!!! Write again");
                        flag=0;
                    }
                    break;
                default:
                    System.out.println("Enter Valid number!!!!");
                    break;
            }
        }while(flag==0);
        sc.close();
    }
} 