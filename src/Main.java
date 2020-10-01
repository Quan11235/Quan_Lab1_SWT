
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

    private static List<Doctor> listDoctor = Doctor.listDoctor;
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
                    create(in, listDoctor);
                    break;
                case "2":
                    edit(in, listDoctor);
                    break;
                case "3":
                    delete(in, listDoctor);
                    break;
                case "4":
                    System.out.println(search(in, listDoctor));
                    break;
                case "5":
                    System.out.println(sort(listDoctor));
                    break;
                default:
                    break;
            }
        }
    }

    public static int create(Scanner in, List<Doctor> listDoctor) {
        Doctor doctor = new Doctor();

        System.out.print("Input name(not longer than 50 characters): ");
        String name = inputName(in);

        Pattern pat = null;
        Matcher matcher = null;
        System.out.print("Input date of birth(dd/MM/yyyy): ");
        String dob = inputDob(in, pat, matcher);

        System.out.print("Input specialization(not longer than 255 characters): ");
        String specialization = inputSpecialization(in);

        System.out.print("Input availability(0-3): ");
        int availability = inputAvailability(in, doctor);

        System.out.print("Input email: ");
        String email = inputEmail(in, pat, matcher);

        System.out.print("Input mobile(###)-###-####: ");
        String mobile = inputMobile(in, pat, matcher);

        Doctor addDoctor = new Doctor(name, dob, specialization, availability, email, mobile);
        listDoctor.add(addDoctor);
        return listDoctor.size();
    }

    public static void edit(Scanner in, List<Doctor> listDoctor) {
        System.out.println("Input ID of Doctor: ");
        int id = Integer.parseInt(in.nextLine());
        boolean found = false;
        while (found != true) {
            for (Doctor doctor : listDoctor) {
                if (id == doctor.getId()) {
                    System.out.print("Edit name(not longer than 50 characters): ");
                    String name = inputName(in);

                    Pattern pat = null;
                    Matcher matcher = null;
                    String dob = inputDob(in, pat, matcher);

                    System.out.print("Edit specialization(not longer than 255 characters): ");
                    String specialization = inputSpecialization(in);

                    System.out.print("Edit availability: ");
                    int availability = inputAvailability(in, doctor);

                    System.out.print("Edit email: ");
                    String email = inputEmail(in, pat, matcher);

                    System.out.print("Edit mobile(###)-###-####: ");
                    String mobile = inputMobile(in, pat, matcher);

                    doctor.setName(name);
                    doctor.setDob(dob);
                    doctor.setSpecialization(specialization);
                    doctor.setAvailability(availability);
                    doctor.setEmail(email);
                    doctor.setMobile(mobile);
                    found = true;
                }
            }
            if (found != true) {
                System.out.println("Not found.");
                break;
            }
        }
    }

    public static void delete(Scanner in, List<Doctor> listDoctor) {
        List<Doctor> removeList = new ArrayList<>();
        System.out.println("Input ID of Doctor: ");
        int id = Integer.parseInt(in.nextLine());
        boolean found = false;
        while (found != true) {
            for (Doctor doctor : listDoctor) {
                if (id == doctor.getId()) {
                    removeList.add(doctor);
                    found = true;
                }
            }
            listDoctor.removeAll(removeList);
            if (found != true) {
                System.out.println("Not found");
                break;
            }
        }
    }

    public static String search(Scanner in, List<Doctor> listDoctor) {
        StringBuilder tmp = new StringBuilder();
        boolean found = false;
        while (found != true) {
            System.out.println("Input ID of Doctor: ");
            int id = checkNumber(in);
            System.out.println("Input name of Doctor: ");
            String name = in.nextLine();
            for (Doctor doctor : listDoctor) {
                if (doctor.getId() == id && (doctor.getName().equalsIgnoreCase(name) || doctor.getName().contains(name))) {
                    tmp.append(doctor.toString());
                    found = true;
                }
            }
            if (found != true) {
                System.out.println("Not found");
                break;
            }
        }
        return tmp.toString();
    }

    public static String sort(List<Doctor> listDoctor) {
        StringBuilder tmp = new StringBuilder();
        Collections.sort(listDoctor);
        listDoctor.forEach((Doctor doctor) -> {
            tmp.append(doctor.toString() + "\n");
        });
        return tmp.toString();
    }

    public static int checkNumber(Scanner in) {
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

    public static String inputName(Scanner in) {
        String name;
        while (true) {
            name = in.nextLine();
            if (name.length() <= 50) {
                break;
            } else {
                System.out.println("Reinput: ");
            }
        }
        return name;
    }

    public static String inputDob(Scanner in, Pattern pat, Matcher matcher) {
        String dob;
        while (true) {
            dob = in.nextLine();
            pat = Pattern.compile(PATTERN_YEAR);
            matcher = pat.matcher(dob);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Incorrect date format or invalid date. Please reenter.");
            }
        }
        return dob;
    }

    public static String inputSpecialization(Scanner in) {
        String specialization;
        while (true) {
            specialization = in.nextLine();
            if (specialization.length() <= 255) {
                break;
            } else {
                System.out.println("Reinput: ");
            }
        }
        return specialization;
    }

    public static int inputAvailability(Scanner in, Doctor doctor) {
        boolean check = false;
        int availability = 0;
        while (check != true) {
            availability = checkNumber(in);
            for (int i : doctor.AVAILABILITY) {
                if (availability == i) {
                    check = true;
                    break;
                }
            }
            if (check != true) {
                System.out.println("Out of range");
            }
        }
        return availability;
    }

    public static String inputEmail(Scanner in, Pattern pat, Matcher matcher) {
        String email;
        while (true) {
            email = in.nextLine();
            pat = Pattern.compile(PATTERN_MAIL);
            matcher = pat.matcher(email);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Incorrect email address format. Please reenter.");
            }
        }
        return email;
    }

    public static String inputMobile(Scanner in, Pattern pat, Matcher matcher) {
        String mobile;
        while (true) {
            mobile = in.nextLine();
            pat = Pattern.compile(PATTERN_PHONE);
            matcher = pat.matcher(mobile);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Incorrect mobile format. Please reenter.");
            }
        }
        return mobile;
    }
}
