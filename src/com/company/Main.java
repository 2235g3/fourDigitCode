package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String compGenNum = Integer.toString(randGen()) + randGen() + randGen() + randGen();
        String userNum;
	int amtInRightPlace = 0;
        System.out.println(compGenNum);
	for (int i = 12; i > 0; i--) {
		System.out.println("You have " + i + " guesses left");
        	while (true) { 
            		System.out.println("Enter a 4 digit number:");
            		userNum = input();
            		if (userNum != "-1") {
                		break;
            		}
        	}
        	amtInRightPlace = numCompare(compGenNum, userNum);
		if (amtInRightPlace == 4) {
			System.out.println("You got all digits correct!\nYou had " + (i - 1) + " guesses left");
			break;
		}
	}
	if (amtInRightPlace < 4) {
		System.out.println("You lost!\nThe computer's number was " + compGenNum);
	}
    }
    public static String input() {
        Scanner input = new Scanner(System.in);
        try {
            int userIn = input.nextInt();
            String userInStr = Integer.toString(userIn);
            if (userInStr.length() == 4) {
                return userInStr;
            }
            else {
                System.out.println("Please enter a valid input\n");
                return "-1";
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid input\n");
            return "-1";
        }
    }
    public static int randGen() {
        Random rand = new Random();
        return (rand.nextInt(9-1+1) + 1);
    }
    public static int numCompare(String compGenNum, String userNum) {
	int amtInRightPlace = 0;
        for (int i = 0; i < 4; i++) {
            if (compGenNum.charAt(i) == userNum.charAt(i)) {
                System.out.println("Digit " + (i + 1) + " is in the right place");
		amtInRightPlace += 1;
            }
            else if (compGenNum.contains(String.valueOf(userNum.charAt(i)))) {
                System.out.println("Digit " + (i + 1) + " is not in the right position but is in the computer's number");
            }
            else {
                System.out.println("Digit " + (i + 1) + " is not in the right place");
            }
        }
    System.out.println("\n");
	return amtInRightPlace;
    }
}
