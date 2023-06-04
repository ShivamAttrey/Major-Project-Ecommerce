package com.example.ecommerce;

import java.sql.ResultSet;

public class Login {

    //    public boolean customerLogin(String userName, String password) {
//        String loginQuery = "SELECT * FROM customer WHERE email = `" + userName + "` AND password = " + password + "' ";
//        Dbconnection conn = new Dbconnection();
//        ResultSet rs = conn.getQueryTable(loginQuery);
//        try {
//            if (rs.next())
//                return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//public static void main(String[] args) {
//    Login login = new Login();
//
//    System.out.println(login.customerLogin("shivamattrey25@gmail.com", "abc123"));
//
//}
//}
    public Customer customerLogin(String userName, String password) {
        String loginQuery = "SELECT * FROM customer WHERE email = '" + userName + "' AND password = '" + password + "' ";
        Dbconnection conn = new Dbconnection();
        ResultSet rs = conn.getQueryTable(loginQuery);
        try {
            if (rs.next())
                return new Customer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("mobile"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Login login = new Login();
        Customer customer = login.customerLogin("shivamattrey25@gmail.com", "abc123");

        System.out.println("Welcome : " +customer.getName());

    }
}