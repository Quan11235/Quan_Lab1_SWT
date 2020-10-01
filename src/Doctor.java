
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @Date Sep 15, 2020
 * @Author QuanDo
 */
public class Doctor implements Comparable<Doctor> {

    private int id = 0;
    private String name;
    private String dob;
    private String specialization;
    private int availability;
    public final int[] AVAILABILITY = {0, 1, 2, 3};
    private String email;
    private String mobile;
    public static List<Doctor> listDoctor = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(String name, String dob, String specialization, int availability, String email, String mobile) {
        if (!listDoctor.isEmpty()) {
            this.id = listDoctor.get(listDoctor.size() - 1).getId() + 1;
        } else {
            this.id = 1;
        }
        this.name = name;
        this.dob = dob;
        this.specialization = specialization;
        this.availability = availability;
        this.email = email;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", specialization=" + specialization + ", availability=" + availability + ", email=" + email + ", mobile=" + mobile + '}';
    }

    @Override
    public int compareTo(Doctor t) {
        return this.getDob().compareTo(t.getDob());
    }

}
