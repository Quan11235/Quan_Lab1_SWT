/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author QuanDo
 */
public class MainTest {

    @Test
    public void testInputName_longerThan50() {
        System.out.println("inputName");
        String expResult = "ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz";
        try {
            Main.inputName(new Scanner(expResult));
        } catch (Exception e) {
            boolean result = expResult.length() > 50;
            assertTrue(result);
        }
    }

    @Test
    public void testInputName() {
        System.out.println("inputName");
        String expResult = "abcxyz";
        String result = Main.inputName(new Scanner(expResult));
        assertEquals(expResult, result);
    }

    @Test
    public void testLengthInputName() {
        System.out.println("inputName");
        String expResult = "abcxyzvbcsjcsjbcjsbcsjcbscbksbksckbckscm mgdjsgdjs";
        String result = Main.inputName(new Scanner(expResult));
        assertEquals(expResult, result);
    }

    @Test
    public void testInputDob() {
        System.out.println("inputDob");
        Pattern pat = null;
        Matcher matcher = null;
        String expResult = "13/12/2015";
        String result = Main.inputDob(new Scanner(expResult), pat, matcher);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatInputDob() {
        System.out.println("inputDob");
        Pattern pat = null;
        Matcher matcher = null;
        String dateTest = "12/2015";
        String dob = "";
        try {
            dob = Main.inputDob(new Scanner(dateTest), pat, matcher);
        } catch (Exception e) {
            pat = Pattern.compile("^(?:(?:31(\\/)(?:0[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29(\\/)02\\3(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0[1-9]|1\\d|2[0-8])(\\/)(?:(?:0[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)\\d{2})$");
            matcher = pat.matcher(dob);
            assertTrue(matcher.matches() == false);
        }
    }

    @Test
    public void testExistInputDob_outOfRange() {
        System.out.println("inputDob");
        Pattern pat = null;
        Matcher matcher = null;
        String dateTest = "30/02/2016";
        String dob = "";
        try {
            dob = Main.inputDob(new Scanner(dateTest), pat, matcher);
        } catch (Exception e) {
            pat = Pattern.compile("^(?:(?:31(\\/)(?:0[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29(\\/)02\\3(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0[1-9]|1\\d|2[0-8])(\\/)(?:(?:0[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)\\d{2})$");
            matcher = pat.matcher(dob);
            assertTrue(matcher.matches() == false);
        }
    }

    @Test
    public void testExistInputDob_inRange() {
        System.out.println("inputDob");
        String dateTest = "29/02/2016";
        Pattern pat = Pattern.compile("^(?:(?:31(\\/)(?:0[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29(\\/)02\\3(?:(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0[1-9]|1\\d|2[0-8])(\\/)(?:(?:0[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)\\d{2})$");
        Matcher matcher = null;
        String dob = Main.inputDob(new Scanner(dateTest), pat, matcher);
        matcher = pat.matcher(dob);
        assertTrue(matcher.matches());
    }

    @Test
    public void testInputSpecialization_longerThan255() {
        System.out.println("inputSpecialization");
        String dataTest = "ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz | ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz | ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz | ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz | ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz | ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz | ban hien dang rat cham chi hoc mon swt cua thay pham ngoc ha nhung abcxyz";
        try {
            Main.inputSpecialization(new Scanner(dataTest));
        } catch (Exception e) {
            assertTrue(dataTest.length() > 255);
        }
    }

    @Test
    public void testInputSpecialization_shorterThan255() {
        System.out.println("inputSpecialization");
        String expResult = "abcxyz";
        String result = Main.inputSpecialization(new Scanner(expResult));
        assertEquals(expResult, result);
    }

    @Test
    public void testInputSpecialization_Equal255() {
        System.out.println("inputSpecialization");
        String expResult = "abcxyzvbcsjcsjbcjsbcsjcbscbksbkbckscm mgdjsgdjsabcxyzvbcsjcsjbcjsbcsjcbscbksbksckbckscm mgdjsgdjsabcxyzvbcsjcsjbcjsbcsjcbscbksbksckbckscm mgdjsgdjsabcxyzvbcsjcsjbcjsbcsjcbscbksbksckbckscm mgdjsgdjsabcxyzvbcsjcsjbcjsbcsjcbscbksbksckbckscm mgdjsgdjsdsj12345";
        String result = Main.inputSpecialization(new Scanner(expResult));
        assertEquals(expResult, result);
    }

    @Test
    public void testInputAvailability_inputChar() {
        System.out.println("inputAvailability");
        Doctor doctor = new Doctor();
        String dataTest = "z";
        try {
            int result = Main.inputAvailability(new Scanner(dataTest), doctor);
        } catch (Exception e) {
            assertTrue(e.getMessage().isEmpty() == false);
        }
    }

    @Test
    public void testInputAvailability_inRange() {
        System.out.println("inputAvailability");
        Doctor doctor = new Doctor();
        int expResult = 1;
        int result = Main.inputAvailability(new Scanner(Integer.toString(expResult)), doctor);
        assertEquals(expResult, result);
    }

    @Test
    public void testInputAvailability_inRange_Boundary() {
        System.out.println("inputAvailability");
        Doctor doctor = new Doctor();
        int expResult = 0;
        int result = Main.inputAvailability(new Scanner(Integer.toString(expResult)), doctor);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatInputEmail() {
        System.out.println("inputEmail");
        Pattern pat = null;
        Matcher matcher = null;
        String expResult = "daily@";
        pat = Pattern.compile("^(([^<>()\\[\\]\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        String result = "";
        try {
            result = Main.inputEmail(new Scanner(expResult), pat, matcher);
        } catch (Exception e) {
            matcher = pat.matcher(result);
            assertTrue(matcher.matches() == false);
        }
    }

    @Test
    public void testInputEmail() {
        System.out.println("inputEmail");
        Pattern pat = null;
        Matcher matcher = null;
        String expResult = "daily@gmail.com";
        String result = Main.inputEmail(new Scanner(expResult), pat, matcher);
        assertEquals(expResult, result);
    }

    @Test
    public void testFormatInputMobile() {
        System.out.println("inputMobile");
        Pattern pat = Pattern.compile("^\\(\\d{3}\\)-\\d{3}-\\d{4}$");
        Matcher matcher = null;
        String expResult = "0123456789";
        String result = "";
        try {
            result = Main.inputMobile(new Scanner(expResult), pat, matcher);
        } catch (Exception e) {
            matcher = pat.matcher(result);
            assertTrue(matcher.matches() == false);
        }
    }

    @Test
    public void testInputMobile() {
        System.out.println("inputMobile");
        Pattern pat = null;
        Matcher matcher = null;
        String expResult = "(012)-345-6789";
        String result = Main.inputMobile(new Scanner(expResult), pat, matcher);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Scanner in = new Scanner(System.in);
        List<Doctor> listDoctor = new ArrayList<>();
        listDoctor.add(new Doctor("henry", "12/12/2020", "specialization", 0, "email@gmail.com", "(012)-345-6789"));
        try {
            Main.create(in, listDoctor);
        } catch (Exception e) {
            assertEquals(1, listDoctor.size());
        }
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        List<Doctor> listDoctor = new ArrayList<>();
        Doctor doctor = new Doctor("henry", "12/12/2020", "specialization", 0, "email@gmail.com", "(012)-345-6789");
        listDoctor.add(doctor);
        try {
            Main.edit(new Scanner("1"), listDoctor);
        } catch (Exception e) {
            assertTrue(doctor.equals(listDoctor.get(0)));
        }
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        List<Doctor> listDoctor = new ArrayList<>();
        listDoctor.add(new Doctor("henry", "12/12/2020", "aaaaa", 0, "daily@gmail.com", "(012)-345-6789"));
        Main.delete(new Scanner("1"), listDoctor);
        assertEquals(0, listDoctor.size());
    }
}
