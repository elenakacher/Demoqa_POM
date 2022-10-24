package com.telran.utils;

import com.telran.data.StudentDataDP;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> createNewStudentFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/St_demoqa.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new StudentDataDP()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setMobile(split[3])
                    .setDateOfBirth(split[4])
                    .setAddress(split[5])});

            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> usingFile() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/St_demoqa.csv")
        ));
        List<Object[]> studentData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            studentData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return studentData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> usingGuestFile() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/Guest.csv")
        ));
        List<Object[]> guestData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            guestData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return guestData.iterator();
    }
}
