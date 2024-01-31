/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author LAPTOP ACER
 */
public class DoctorList extends ArrayList<Doctor>{

    public DoctorList() {
        loadData("doctors.txt");
    }
    
     public void loadData(String fName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner sc = new Scanner(new FileReader(fName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] bi = line.split(",");
                this.add(new Doctor(bi[0].trim(),bi[1].trim(),bi[2].trim(),Integer.parseInt(bi[3].trim())));
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not exist");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("out of bound");
        }
    }

  
    public ArrayList<Doctor> search (Predicate<Doctor> p){
        ArrayList<Doctor> dList = new ArrayList<>();
        for (Doctor d : this){
            if (p.test(d))
                dList.add(d);
        }
        return dList;
    }

}
