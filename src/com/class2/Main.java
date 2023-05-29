package com.class2;

public class Main {
    public static void main(String[] args) {
        try {
            JSONManagement jsonManagement = new JSONManagement();
             jsonManagement.readJSONPerson();
            jsonManagement.readJSONFromAPI();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
