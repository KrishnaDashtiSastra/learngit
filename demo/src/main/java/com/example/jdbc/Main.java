package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/aliens";

        Connection con = DriverManager.getConnection(url, "root", "2022");
        Statement st = con.createStatement();

        int count = st.executeUpdate("insert into Student values('Rahul',1,'chennai')");
        System.out.println(count + " rows affected");
        
        ResultSet rs = st.executeQuery("select name from Student");
        while(rs.next()){
            String name = rs.getString("name");
            System.out.println(name);
        }
        st.close();
        con.close();

    }
}