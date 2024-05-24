package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/aliens";
        String user = "root";
        String pass = "2022";
        String query = "select name from Student";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate("insert into Student values('Rahul',1,'chennai')");
        System.out.println(count + " rows affected");
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            String name = rs.getString("name");
            System.out.println(name);
        }


    }
}