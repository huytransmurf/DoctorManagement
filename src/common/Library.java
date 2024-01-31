/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Scanner;

public class Library {

    Scanner sc = new Scanner(System.in);

    public int getInt(String msg) {
        int number;
        while (true) {
            try {
                System.out.println(msg + ": ");
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input a number only!!");
            }
        }
        return number;
    }

    public double getDouble(String msg) {
        double number;
        while (true) {
            try {
                System.out.println(msg + ": ");
                number = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input a number only!!");
            }
        }
        return number;
    }

    public String getString(String msg) {
        System.out.println(msg + ": ");
        return sc.nextLine();
    }
}
