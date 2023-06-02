package com.class2;

import com.class2.util.DBUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class JSONManagement {
    public void readJSONPerson() throws Exception {
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("person.json"));

            JSONObject jsonObject = (JSONObject) obj;
            Person person = new Person();

            String firstName = jsonObject.get("firstName").toString();
            String lastName = jsonObject.get("lastName").toString();
            int id = Integer.parseInt(jsonObject.get("id").toString());
            String email= jsonObject.get("email").toString();
            String department = jsonObject.get("department").toString();
            String position= jsonObject.get("position").toString();
            String hireDate= jsonObject.get("hireDate").toString();
            int salary = Integer.parseInt(jsonObject.get("salary").toString());
            boolean active = Boolean.parseBoolean(jsonObject.get("active").toString());
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setId(id);
            person.setActive(active);
            person.setDepartment(department);
            person.setEmail(email);
            person.setPosition(position);
            person.setHireDate(hireDate);
            person.setSalary(salary);
            System.out.println(person.toString());

            Map mapAddress = (Map) jsonObject.get("address");
            String streetAddress = mapAddress.get("streetAddress").toString();
            String city = mapAddress.get("city").toString();
            String state = mapAddress.get("state").toString();
            String postalCode = mapAddress.get("postalCode").toString();

            System.out.println(streetAddress);
            System.out.println(city);
            System.out.println(state);
            System.out.println(postalCode);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    public boolean addApi(API api) throws Exception {
        try {
            Connection connection = DBUtil.getConnection();
            CallableStatement callableStatement
                    = connection.prepareCall("{call sp_post(?, ?, ?, ?)}");
            callableStatement.setInt(1, api.getId());
            callableStatement.setInt(2, api.getUserId());
            callableStatement.setString(3, api.getTitle());
            callableStatement.setString(4, api.getBody());

            return ( callableStatement.executeUpdate() > 0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public boolean deleteApi(int id) throws Exception {
        try {
            Connection connection = DBUtil.getConnection();
            CallableStatement callableStatement
                    = connection.prepareCall("{call sp_DeleteById(?)}");
                callableStatement.setInt(1, id);
            return ( callableStatement.executeUpdate() > 0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void getAll() throws Exception {
        try {
            Connection connection = DBUtil.getConnection();
            Statement stmt= connection.createStatement();
            ResultSet rs = stmt.executeQuery("{call sp_GetAll}");
            while (rs.next()){
                System.out.println("=====API======");
                int id = rs.getInt("id");
                System.out.println(id);
                int userID = rs.getInt("userID");
                System.out.println(userID);
                String title = rs.getString("titile");
                System.out.println(title);
                String body = rs.getString("body");
                System.out.println(body);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void readJSONFromAPI() throws Exception {
        try {
            String apiUrl = "https://jsonplaceholder.typicode.com/posts";
            URL url = new URL(apiUrl);
            API api = new API();
            // Create connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            org.json.JSONArray jsonArray = new org.json.JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject product
                        = (org.json.JSONObject) jsonArray.get(i);
                int Id = Integer.parseInt(product.get("id").toString());
                int userId = Integer.parseInt(product.get("userId").toString());
                String title = product.get("title").toString();
                String body = product.get("body").toString();
                api.setId(Id);
                api.setUserId(userId);
                api.setTitle(title);
                api.setBody(body);
                addApi(api);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
