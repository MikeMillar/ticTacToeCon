package com.mikemillar;

import java.util.Random;
import java.util.Scanner;

public class Main {
    
    private static Scanner s = new Scanner(System.in);
    public static boolean gameOver = false;
    public static char spotValue[][] = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };
    private static Random rand = new Random();
    
    public static void main(String[] args) {
	// write your code here
        
        setup();
        while (!gameOver) {
            update();
            while (true) {
                if (logic()) {
                    break;
                }
            }
        }
        
    }
    
    public static void setup() {
        System.out.println("Welcome to Console Tic-Tac-Toe\n" +
                "Be the first to get 3 of your symbols in a row.\n" +
                "You will be the 'X' symbol.\n" +
                "To play, type row number, enter, then col number.\n" +
                "good luck! Press enter when ready");
        s.nextLine();
    }
    
    public static void update() {
        drawBoard();
    }
    
    public static boolean logic() {
        System.out.print("Enter row: ");
        int row = s.nextInt();
        System.out.println("Enter col: ");
        int col = s.nextInt();
        if (row > 0 && row < 4 && col > 0 && col < 4) {
            if (spotValue[row-1][col-1] != ' ') {
                System.out.println("Spot not available, try again.");
                return false;
            } else {
                spotValue[row-1][col-1] = 'X';
                if (checkForWin()) {
                    System.out.println("Player won!");
                    gameOver = true;
                }
                 if (!gameOver) {
                     computerMove();
                     if (checkForWin()) {
                         System.out.println("Computer won!");
                         gameOver = true;
                     }
                 }
                return true;
            }
        }
        System.out.println("Invalid row or col, try again. (1-3)");
        return false;
    }
    
    public static void computerMove() {
        while (true) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if (spotValue[row][col] == ' ') {
                spotValue[row][col] = 'O';
                break;
            }
        }
    }
    
    public static boolean checkForWin() {
        if ((spotValue[0][0] == spotValue[0][1] && spotValue[0][1] == spotValue[0][2]) && spotValue[0][0] != ' ') {
            return true;
        } else if ((spotValue[1][0] == spotValue[1][1] && spotValue[1][1] == spotValue[1][2]) && spotValue[1][0] != ' ') {
            return true;
        } else if ((spotValue[2][0] == spotValue[2][1] && spotValue[2][1] == spotValue[2][2]) && spotValue[2][0] != ' ') {
            return true;
        } else if ((spotValue[0][0] == spotValue[1][0] && spotValue[1][0] == spotValue[2][0]) && spotValue[0][0] != ' ') {
            return true;
        } else if ((spotValue[0][1] == spotValue[1][1] && spotValue[1][1] == spotValue[2][1]) && spotValue[0][1] != ' ') {
            return true;
        } else if ((spotValue[0][2] == spotValue[1][2] && spotValue[1][2] == spotValue[2][2]) && spotValue[0][2] != ' ') {
            return true;
        } else if ((spotValue[0][0] == spotValue[1][1] && spotValue[1][1] == spotValue[2][2]) && spotValue[0][0] != ' ') {
            return true;
        } else if ((spotValue[2][0] == spotValue[1][1] && spotValue[1][1] == spotValue[0][2]) && spotValue[2][0] != ' ') {
            return true;
        } else {
            return false;
        }
    }
    
    public static void drawBoard() {
        System.out.println(
                "   |   |   \n" +
                " " + spotValue[0][0] + " | " + spotValue[0][1] + " | " + spotValue[0][2] + " \n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                " " + spotValue[1][0] + " | " + spotValue[1][1] + " | " + spotValue[1][2] + " \n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                " " + spotValue[2][0] + " | " + spotValue[2][1] + " | " + spotValue[2][2] + " \n" +
                "   |   |   \n");
    }
}
