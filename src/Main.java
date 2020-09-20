
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * (C) Copyright Expression year is undefined on line 11, column 20 in
 * Templates/Classes/Main.java. Fresher Academy. All Right Reserved.
 *
 * @Date Sep 14, 2020
 * @Author QuanDo
 */
public class Main {

    private static List<Doctor> listDoctor = new ArrayList<>();
    // year from 1600
    private static final String PATTERN_YEAR = "^(?:(?:31(\\/)(?:0[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29(\\/)02\\3(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0[1-9]|1\\d|2[0-8])(\\/)(?:(?:0[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)\\d{2})$";
    private static final String PATTERN_MAIL = "^(([^<>()\\[\\]\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static final String PATTERN_PHONE = "^\\(\\d{3}\\)-\\d{3}-\\d{4}$";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {
            System.out.print("--------------------- Doctor Management System ---------------------"
                    + "\n1. Create a Doctor."
                    + "\n2. Edit a Doctor Information."
                    + "\n3. Delete a Doctor."
                    + "\n4. Search Doctor by ID and by Name."
                    + "\n5. Sort Doctor by DateOfBirth"
                    + "\n0. Exit"
                    + "\nPlease choose your task(0-5): ");
            Scanner in = new Scanner(System.in);
            String choose = in.nextLine();
            switch (choose) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    create(in, (ArrayList<Doctor>) listDoctor);
                    break;
                case "2":
                    edit(in, listDoctor);
                    break;
                case "3":
                    delete(in, listDoctor);
                    break;
                case "4":
                    search(in, listDoctor);
                    break;
                case "5":
                    sort(listDoctor);
                    break;
                default:
                    break;
            }
        }
    }

    private static void create(Scanner in, ArrayList<Doctor> listDoctor) {
        Doctor doctor = new Doctor();
        String name = null;
        while (true) {
            System.out.print("Input name(not longer than 50 characters): ");
            name = in.nextLine();
            if (name.length() <= 50) {
                break;
            }
        }
        Pattern pat;
        Matcher matcher;
        String dob = null;
        while (true) {
            System.out.print("Input date of birth(dd/MM/yyyy): ");
            dob = in.nextLine();
            pat = Pattern.compile(PATTERN_YEAR);
            matcher = pat.matcher(dob);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Incorrect date format or invalid date. Please reenter.");
            }
        }
        String specialization = null;
        while (true) {
            System.out.print("Input specialization(not longer than 255 characters): ");
            specialization = in.nextLine();
            if (specialization.length() <= 255) {
                break;
            }
        }
        boolean check = false;
        int availability = 0;
        while (check != true) {
            System.out.print("Input availability(0-3): ");
            availability = checkNumber(in);
            for (int i : doctor.AVAILABILITY) {
                if (availability == i) {
                    check = true;
                    break;
                }
            }
        }
        String email = null;
        while (true) {
            System.out.print("Input email: ");
            email = in.nextLine();
            pat = Pattern.compile(PATTERN_MAIL);
            matcher = pat.matcher(email);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Incorrect email address format. Please reenter.");
            }
        }
        String mobile = null;
        while (true) {
            System.out.print("Input mobile(###)-###-####: ");
            mobile = in.nextLine();
            pat = Pattern.compile(PATTERN_PHONE);
            matcher = pat.matcher(mobile);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Incorrect mobile format. Please reenter.");
            }
        }
        int id = 1;
        if (!listDoctor.isEmpty()) {
            id = listDoctor.get(listDoctor.size() - 1).getId() + 1;
        }
        Doctor addDoctor = new Doctor(id, name, dob, specialization, availability, email, mobile);
        listDoctor.add(addDoctor);
        System.out.println("Done!");
    }

    private static void edit(Scanner in, List<Doctor> listDoctor) {
        System.out.println("Input ID of Doctor: ");
        int id = Integer.parseInt(in.nextLine());
        for (Doctor doctor : listDoctor) {
            if (id == doctor.getId()) {
                String name = null;
                while (true) {
                    System.out.print("Edit name(not longer than 50 characters): ");
                    name = in.nextLine();
                    if (name.length() <= 50) {
                        break;
                    }
                }
                String dob = null;
                Pattern pat;
                Matcher matcher;
                while (true) {
                    System.out.print("Edit date of birth(dd/MM/yyyy): ");
                    dob = in.nextLine();
                    pat = Pattern.compile(PATTERN_YEAR);
                    matcher = pat.matcher(dob);
                    if (matcher.find()) {
                        break;
                    } else {
                        System.out.println("Incorrect date format or invalid. Please reenter.");
                    }
                }
                String specialization = null;
                while (true) {
                    System.out.print("Edit specialization(not longer than 255 characters): ");
                    specialization = in.nextLine();
                    if (specialization.length() <= 255) {
                        break;
                    }
                }
                System.out.print("Edit availability: ");
                int availability = checkNumber(in);
                String email = null;
                while (true) {
                    System.out.print("Edit email: ");
                    email = in.nextLine();
                    pat = Pattern.compile(PATTERN_MAIL);
                    matcher = pat.matcher(email);
                    if (matcher.find()) {
                        break;
                    } else {
                        System.out.println("Incorrect email address format. Please reenter.");
                    }
                }
                String mobile = null;
                while (true) {
                    System.out.print("Edit mobile(###)-###-####: ");
                    mobile = in.nextLine();
                    pat = Pattern.compile(PATTERN_PHONE);
                    matcher = pat.matcher(mobile);
                    if (matcher.find()) {
                        break;
                    } else {
                        System.out.println("Incorrect mobile format. Please reenter.");
                    }
                }
                doctor.setName(name);
                doctor.setDob(dob);
                doctor.setSpecialization(specialization);
                doctor.setAvailability(availability);
                doctor.setEmail(email);
                doctor.setMobile(mobile);
                break;
            }
        }
        System.out.println("Done!");
    }

    private static void delete(Scanner in, List<Doctor> listDoctor) {
        System.out.println("Input ID of Doctor: ");
        int id = Integer.parseInt(in.nextLine());
        for (Doctor doctor : listDoctor) {
            if (id == doctor.getId()) {
                listDoctor.remove(doctor);
                break;
            }
        }
        System.out.println("Done!");
    }

    private static void search(Scanner in, List<Doctor> listDoctor) {
        boolean found = false;
        while (found != true) {
            System.out.println("Input ID of Doctor: ");
            int id = checkNumber(in);
            System.out.println("Input name of Doctor: ");
            String name = in.nextLine();
            for (Doctor doctor : listDoctor) {
                if (doctor.getId() == id && doctor.getName().equalsIgnoreCase(name)) {
                    System.out.println(doctor.toString());
                    found = true;
                }
            }
            if (found != true) {
                System.out.println("Not found");
            }
        }
        System.out.println("Done!");
    }

    private static void sort(List<Doctor> listDoctor) {
        Collections.sort(listDoctor);
        listDoctor.forEach((Doctor doctor) -> {
            System.out.println(doctor.toString());
        });
        System.out.println("Done!");
    }

    private static int checkNumber(Scanner in) {
        int tmp = 0;
        while (true) {
            try {
                tmp = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Please input again: ");
            }
        }
        return tmp;
    }
}
