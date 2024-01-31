/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import common.Library;
import java.util.ArrayList;
import model.Doctor;
import model.DoctorList;
import view.Menu;

/**
 *
 * @author LAPTOP ACER
 */
public class DoctorManagement extends Menu<String> {

    private static DoctorList dList = new DoctorList();
    private static String[] mc = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
    private Library lib = new Library();

    public DoctorManagement() {
        super("DOCTOR MANAGEMNET",mc);
    }
    

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doAddDOctor();
                break;
            case 2:
                doUpdateDoctor();
                break;
            case 3:
                doDeleteDoctor();
                break;
            case 4:
                doSearch();
                break;
            case 5:
                System.out.println("Exitting...");
                System.exit(0);
        }
    }

  

    public void doAddDOctor() {
        String code = lib.getString("Enter code");
        String name = lib.getString("Enter name");
        String special = lib.getString("Enter specialization");
        int avai = lib.getInt("Enter availability");
        if (dList.search(p -> (p.getCode().equals(code))).isEmpty()) {
            dList.add(new Doctor(code, name, special, avai));
            System.out.println("Add new doctor succefully!!");
        } else {
            System.out.println("Duplicated doctor's code!!");
        }
    }

    public void doUpdateDoctor() {
        String code = lib.getString("Enter code");
        ArrayList<Doctor> d = dList.search(p -> p.getCode().equals(code));
        if (!d.isEmpty()) {
            String name = lib.getString("Enter new name");
            String special = lib.getString("Enter new specialization");
            int avai = lib.getInt("Enter new availability");
            d.get(0).setName(name);
            d.get(0).setSpecialization(special);
            d.get(0).setAvailability(avai);
            System.out.println("Update doctor successfully!!");
        } else System.out.println("Code not exist!!");
    }
    public void doDeleteDoctor(){
        String code = lib.getString("Enter code");
        ArrayList<Doctor> d = dList.search(p -> p.getCode().equals(code));
        if (!d.isEmpty()){
            dList.remove(d.get(0));
            System.out.println("Delete doctor successfully!!");
        } else System.out.println("Code not exist!!");
    }
    public void doSearch(){
        String code = lib.getString("Enter code");
        ArrayList<Doctor> d = dList.search(p -> p.getCode().contains(code));
        if (!d.isEmpty()){
            System.out.println(String.format("%7s %10s %15s %12s","CODE", "NAME", "SPECIALIZATION", "AVAILABILITY"));
            for(Doctor doc: d){
                System.out.println(doc);
            }
        } else System.out.println("Not found!!");
    }
}
