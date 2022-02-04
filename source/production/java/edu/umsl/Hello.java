/*
Thomas Cholak
Professor Steve Riegerix
CMP SCI 2261
6 February 2022

Assignment: Code where you can enter a time and it will automatically provide you a new time that's 45 minutes earlier.
 */
package edu.umsl;

import java.util.Scanner;
import java.util.InputMismatchException; //imported for error handling

public class Hello {
    public static void main(String[] args)
    {
        boolean retry; //initialize boolean for a try-catch loop

        do {
            retry = false;
            try {
                System.out.println("Enter time with space between hours and minutes (ex: \"12 45\" for 12:45)"); //prompt
                Scanner reader = new Scanner(System.in); // Scanner named reader

                int[] nums = new int[2]; //size two array
                int i; //integer for storing the array

                for (i = 0; i < nums.length; i++) { //for loop for storing integers
                    nums[i] = reader.nextInt();
                }
                if (nums[0] < 0 || nums[1] < 0) {
                    System.out.println("Only positive numbers please!");
                    retry = true;
                } else {
                    int H = nums[0]; int M = nums[1]; //variables H for hours and M for minutes
                    if(H > 23 || M >= 60) {
                        System.out.println("Please make sure you're inputting a valid time."); //stop large numbers
                        retry = true; }
                    if (M >= 45 && M < 60 && H <= 23) {
                        if (M == 45) {
                            System.out.println("Your new time is " + H + ":00"); return;} //outputs an extra 0
                        if (M == 50){
                            System.out.println("Your new time is " + H + ":05"); //outputs a zero before the 5
                        } else {
                        System.out.println("Your new time is "); System.out.print(H + ":" + (M - 45)); }} // if 45 < M < 60
                    if (M < 45 && H <= 23) {
                        int b = M - 45;
                        System.out.println("Your new time is ");
                        if (H == 0){ //for when the hour is 0
                            System.out.print("23:" + (60 + b)); return;
                        }
                        if (H == 1) { //for when the hour is 1
                            System.out.print("0:" + (60 + b)); return;
                        } else {
                            System.out.print((H - 1) + ":" + (60 + b)); }
                    }
                }
            } catch (InputMismatchException ex) {
                retry = true;
                System.out.println("Please input a valid integer."); //stop letter input
            } catch (Exception ex) {
                retry = true;
                System.out.println("Please retry."); //stop all other input
            }
        } while (retry); //while loop

    }
}
