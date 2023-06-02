package com.class2;

public class Main {
    public static void main(String[] args) {
        try {
            JSONManagement jsonManagement = new JSONManagement();
          /*  jsonManagement.readJSONFromAPI();*/
            /*jsonManagement.deleteApi(2);*/
            jsonManagement.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
